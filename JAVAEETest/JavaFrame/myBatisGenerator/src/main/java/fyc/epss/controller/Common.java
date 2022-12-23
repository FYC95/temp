package fyc.epss.controller;

import fyc.epss.domain.Admin;
import fyc.epss.utils.DataFlexPacking;
import org.springframework.web.bind.annotation.*;

public interface Common<T> {

    default public DataFlexPacking selectMultiple(){//获得多个资源
        return null;
    }

    default public DataFlexPacking selectOne( Integer id){//获得1个资源
        return null;
    }

    default public DataFlexPacking deleteOne( Integer id){//删除1个资源
        return null;
    }

    default public DataFlexPacking addOne( T obj){//添加1个资源
        return null;
    }

    default public DataFlexPacking updateOne(T obj){//修改1个资源
        return null;
    }
}
