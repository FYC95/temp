package fyc.epss.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class SessionLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String pass = req.getParameter("password");
        if ("zs".equals(name) && "123".equals(pass)){
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(60*60);
            session.setAttribute("sta",true);
            session.setAttribute("name",name);
            System.out.println("Login SUCCESS");
        }else {
            System.out.println("Login FAIL");
        }
    }
}
