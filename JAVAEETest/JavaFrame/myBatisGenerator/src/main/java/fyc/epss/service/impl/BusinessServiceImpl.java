package fyc.epss.service.impl;

import fyc.epss.dao.BusinessMapper;
import fyc.epss.dao.FoodMapper;
import fyc.epss.dao.OrdermapMapper;
import fyc.epss.domain.Business;
import fyc.epss.domain.BusinessExample;
import fyc.epss.service.BusinessService;
import fyc.epss.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "businessService")
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private OrdermapMapper orderMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private BusinessMapper businessMapper;


    public int deleteByPrimaryKey(Integer id) {

        return 0;
    }

    @Override
    public Business selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Business> selectByExample(BusinessExample example) {
        return null;
    }


    public void selectOne(Integer id) {
        businessMapper.selectByPrimaryKey(id);
        System.out.println("BusinessService层实现");
    }

}
