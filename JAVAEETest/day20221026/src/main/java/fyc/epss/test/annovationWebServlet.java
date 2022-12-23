package fyc.epss.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.utils.DButils;
import fyc.epss.utils.food;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "annovationWebServlet", value = "/annovationWebServlet")
@WebServlet(urlPatterns = "/hello"/*,loadOnStartup = 1*/)
public class annovationWebServlet extends HttpServlet {

    private Connection conn = DButils.getConn();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public void init() throws ServletException {
        System.out.println("1运行了");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doProcess(req, resp);
    }
    protected void doProcess(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String s ="";
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("userName");
        String password = req.getParameter("password");
        String flag = "";

        PrintWriter writer = resp.getWriter();

        /*if ("zs".equals(name) && "123".equals(password)){
            flag = "登陆成功";
        }else {flag = "登陆失败";}*/


        String sql = "select * from food";
        List<food> foods = new ArrayList<>();
        try{

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                foods.add(new food(rs.getString("foodName"),
                        rs.getDouble("foodPrice"),rs.getInt("aid")).setId(rs.getInt("id")));
            }
            ObjectMapper objectMapper = new ObjectMapper();
            s = objectMapper.writeValueAsString(foods);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,null);
        }
        for (food f:foods) {
            flag += f + "\n";
        }
/*        writer.println("<!DOCTYPE html>");
        writer.println("<html lang=\"en\">");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("<title>Title</title>");
        writer.println("</head>");
        writer.println("<body>"+flag+"</body>");
        writer.println("</html>");*/
        writer.println(s);
        writer.close();
    }

    public void destroy() {
        System.out.println("结束了");
        DButils.close(null,null,conn);
    }
}
