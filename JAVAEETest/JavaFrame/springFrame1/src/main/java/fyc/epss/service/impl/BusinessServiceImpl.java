package fyc.epss.service.impl;

import fyc.epss.dao.BusinessMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service(value = "businessServiceImpl")
//@Scope(value = "prototype/singleton")非单例，原型
public class BusinessServiceImpl {
    //@Autowired从IOC容器自动注入
//    @Qualifier(value = "businessDao")
    @Autowired
    private BusinessMapper businessMapper;
        public void selectOne(Integer id) {
            businessMapper.selectByPrimaryKey(id);
            System.out.println("BusinessService层实现");
        }

}
