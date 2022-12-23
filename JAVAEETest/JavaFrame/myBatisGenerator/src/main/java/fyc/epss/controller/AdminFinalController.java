package fyc.epss.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fyc.epss.domain.Admin;
import fyc.epss.domain.AdminExample;
import fyc.epss.service.AdminService;
import fyc.epss.utils.DataFlexPacking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//完整版REST应用模式
//REST本质就是语义化HTTP方法,推荐使用资源(Admin,Info,Food)命名
//http://localhost:8080/application/admins  GET 获取所有admin
//http://localhost:8080/application/admins/id  GET 获取为某个id的admin
//http://localhost:8080/application/admins/id  DELETE 删除为某个id的admin
//http://localhost:8080/application/admins     POST 增加一个admin
//http://localhost:8080/application/admins     PUT 修改一个admin
@RestController
@RequestMapping("/admins")
public class AdminFinalController implements Common<Admin>{

    @Autowired
//    @Qualifier("adminService")
    private AdminService adminService;


    @GetMapping("/{keyword}/{pageNum}/{pageSize}")
    public DataFlexPacking selectMultiple(
            @PathVariable(value = "keyword",required = true)String keyword,
            @PathVariable(value = "pageNum",required = true)Integer pageNum,
            @PathVariable(value = "pageSize",required = true)Integer pageSize
            ) {
        //初始化PageHelper，拦截器介入
        PageHelper.startPage(pageNum,pageSize);
        AdminExample adminExample = null;
        if (keyword != ""){
            adminExample = new AdminExample();
            AdminExample.Criteria criteria = adminExample.createCriteria();
            criteria.andAdminnameLike("%"+keyword+"%");
        }
        List<Admin> admins = adminService.selectByExample(adminExample);
        //使用pageHelper重新封装数据,封装为PageInfo【总记录数，是否有下一页等】
        PageInfo<Admin> pageInfo = new PageInfo<>(admins,7);
        return DataFlexPacking.success().add("pageInfo",pageInfo);
    }

    @Override
    @GetMapping("{pk}")
    public DataFlexPacking selectOne(@PathVariable(value = "pk") Integer id) {
        Admin admin = adminService.selectByPrimaryKey(id);
        return DataFlexPacking.success().add("key",admin);
    }

    @Override
    @DeleteMapping("/{pk}")
    public DataFlexPacking deleteOne(@PathVariable(value = "pk") Integer id) {
        return Common.super.deleteOne(id);
    }

    @Override
    @PostMapping
    public DataFlexPacking addOne(@RequestParam(value = "obj",required = true)Admin obj) {
        return Common.super.addOne(obj);
    }

    @Override
    @PutMapping
    public DataFlexPacking updateOne(Admin obj) {
        return Common.super.updateOne(obj);
    }
}
