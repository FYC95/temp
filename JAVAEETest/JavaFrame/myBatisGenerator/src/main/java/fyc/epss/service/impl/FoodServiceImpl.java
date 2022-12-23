package fyc.epss.service.impl;

import fyc.epss.dao.FoodMapper;
import fyc.epss.dao.OrdermapMapper;
import fyc.epss.domain.Food;
import fyc.epss.domain.FoodExample;
import fyc.epss.service.CommonService;
import fyc.epss.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "foodService")
public class FoodServiceImpl implements FoodService {
    @Autowired
    private OrdermapMapper orderMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public Food selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Food> selectByExample(FoodExample example) {
        return null;
    }
}
