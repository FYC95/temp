package fyc.epss.services;

import java.util.List;
import java.util.Map;

public interface CommonService<T,E> {//类型参数
    public abstract Map<String,Object> queryAll(Integer startR, Integer pageSize, E vo);
    Boolean deleteOne(Integer id);
    Boolean addOne(T obj);
    Integer updateOne(T obj);

    T selectOne(Integer id);
}
