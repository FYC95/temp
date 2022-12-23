package fyc.epss.dao;

import java.util.List;

public interface CommonDao<T> {
    public abstract List<T> selectAll(Integer startR,Integer pageSize,String condition);
    public abstract T selectByPrimaryKey(Integer id);
    public abstract Boolean deleteByPrimaryKey(Integer id);
    public abstract Boolean insertSelective(T obj);
    public abstract int updateSelective(T obj);
    public Integer count(String condition);
}
