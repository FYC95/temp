package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.AdminDao;
import com.example.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admins")
public class AdminController {

    @Autowired
    private AdminDao adminDao;


    @GetMapping("/{keyword}/{pageNum}/{pageSize}")
    public IPage<Admin> Pagination(
            @PathVariable("keyword")String keyword,
            @PathVariable("pageNum")Integer pageNum,
            @PathVariable("pageSize")Integer pageSize
    ){

        IPage<Admin> adminPage = new Page<>(pageNum, pageSize);
        //2 携带分页条件进行查询
        //3.1 构造查询的条件对象
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        //3.2   条件对象赋予条件值
        adminQueryWrapper.like("adminname",keyword); //无需手工拼接  %

        IPage<Admin> iPage = adminDao.selectPage(adminPage, adminQueryWrapper);



       /* //创建IPage对象，设置参数：第几页、每页显示最大行数
        IPage<Admin> page = new Page<>(pageNum, pageSize);
        //调用selectPage方法进行分页查询，返回值为IPage对象。

        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.like("adminname",keyword);
        IPage<Admin> deptPage = adminDao.selectPage(page, adminQueryWrapper);
*/

        //通过IPage对象获取当前满足条件总行数
        System.out.println(iPage.getTotal());
        //通过IPage对象获取每页显示最大条数
        System.out.println(iPage.getSize());
        //通过IPage对象获取当前页
        System.out.println(iPage.getCurrent());
        //通过IPage对象获取当前分页总页数
        System.out.println(iPage.getPages());
        //通过IPage对象获取业务数据
        /*List<Admin> list = deptPage.getRecords();
        for(Admin a : list) {
            System.out.println(a);
        }*/
        return iPage;

    }
}
