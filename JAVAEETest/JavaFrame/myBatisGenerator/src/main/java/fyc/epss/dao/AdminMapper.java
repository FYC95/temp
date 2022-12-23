package fyc.epss.dao;

import fyc.epss.domain.Admin;
import fyc.epss.domain.AdminExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface AdminMapper extends CommonMapper<Admin,AdminExample>{
    //新增加的方法接口
    Admin selectByPrimaryKeyWithObj(Integer id);
}