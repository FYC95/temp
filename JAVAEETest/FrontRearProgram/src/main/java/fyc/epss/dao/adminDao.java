package fyc.epss.dao;

import fyc.epss.domain.admin;
import fyc.epss.domain.business;
import fyc.epss.domain.info;
import fyc.epss.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class adminDao implements CommonDao<admin>{

    private Connection conn = DButils.getConn();
    private PreparedStatement ps = null;
    private ResultSet re = null;
    @Override
    public Boolean deleteByPrimaryKey(Integer id){
        Boolean b = deleteOrdermap(id);
        Boolean c = deleteInfo(id);
        BusinessDao businessDao = new BusinessDao();
        List<business> businesses = selectAll(id);
        for (fyc.epss.domain.business business:businesses) {
            businessDao.deleteByPrimaryKey(business.getId());
        }
        String sql = "delete from admin where id=?";
        DButils.delete(sql,id);
        return true;
    }

    public Boolean deleteOrdermap(Integer aid) {
        String sql = "delete from ordermap where aid =?";
        DButils.delete(sql,aid);
        return true;
    }
    public Boolean deleteInfo(Integer aid) {
        String sql = "delete from info where aid =?";
        DButils.delete(sql,aid);
        return true;
    }
    public List<business> selectAll(Integer aid) {
        String sql = "select * from business where aid = ?";
        List<business> businesses = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,aid);
            re = ps.executeQuery();
            while (re.next()){
                businesses.add(new business(re.getInt("id"), re.getString("businessName"),
                        re.getString("businessAddress")));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return businesses;
    }

    @Override
    public admin selectByPrimaryKey(Integer id) {
        String sql = "select * from admin where id=?";
        admin admin = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            re = ps.executeQuery();
            if (re.next()){
                admin = new admin(re.getString("adminName"),
                        re.getString("password")).setId(re.getInt("id")).
                        setUptime(re.getTimestamp("uptime"));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return admin;
    }

    @Override
    public List<admin> selectAll(Integer startR,Integer pageSize,String condition) {
        String sql = "select * from admin order by id limit ?,?";
        List<admin> admins = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,startR);
            ps.setInt(2,pageSize);
            re = ps.executeQuery();
            while (re.next()){
                admins.add(new admin(re.getString("adminName"),
                        re.getString("password")).setId(re.getInt("id")).
                        setUptime(re.getTimestamp("uptime")));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return admins;
    }

    @Override
    public Boolean insertSelective(admin obj) {
        String sql = "insert into admin (adminName,password) values (?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,obj.getAdminName());
            ps.setString(2,obj.getPassword());
            ps.execute();
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        return true;
    }

    @Override
    public int updateSelective(admin obj) {
        String sql = "update admin set adminName=?,password=? where id=?";
        Integer i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,obj.getAdminName());
            ps.setString(2,obj.getPassword());
            ps.setInt(3,obj.getId());
            i = ps.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        return i;
    }
    public List<admin> AdminInfoAssociateQuery(Integer id){
        List<admin> admins= new ArrayList<>();
        String sql = "select a.id as pid,\n" +
                "       a.adminName as adminName,\n" +
                "       a.password as password,\n" +
                "       a.uptime as puptime,\n" +
                "       i.id as sid,\n" +
                "       i.phone as phone\n" +
                "from admin as a\n" +
                "left join info as i on a.id = i.aid\n"
                +"where a.id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            re = ps.executeQuery();
            while (re.next()){
                admins.add(new admin(re.getString("adminName"),
                        re.getString("password")).setId(re.getInt("pid")).
                        setUptime(re.getTimestamp("puptime")).
                        setInfo(new info().setId(re.getInt("sid")).setPhone(re.getString("phone"))));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return admins;
    }
    //登录时核对用户名密码,
    /**
     * Parmeter Admin:用户名输入的用户名和密码组装成的对象
     * Return：Admin，数据表查询到的Admin对象
     * */
    public admin selectByCondition(admin admin){
        String sql = "select * from admin where adminName=? and password=?";
        admin res = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,admin.getAdminName());
            ps.setString(2,admin.getPassword());
            re = ps.executeQuery();
            if (re.next()){
                res = new admin(re.getString("adminName"),
                        re.getString("password")).setId(re.getInt("id")).
                        setUptime(re.getTimestamp("uptime"));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return res;
    }
    public Integer count(String condition){
        Integer num = 0;
        String sql = "select count(id) as num from admin";
        try {
            ps = conn.prepareStatement(sql);
            re = ps.executeQuery();
            if (re.next()) {
                re.getInt("num");
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return num;
    }

    public admin select(String name, String password) {
        String sql = "select * from admin where adminName=? and password=?";
        admin admin = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            re = ps.executeQuery();
            if (re.next()){
                admin = new admin(re.getString("adminName"),
                        re.getString("password")).setId(re.getInt("id")).
                        setUptime(re.getTimestamp("uptime"));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return admin;
    }

}
