package fyc.epss.controller;

import fyc.epss.domain.Admin;
import fyc.epss.domain.Info;
import fyc.epss.service.AdminService;
import fyc.epss.utils.DataFlexPacking;
import fyc.epss.utils.UpFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/adminar")
@RestController//@Controller,@ResponseBody
public class AdminRestAjaxController {
    @Autowired
    private AdminService adminService;

    @PutMapping(value="/opt")
    public String update(Admin admin){
        return "UPDATE:"+admin.toString();
    }

    @DeleteMapping(value = "/opt/{aid}")
    public DataFlexPacking delete(@PathVariable("aid")Integer id){
        int i = adminService.deleteByPrimaryKey(id);
        return DataFlexPacking.success().add("delete",i);
    }

    @GetMapping(value = "/opt/{aid}")
    public DataFlexPacking get(@PathVariable("aid")Integer id){
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin(1,"123","123",null,null));
        admins.add(new Admin(2,"1234","1234",null,null));
        admins.add(new Admin(3,"12356","12356",null,null));
        /*HashMap<String, Object> map = new HashMap<>();
        map.put("key1",admins.get(0));
        map.put("key1",admins);
*/
        DataFlexPacking dfp = null;

        if (id<0){
            dfp=DataFlexPacking.success("成功").add("adminList",admins);
        }else {
            dfp=DataFlexPacking.success("成功").add("admin",admins.get(id));
        }
        return dfp;
//        return admins.get(0);
//        return "get"+id.toString();
    }

    /*@PostMapping(value = "/opt")
    public String add(Admin admin){
        return admin.toString();
    }*/
    @PostMapping(value = "/opt")
    public DataFlexPacking add(@RequestParam(value = "upfile" ,required = false ) MultipartFile upfile1, Admin admin, HttpServletRequest httpServletRequest){
        String path = "G:/A/upload";
        String avatar = UpFileUtil.saveFile(upfile1, path);
        Info info = new Info();
        info.setAvater(avatar);
        admin.setInfo(info);


        //1 方案：  后端通过手动方式获取参数,原因是前端通过formData重新封装数据， 没有对应的实体类【HttpServletRequest会被自动封装到handler，声明即可使用】
        // 分割字串的方式拼接成一个Admin对象。
        //String infoData = httpServletRequest.getParameter("infoData");
        //System.out.println(infoData);

        //2 方案：  前端传递数据时按照后端实体进行包装，后端使用实体类参数接收即可  【代码参考  ajaxJsonRequestDemo.html  42行】
        System.out.println(admin);
        return DataFlexPacking.success().add("admin",admin);
    }

    @PostMapping(value="/login")
    public DataFlexPacking login(Admin admin, HttpSession httpSession){
        Admin ret = adminService.loginCheck(admin);
        DataFlexPacking mad = null;
        if (ret ==null){
            mad = DataFlexPacking.fail().add("msg","用户名密码不匹配");
        }else {
            mad = DataFlexPacking.success().add("msg","登陆成功");
            httpSession.setMaxInactiveInterval(30);
            httpSession.setAttribute("loginStatus",true);
            httpSession.setAttribute("ADMIN_SESSION",ret);
        }
        return mad;
    }

}
