package fyc.epss.controller;


import fyc.epss.domain.Business;
import fyc.epss.service.IBusinessService;
import fyc.epss.utils.DataFlexPacking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商家信息表 前端控制器
 * </p>
 *
 * @author fangyuchao
 * @since 2022-12-12
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private IBusinessService businessServiceImpl;
    @GetMapping
    public DataFlexPacking all(){
        List<Business> list = businessServiceImpl.list(null);
        DataFlexPacking dft = DataFlexPacking.success().add("businessList",list);
        return dft;
    }
}
