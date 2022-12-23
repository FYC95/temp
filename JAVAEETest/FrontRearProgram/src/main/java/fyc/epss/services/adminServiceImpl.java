package fyc.epss.services;

import fyc.epss.dao.adminDao;
import fyc.epss.domain.admin;

import java.util.Map;

public class adminServiceImpl implements CommonService{
    @Override
    public Map<String, Object> queryAll(Integer startR, Integer pageSize, Object vo) {
        return null;
    }

    @Override
    public Boolean deleteOne(Integer id) {
        return null;
    }

    @Override
    public Boolean addOne(Object obj) {
        return null;
    }

    @Override
    public Integer updateOne(Object obj) {
        return null;
    }

    @Override
    public Object selectOne(Integer id) {
        return null;
    }
    public admin select(String name, String password) {
        admin admin = new adminDao().select(name,password);
        return admin;
    }
}
