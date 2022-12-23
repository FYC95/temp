package fyc.epss.service;

import fyc.epss.dao.AdminMapper;
import fyc.epss.dao.BusinessMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service(value = "businessService")
//@Scope(value = "prototype/singleton")非单例，原型
public class BusinessService {
    //@Autowired从IOC容器自动注入
    @Autowired
//    @Qualifier(value = "businessDao")
    private BusinessMapper businessMapper;
        public void selectOne(Integer id) {
            businessMapper.selectByPrimaryKey(id);
            System.out.println("BusinessService层实现");
        }

}
