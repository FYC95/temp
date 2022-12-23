package fyc.epss.service.impl;

import fyc.epss.domain.Food;
import fyc.epss.mapper.FoodMapper;
import fyc.epss.service.IFoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 食品信息表 服务实现类
 * </p>
 *
 * @author fangyuchao
 * @since 2022-12-12
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements IFoodService {

}
