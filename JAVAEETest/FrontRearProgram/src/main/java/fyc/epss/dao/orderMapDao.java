package fyc.epss.dao;

import fyc.epss.domain.orderMap;
import fyc.epss.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class orderMapDao implements CommonDao<orderMap>{

    private Connection conn = DButils.getConn();
    private PreparedStatement ps = null;
    private ResultSet re = null;

    public Boolean deleteByPrimaryKey(Integer id) {
        String sql = "delete from ordermap where id=?";
        DButils.delete(sql,id);
        return true;
    }


    public orderMap selectByPrimaryKey(Integer id) {
        String sql = "select * from ordermap where id=?";
        orderMap orderMap = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            re = ps.executeQuery();
            if (re.next()){
                orderMap = new orderMap(re.getInt("aid"), re.getInt("fid")).setId(re.getInt("id"));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return orderMap;
    }


    public List<orderMap> selectAll(Integer startR,Integer pageSize,String condition) {
        String sql = "select * from ordermap " + condition + " order by id limit ?,?";
        System.out.println(sql);
        List<orderMap> orderMaps = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,startR);
            ps.setInt(2,pageSize);
            re = ps.executeQuery();
            while (re.next()){
                orderMaps.add(new orderMap(re.getInt("aid"), re.getInt("fid")).setUptime(re.getTimestamp("uptime")).setId(re.getInt("id")));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return orderMaps;
    }


    public Boolean insertSelective(orderMap obj) {
        String sql = "insert into ordermap (aid,fid) values (?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,obj.getAid());
            ps.setInt(2,obj.getFid());
            ps.execute();
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        return true;
    }


    public int updateSelective(orderMap obj) {
        String sql = "update ordermap set aid=?,fid=? where id=?";
        Integer i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,obj.getAid());
            ps.setInt(2,obj.getFid());
            ps.setInt(3,obj.getId());
            i = ps.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        return i;
    }

    public Integer count(String condition){
        Integer num = 0;
        String sql = "select count(id) as num from ordermap " + condition;
        try {
            ps = conn.prepareStatement(sql);
            re = ps.executeQuery();
            if (re.next()) {
                num = re.getInt("num");
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return num;
    }

}
