package fyc.epss.service.impl;

import fyc.epss.dao.*;
import fyc.epss.domain.Admin;
import fyc.epss.domain.AdminExample;
import fyc.epss.domain.InfoExample;
import fyc.epss.service.AdminService;
import fyc.epss.service.CommonService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private OrdermapMapper orderMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private InfoMapper infoMapper;
    @Autowired
    private AdminMapper adminMapper;
    /*@Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        //获取sqlsession时可以关闭自动提交openSession(false)
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
//        sqlSession.commit(false);//关闭自动提交



        InfoExample infoExample = new InfoExample();
        InfoExample.Criteria criteria = infoExample.createCriteria();
        criteria.andAidEqualTo(id);
        int i = infoMapper.deleteByExample(infoExample);

       *//* try{}catch (Exception e){e.printStackTrace();}finally {
            sqlSession.rollback();
        }*//*

        int j = adminMapper.deleteByPrimaryKey(id);
        sqlSession.commit();//提交
        return j;
    }*/
    @Override
    public int deleteByPrimaryKey(Integer id) {


        InfoExample infoExample = new InfoExample();
        InfoExample.Criteria criteria = infoExample.createCriteria();
        criteria.andAidEqualTo(id);
        int i = infoMapper.deleteByExample(infoExample);


        int j = adminMapper.deleteByPrimaryKey(id);
        return j;
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }

    @Override
    public List<Admin> selectByExample(AdminExample example) {
        List<Admin> admins = adminMapper.selectByExample(example);
        return admins;
    }


    @Override
    public Admin loginCheck(Admin admin) {
        Admin retadmin = null;
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminnameEqualTo(admin.getAdminname());
        criteria.andPasswordEqualTo(admin.getPassword());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins.size() == 0){retadmin = null;}
        if (admins.size() > 0){retadmin = admins.get(0);}
        return retadmin;
    }
}
