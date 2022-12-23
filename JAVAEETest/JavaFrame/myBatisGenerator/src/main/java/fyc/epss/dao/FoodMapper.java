package fyc.epss.dao;

import fyc.epss.domain.Food;
import fyc.epss.domain.FoodExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface FoodMapper extends CommonMapper<Food, FoodExample> {
    //
    List<Food> selectByBid(Integer bid);
}