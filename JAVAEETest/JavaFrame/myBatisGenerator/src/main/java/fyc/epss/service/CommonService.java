package fyc.epss.service;

import java.util.List;

public interface CommonService<T,E> {
    public int deleteByPrimaryKey(Integer id);
    T selectByPrimaryKey(Integer id);
    List<T> selectByExample(E example);
}
