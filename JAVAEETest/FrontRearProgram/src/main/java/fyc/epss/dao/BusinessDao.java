package fyc.epss.dao;

import fyc.epss.domain.business;
import fyc.epss.domain.food;
import fyc.epss.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDao implements CommonDao<business>{
    private Connection conn = DButils.getConn();
    private PreparedStatement ps = null;
    private ResultSet re = null;

    public Integer count(String condition){
        Integer num = 0;
        String sql = "select count(id) as num from business " + condition;
        try{
            this.ps = this.conn.prepareStatement(sql);
            this.re = ps.executeQuery();
            if(re.next()){num =  re.getInt("num");}
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }finally {
            DButils.close(re,ps,null);
        }
        return num;
    }
    @Override
    public List<business> selectAll(Integer startR,Integer pageSize,String condition) {
        String sql = "select * from business " + condition + " order by id limit ?,?";
        List<business> businesses = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,startR);
            ps.setInt(2,pageSize);
            re = ps.executeQuery();
            while (re.next()){
                businesses.add(new business(re.getInt("id"),re.getString("password"), re.getString("businessName"),
                        re.getString("businessAddress"),re.getString("businessExplain"), re.getDouble("starPrice"),
                        re.getDouble("deliveryPrice"),re.getInt("aid"),re.getTimestamp("uptime")));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return businesses;
    }


    @Override
    public Boolean deleteByPrimaryKey(Integer id) {
        Boolean flag = false;
        foodDao foodDao = new foodDao();
        List<food> foods = selectAll(id);
        for (food f:foods) {
            foodDao.deleteByPrimaryKey(f.getId());
        }
        String sql = "delete from business where id=?";
        DButils.delete(sql,id);
        flag = true;
        return flag;
    }

    public List<food> selectAll(Integer aid) {
        String sql = "select * from food where aid = ?";
        List<food> foods = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,aid);
            re = ps.executeQuery();
            while (re.next()){
                foods.add(new food(re.getInt("id"), re.getString("foodName"),
                        re.getDouble("foodPrice")));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return foods;
    }

    public business selectByPrimaryKey(Integer id) {
        String sql = "select * from business where id=?";
        business business = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            re = ps.executeQuery();
            if (re.next()){
                business = new business(re.getString("password"),re.getString("businessName"),
                        re.getString("businessAddress")).setAid(re.getInt("aid")).setId(re.getInt("id")).setBusinessExplain(re.getString("businessExplain"));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return business;
    }

    @Override
    public Boolean insertSelective(business obj) {
        String sql = "insert into business (password,businessName,businessAddress,businessExplain) values (?,?,?,?)";
        Boolean b = false;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,obj.getPassword());
            ps.setString(2,obj.getBusinessName());
            ps.setString(3,obj.getBusinessAddress());
            ps.setString(4,obj.getBusinessExplain());
            int i = ps.executeUpdate();
            if (i>0){b = true;}
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        return b;
    }

    @Override
    public int updateSelective(business obj) {
        int i = 0;
        Boolean flag = false;
        String sql = "update business set password=?,businessName=?,businessExplain=?,aid=? where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,obj.getPassword());
            ps.setString(2,obj.getBusinessName());
            ps.setString(3,obj.getBusinessExplain());
            ps.setInt(4,obj.getAid());
            ps.setInt(5,obj.getId());
            i = ps.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        flag = true;
        return i;
    }
}
