package fyc.epss.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/login-session")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("userName");
        String pass = req.getParameter("password");
        if ("zs".equals(name) && "123".equals(pass)){
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(60*60);
            session.setAttribute("sta",true);
            session.setAttribute("name",name);
            System.out.println("Login SUCCESS");
            //跳转到管理界面
//            String s = req.getContextPath();//获取当前发布路径
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/Administrator.jsp");
            requestDispatcher.forward(req,resp);//安全路径下采用转发模式
//            resp.sendRedirect("Administrator.jsp");//webapp根目录下可直接用重定向
        }else {
            System.out.println("Login FAIL");
//            resp.sendRedirect("index.jsp?mes=登录信息有误");//中文乱码
            resp.sendRedirect(req.getContextPath() + "/index.jsp?mes="+ URLEncoder.encode("登录信息有误", StandardCharsets.UTF_8));
        }
    }
}
