package fyc.epss.controller;

import fyc.epss.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admins2")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public String test01(){
        System.out.println("----test02-----");
        adminService.test();
        return "----test02-----";
    }
}
