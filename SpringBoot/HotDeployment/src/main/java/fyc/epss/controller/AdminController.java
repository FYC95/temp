package fyc.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class AdminController {

    @GetMapping
    public String test01(){
        System.out.println("----test03-----");
        return "----test03-----";
    }
}
