import fyc.epss.dao.AdminMapper;
import fyc.epss.dao.BusinessMapper;
import fyc.epss.dao.InfoMapper;
import fyc.epss.domain.Admin;
import fyc.epss.domain.Business;
import fyc.epss.domain.BusinessExample;
import fyc.epss.domain.Info;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectCondition() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        BusinessMapper mapper = sqlSession.getMapper(BusinessMapper.class);
        //使用mapper执行具体方法
        BusinessExample businessExample = new BusinessExample();
        BusinessExample.Criteria criteria = businessExample.createCriteria();
        criteria.andIdBetween(6,15);
        criteria.andBusinessnameLike("%商%");
        criteria.andBusinessaddressIsNotNull();
        List<Business> businessList = mapper.selectByExample(businessExample);
        //输出
        for (Business temp:businessList) {
            System.out.println(temp);
        }
        return;
    }



}
