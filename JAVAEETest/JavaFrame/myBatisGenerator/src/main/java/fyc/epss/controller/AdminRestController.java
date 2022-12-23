package fyc.epss.controller;

import fyc.epss.domain.Admin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

//@ResponseBody
@RestController
@RequestMapping(value = "/adminrest")
public class AdminRestController {
//    @PostMapping(value="/opt")
    @RequestMapping(value = "/opt",method = {RequestMethod.POST})
    public String add(Admin admin) {
        return admin.toString();
    }

    @DeleteMapping(value="/opt/{aid}")
    public String delete(@PathVariable("aid") Integer id){
        return "DELETE"+id;
    }

    @PutMapping(value="/opt/{aid}")
    public String update(@PathVariable("aid") Integer id, Admin admin){
        return "UPDATE"+admin.toString()+id;
    }

    @GetMapping(value = "/opt/{aid}")//REST携带数据,使用{}占位，id为路径变量,仅仅用于SpringMVC路由标记
    public String get(@PathVariable("aid") Integer id) {
       /* req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");*/
        String str= "GET:"+id;
        System.out.println(str);
        return str;
    }
}
