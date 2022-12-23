package fyc.epss.controller;

import fyc.epss.domain.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;

//    @ResponseBody可以加在类上,所有的方法都生效
//@ResponseBody
@RequestMapping("hello")//给应用路径下添加虚拟节点http://localhost:8080/myBatisGenerator_war/hello
@Controller
public class HelloController {
//    @ResponseBody
    @RequestMapping("/h1")
    public String hello1() throws Exception {
        return "a.jsp";
    }

    @ResponseBody
    @GetMapping("/h2")//method = {RequestMethod.GET}
    @PostMapping("/h2")//method = {RequestMethod.POST}
    @RequestMapping(value = "/h2",method = {RequestMethod.GET,RequestMethod.POST})//http://localhost:8080/myBatisGenerator_war/hello/h2
    public String hello2() {
        return "222";
    }
    @ResponseBody
    @RequestMapping(path = "/h3")
    public String hello3() {
        return "333";
    }

    @ResponseBody
    @GetMapping("/h5")
    public String hello5(String uname,Integer age,Double salary,String[] hobby){
        String ret = "uname:"+uname+"age:"+(++age)+"salary:"+salary;
        for (String i:hobby) {
            ret += i+"//";
        }
        return ret;
    }

    @ResponseBody
    @GetMapping("/h6")
    public String hello6(@RequestParam(value = ("username"),required = false,defaultValue = "guest") String uname,Integer age,Double salary,String[] hobby){
        String ret = "uname:"+uname+"age:"+(++age)+"salary:"+salary;
        for (String i:hobby) {
            ret += i+"//";
        }
        return ret;
    }

    @ResponseBody
    @RequestMapping("/h7")
    public String hello7(Admin admin) {
        return admin.toString();
    }

    @RequestMapping("/h8")
    public String hello8(Admin admin, HttpSession httpSession, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("application/json;charset=utf-8");
        httpSession.setMaxInactiveInterval(30);
        httpSession.setAttribute("loginStatus",true);
        httpSession.setAttribute("uname",admin.getAdminname());
        String ret = "";
        if (admin.getAdminname().equals("fyc")&&admin.getPassword().equals("456789")){
            System.out.println("Login SUCCESS");
            ret = "../index.jsp";
//            resp.sendRedirect("index.jsp");//webapp根目录下可直接用重定向
        }else {ret = "../.jsp";System.out.println("Login FAIL");}
        return ret;
    }
}
