package fyc.epss.dao;

import fyc.epss.pojo.business;
import fyc.epss.pojo.businessVO;

import java.util.List;

public interface businessDao {
    public abstract business selectByPrimaryKey(Integer id);
    public abstract Integer deleteByPrimaryKey(Integer id);
    List<business> selectAll();
    Integer insertObj(business obj);
    Integer updateObj(business obj);
    Integer countNum();
    List<business> selectByCondition(businessVO obj);
}
