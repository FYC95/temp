package com.example.springboot_01.controller;

import com.example.springboot_01.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Value("${hobby[1]}")
    private String hobby;
    //获取对象的单一属性
   /* @Value("${server.servlet.encoding.charset}")
    private String encode;*/
    //获取配置文件里的内容
    @Value("${name}")
    private String username;
    //获取文件配置
    @Autowired
    private Environment environment;

    @Autowired
    private Person person;

    @GetMapping
    public String test01(){
        System.out.println(this.username+"1233");
        return this.username + person.getName() +this.hobby;
    }
}
