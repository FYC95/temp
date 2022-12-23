package fyc.epss.dao;

import fyc.epss.domain.Business;
import fyc.epss.domain.BusinessExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BusinessMapper extends CommonMapper<Business, BusinessExample>{
//
    List<Business> selectByExampleWithObj(BusinessExample example);
    List<Business> selectByExampleWithObj1(BusinessExample example);

}