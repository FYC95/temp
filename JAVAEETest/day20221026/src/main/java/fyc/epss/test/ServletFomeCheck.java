package fyc.epss.test;

import fyc.epss.utils.DButils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "ServletFomeCheck", value = "/ServletFomeCheck")
public class ServletFomeCheck extends HttpServlet {
    protected void doProcess(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();
        writer.println("return: ");
        if ("zs".equals(name) && "123".equals(password)){
            writer.println("success");
        }else {writer.println("faild");}
        writer.close();
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        this.doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        this.doProcess(req, resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("3执行了");
    }
}
