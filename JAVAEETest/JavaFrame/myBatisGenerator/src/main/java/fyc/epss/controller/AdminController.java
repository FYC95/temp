package fyc.epss.controller;

import fyc.epss.domain.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {
    private List<Admin> admins = new ArrayList<>();
    public AdminController(){
        Admin admin1 = new Admin();admin1.setAdminname("zs");admin1.setId(1);admin1.setPassword("123");
        Admin admin2 = new Admin();admin2.setAdminname("ls");admin2.setId(2);admin2.setPassword("123");
        Admin admin3 = new Admin();admin3.setAdminname("ww");admin3.setId(3);admin3.setPassword("123");
        Admin admin4 = new Admin();admin4.setAdminname("zl");admin4.setId(4);admin4.setPassword("123");
        admins.add(admin1);admins.add(admin2);admins.add(admin3);admins.add(admin4);
    }

    @RequestMapping(value = "/index")
    public ModelAndView toIndex(/*ModelAndView modelAndView*/){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage/list");


        modelAndView.addObject("adminList",admins);
//        return "../WEB-INF/adminPage/list.jsp";
//        return "adminPage/list";
        return modelAndView;
    }

    @GetMapping("/upd")
    public ModelAndView upd(@RequestParam Integer no){
        ModelAndView modelAndView = new ModelAndView();

        Admin ret = admins.get(no-1);
        modelAndView.setViewName("adminPage/upd");
        modelAndView.addObject("admin",ret);

        return modelAndView;
    }

    @GetMapping("/del")
    public ModelAndView del(int no){
        ModelAndView modelAndView = new ModelAndView("redirect:index");
        System.out.println("删除了一条信息");
        admins.remove(no-1);
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(Admin admin){
        ModelAndView modelAndView = new ModelAndView("redirect:index");
        System.out.println("添加了一条信息");
        admin.setId(admins.size());
        admins.add(admin);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(Admin admin){
        ModelAndView modelAndView = new ModelAndView("redirect:index");
        System.out.println("修改了一条信息");
        int i=0;
        for (; i < admins.size(); i++) {
            if (admins.get(i).getId() == admin.getId()){
                break;
            }
        }
        admins.set(i,admin);
        return modelAndView;
    }

    @GetMapping("/addF")
    public String addF(){
        return "adminPage/add";
    }

}
