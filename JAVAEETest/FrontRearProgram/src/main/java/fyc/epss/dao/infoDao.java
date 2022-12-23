package fyc.epss.dao;

import fyc.epss.domain.info;
import fyc.epss.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class infoDao implements CommonDao<info>{
    private Connection conn = DButils.getConn();
    private PreparedStatement ps = null;
    private ResultSet re = null;

    public Boolean deleteByPrimaryKey(Integer id) {
        String sql = "delete from info where id=?";
        DButils.delete(sql,id);
        return true;
    }


    public info selectByPrimaryKey(Integer id) {
        info info = null;
        String sql = "select * from info where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            re = ps.executeQuery();
            if (re.next()){
                info = new info(re.getInt("id"), re.getInt("aid"),
                        re.getString("phone"),re.getString("avater"),
                        re.getBoolean("gender"),re.getTimestamp("uptime"));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return info;
    }


    public List<info> selectAll(Integer startR,Integer pageSize,String condition) {
        List<info> infos = new ArrayList<>();
        String sql = "select * from info " + condition + " order by id limit ?,?";
        System.out.println(sql);
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,startR);
            ps.setInt(2,pageSize);
            re = ps.executeQuery();
            while (re.next()){
                infos.add(new info(re.getInt("id"), re.getInt("aid"),
                        re.getString("phone"),re.getString("avater"),
                        re.getBoolean("gender"),re.getTimestamp("uptime")));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return infos;
    }

    @Override
    public Boolean insertSelective(info obj) {
        String sql = "insert into info (aid,phone,avater,gender) values (?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,obj.getAid());
            ps.setString(2,obj.getPhone());
            ps.setString(3,obj.getAvatar());
            ps.setBoolean(4,obj.getGender());
            ps.execute();
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        return true;
    }

    @Override
    public int updateSelective(info obj) {
        String sql = "update info set aid=?,phone=?,gender=? where id=?";
        Integer i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,obj.getAid());
            ps.setString(2,obj.getPhone());
            ps.setBoolean(3,obj.getGender());
            ps.setInt(4,obj.getId());
            i = ps.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        return i;
    }

    public Integer count(String condition){
        Integer num = 0;
        String sql = "select count(id) as num from info " + condition;
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
