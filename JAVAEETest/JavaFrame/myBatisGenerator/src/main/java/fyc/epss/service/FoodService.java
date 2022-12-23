package fyc.epss.service;

import fyc.epss.dao.CommonMapper;
import fyc.epss.dao.FoodMapper;
import fyc.epss.dao.OrdermapMapper;
import fyc.epss.domain.Food;
import fyc.epss.domain.FoodExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface FoodService  extends CommonService<Food, FoodExample>{

}
