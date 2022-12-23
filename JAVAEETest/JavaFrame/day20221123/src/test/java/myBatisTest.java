import fyc.epss.dao.adminDao;
import fyc.epss.dao.businessDao;
import fyc.epss.dao.infoDao;
import fyc.epss.pojo.admin;
import fyc.epss.pojo.business;
import fyc.epss.pojo.info;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class myBatisTest {
    @Test
    public void testSelectByPrimaryKey() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        businessDao mapper = sqlSession.getMapper(businessDao.class);
        //使用mapper执行具体方法
        business business = mapper.selectByPrimaryKey(1);
        //输出
        System.out.println(business);
        return;
    }

    /*@Test
    public void testDeleteByPrimaryKey() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        BusinessDao mapper = sqlSession.getMapper(BusinessDao.class);
        //使用mapper执行具体方法
        int i = mapper.deleteByPrimaryKey(14);
        //输出
        System.out.println(i);
        return;
    }*/

    @Test
    public void testInsert() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        businessDao mapper = sqlSession.getMapper(businessDao.class);
        //使用mapper执行具体方法
        int i = mapper.insertObj(new business("12345", "花甲粉"));
        //输出
        System.out.println(i);
        return;
    }
    @Test
    public void testUpdate() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        businessDao mapper = sqlSession.getMapper(businessDao.class);
        business b = new business("12345", "花甲粉");
        b.setId(5);
        //使用mapper执行具体方法
        int i = mapper.updateObj(b);
        //输出
        System.out.println(i);
        return;
    }
    @Test
    public void testSelectAll() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        businessDao mapper = sqlSession.getMapper(businessDao.class);
        //使用mapper执行具体方法
        List<business> i = mapper.selectAll();
        for (business b:i) {
            System.out.println(b);
        }
        return;
    }
    @Test
    public void testCount() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        businessDao mapper = sqlSession.getMapper(businessDao.class);
        //使用mapper执行具体方法
        Integer i = mapper.countNum();
        System.out.println(i);
        return;
    }
    @Test
    public void testInsertAdminInfo() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        adminDao mapper = sqlSession.getMapper(adminDao.class);
        infoDao infomapper = sqlSession.getMapper(infoDao.class);
        info info = new info();
        info.setPhone("1234567891");
        admin admin = new admin();
        admin.setAdminName("zzzzzz");
        admin.setPassword("000000");
        admin.setInfo(info);
        //使用mapper执行具体方法
        Integer i = mapper.insertObj(admin);
        admin.getInfo().setAid(admin.getId());
        infomapper.insertObj(admin.getInfo());
        System.out.println(i);
        return;
    }
   /* @Test
    public void testSelectByCondition() throws IOException {
        //挖矿获得资金
        Reader resourceAsReader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //使用资金雇佣工人建造工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //使用工厂生产产品 sqlSession   等同于   connection ，true代表  autocommit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取对应的mapper
        adminDao mapper = sqlSession.getMapper(adminDao.class);
        admin admin = new admin();
        admin.setId(1);
        admin.setAdminName("a");
        List<admin> list = mapper.selectByCondition(admin);
        //使用mapper执行具体方法
        System.out.println(list);
        return;
    }*/
}
