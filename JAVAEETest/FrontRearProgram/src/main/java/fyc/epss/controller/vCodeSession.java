package fyc.epss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.domain.admin;
import fyc.epss.services.adminServiceImpl;
import fyc.epss.utils.DataFlexPacking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/admin/login.do")
public class vCodeSession extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminName = req.getParameter("adminName");
        String password = req.getParameter("password");
        String vcode = req.getParameter("vcode");
        System.out.println(vcode);
        HttpSession session = req.getSession();
        String scode = session.getAttribute("code").toString();
        System.out.println(scode);
        DataFlexPacking mad = null;



        if (vcode.equalsIgnoreCase(scode)){
            adminServiceImpl adminService = new adminServiceImpl();
            admin result = adminService.select(adminName,password);
            if (result.getId()==null){
                mad = DataFlexPacking.fail("用户名密码不匹配");
            }else {
                req.getSession().setAttribute("status",true);
                req.getSession().setAttribute("name",result.getAdminName());
                req.getSession().setMaxInactiveInterval(60000000);
                mad = DataFlexPacking.success("欢迎！");
            }
        }else {
            mad = DataFlexPacking.fail("验证码错误");
        }

        //转换为JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String ret = objectMapper.writeValueAsString(mad);
        //返回给view,因为是前后端分离，交互JSON数据，需要告知客户端
        PrintWriter writer = resp.getWriter();
        writer.print(ret);
        writer.flush();


    }
}
