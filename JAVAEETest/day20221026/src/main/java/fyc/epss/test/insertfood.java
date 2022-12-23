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

@WebServlet("/insert-food")
public class insertfood extends HttpServlet {

    private Connection conn = DButils.getConn();
    private PreparedStatement ps = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doProcess(req, resp);
    }
    protected void doProcess(HttpServletRequest req,HttpServletResponse resp) throws IOException{
//        resp.setContentType("application/json;charset=utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        /*String name = req.getParameter("name");
        String explain = req.getParameter("explain");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer bid = Integer.valueOf(req.getParameter("bid"));*/
        String name = req.getParameter("foodName");
        String explain = req.getParameter("foodExplain");
        Double price = Double.valueOf(req.getParameter("foodPrice"));
        Integer bid = Integer.valueOf(req.getParameter("bid"));
        String flag = "";
        String sql = "insert into food (foodName,foodExplain,foodPrice,aid) values (?,?,?,?)";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,explain);
            ps.setDouble(3, price);
            ps.setInt(4, bid);
//            ps.execute();
            int i = ps.executeUpdate();
            if(i>0){
                flag = "插入数据成功";
            }else{
                flag = "插入数据失败";
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DButils.close(null,ps,null);
        }
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");//返回的数据类型是HTML
        writer.print(flag);
        /*writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("  <head><meta charset='UTF-8'>");
        writer.println("  <title>Servlet</title></head>");
        writer.println("  <body>");
        writer.println("返回状态：" + flag + "！");
        writer.println("  </body>");
        writer.println("</html>");
        writer.close();*/

    }




}
