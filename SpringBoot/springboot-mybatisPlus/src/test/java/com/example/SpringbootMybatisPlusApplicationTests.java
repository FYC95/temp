package com.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.AdminDao;
import com.example.domain.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private AdminDao adminDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void selectOne(){
        Admin admin = adminDao.selectById(1);
        System.out.println(admin);
    }
    @Test
    public void selectAll(){
        List<Admin> admins = adminDao.selectList(null);
        System.out.println(admins);
    }
    @Test
    public void insert(){
        int i = adminDao.insert(new Admin(36,"adname","123456",null));
        System.out.println(i);
    }
    @Test
    public void update(){
        int i = adminDao.updateById(new Admin(36,"adname111","111111",null));
        System.out.println(i);
    }
    @Test
    public void delete(){
        int i = adminDao.deleteById(new Admin(40,"adname111","111111",null));
        System.out.println(i);
    }
    @Test
    public void pagination(){
        //创建IPage对象，设置参数：第几页、每页显示最大行数
        IPage<Admin> page = new Page<>(3, 4);
        //调用selectPage方法进行分页查询，返回值为IPage对象。
        IPage<Admin> deptPage = adminDao.selectPage(page, null);

        //通过IPage对象获取当前满足条件总行数
        System.out.println(deptPage.getTotal());
        //通过IPage对象获取每页显示最大条数
        System.out.println(deptPage.getSize());
        //通过IPage对象获取当前页
        System.out.println(deptPage.getCurrent());
        //通过IPage对象获取当前分页总页数
        System.out.println(deptPage.getPages());
        //通过IPage对象获取业务数据
        List<Admin> list = deptPage.getRecords();
        for(Admin a : list) {
            System.out.println(a);
        }
    }
}
