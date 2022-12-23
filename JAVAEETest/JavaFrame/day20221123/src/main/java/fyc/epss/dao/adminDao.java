package fyc.epss.dao;

import fyc.epss.pojo.admin;
import fyc.epss.pojo.business;

import java.util.List;

public interface adminDao {
    Integer insertObj(admin obj);
    List<admin> selectByCondition(admin obj);
}
