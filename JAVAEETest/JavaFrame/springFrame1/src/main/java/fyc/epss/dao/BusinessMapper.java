package fyc.epss.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component(value = "businessMapper")亦可，通用型
@Repository(value = "businessMapper")
//@Repository(value = "businessDao")与service层@Qualifier(value = "businessDao")配合
public class BusinessMapper implements CommonMapper{
    @Override
    public void selectByPrimaryKey(Integer id) {
        System.out.println("BusinessMapper---");
    }
}
