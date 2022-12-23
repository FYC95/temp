import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import fyc.epss.dao.AdminMapper;
import fyc.epss.dao.BusinessMapper;
import fyc.epss.dao.InfoMapper;
import fyc.epss.domain.Admin;
import fyc.epss.domain.Business;
import fyc.epss.domain.BusinessExample;
import fyc.epss.domain.Info;

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
    @Test
    public void testSelectAdminWithObj() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        //使用mapper执行具体方法
        Admin admin = mapper.selectByPrimaryKeyWithObj(1);
        //输出
        System.out.println(admin);
        return;
    }
    @Test
    public void testSelectBusinessWithObj() throws IOException {
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
        criteria.andBusinessnameLike("%2%");
        List<Business> business = mapper.selectByExampleWithObj(businessExample);
        //输出
        for (Business b:business) {
            System.out.println(b);
        }
        return;
    }
    @Test
    public void testSelectInfoWithObj() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        InfoMapper mapper = sqlSession.getMapper(InfoMapper.class);
        //使用mapper执行具体方法
        //输出
       Info info = mapper.selectByPrimaryKeyWithObj(2);
        System.out.println(info);
        return;
    }
    @Test
    public void testSelectBusinessWithFoods() throws IOException {
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
        criteria.andBusinessnameLike("%商家1111%");
        List<Business> business = mapper.selectByExampleWithObj1(businessExample);
        //输出
        for (Business b:business) {
            System.out.println(b);
        }
        return;
    }

}
