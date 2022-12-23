package fyc.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fyc.epss.dao.AdminDao;
import fyc.epss.domain.Admin;

@RestController
@RequestMapping("admins")
public class AdminController {

    @Autowired
    private AdminDao adminDao;

    @GetMapping
    public String test(){
       /* Admin admin = adminDao.selectByPrimaryKey(1);
        System.out.println(admin);
        System.out.println("--------------------------------");*/
        for (Admin admin : adminDao.selectByExample()) {
            System.out.println(admin);
        }
        return "selectAllSuccess";
    }

    @GetMapping("{id}")
    public String test1(@PathVariable(value = "id") Integer id){
        Admin admin = adminDao.selectByPrimaryKey(id);
        System.out.println(admin);
        return "SelectOneSuccess"+admin;
    }

    @PostMapping
    public String test2(Admin admin){
        Integer i = adminDao.insert(admin);
        return "insert"+i;
    }

    @DeleteMapping ("{id}")
    public String test3(@PathVariable(value = "id")Integer id){
        Integer i = adminDao.deleteByPrimaryKey(id);
        System.out.println(i);
        return "DeleteOneSuccess"+i;
    }

    @PutMapping
    public String test4(Admin admin){
        Integer i = adminDao.updateByPrimaryKey(admin);
        System.out.println(i);
        return "UpdateOneSuccess"+i;
    }


}
