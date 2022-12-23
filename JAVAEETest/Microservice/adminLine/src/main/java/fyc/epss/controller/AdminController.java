package fyc.epss.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fyc.epss.domain.Admin;
import fyc.epss.service.IAdminService;
import fyc.epss.utils.DataFlexPacking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author fangyuchao
 * @since 2022-12-12
 */
@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private IAdminService adminServiceImpl;

    @GetMapping
    public DataFlexPacking admin(){
        Page<Admin> adminPage = new Page<>(2, 3);
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.like("adminName",1);
        Page<Admin> page = adminServiceImpl.page(adminPage,adminQueryWrapper);
        DataFlexPacking dft = DataFlexPacking.success().add("businessList",page);
        return dft;
    }

}
