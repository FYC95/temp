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

public class foodDao implements CommonDao<food>{
    private Connection conn = DButils.getConn();
    private PreparedStatement ps = null;
    private ResultSet re = null;



    public Integer count(String condition){
        Integer num = 0;
        String sql = "select count(id) as num from food " + condition;
        try {
            this.ps = this.conn.prepareStatement(sql);
            this.re = ps.executeQuery();
            if(re.next()){num =  re.getInt("num");}
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return num;
    }
    public Boolean deleteByPrimaryKey(Integer id) {
        Boolean b = deleteAll(id);
        String sql = "delete from food where id=?";
        DButils.delete(sql,id);
        return true;
    }
    public Boolean deleteAll(Integer fid) {
        String sql = "delete from ordermap where fid =?";
        DButils.delete(sql,fid);
        return true;
    }

    public food selectByPrimaryKey(Integer id) {
        String sql = "select * from food where id=?";
        food food = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            re = ps.executeQuery();
            if (re.next()){
                food = new food(re.getString("foodName"),
                        re.getDouble("foodPrice"),re.getInt("aid")).setId(re.getInt("id"));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return food;
    }


    public List<food> selectAll(Integer startR,Integer pageSize,String condition) {
        String sql = "select * from food " + condition + " order by id limit ?,?";
        List<food> foods = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,startR);
            ps.setInt(2,pageSize);
            re = ps.executeQuery();
            while (re.next()){
                foods.add(new food(re.getString("foodName"),
                        re.getDouble("foodPrice"),re.getInt("aid")).setId(re.getInt("id")).setUptime(re.getTimestamp("uptime")).setFoodExplain(re.getString("foodExplain")));
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return foods;
    }



    public Boolean insertSelective(food obj) {
        String sql = "insert into food (foodName,foodExplain,foodPrice,aid) values (?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,obj.getFoodName());
            ps.setString(2,obj.getFoodExplain());
            ps.setDouble(3,obj.getFoodPrice());
            ps.setInt(4,obj.getBid());
            ps.execute();
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        return true;
    }


    public int updateSelective(food obj) {
        Integer i = 0;
        String sql = "update food set foodName=?,foodPrice=? where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,obj.getFoodName());
            ps.setDouble(2,obj.getFoodPrice());
            ps.setInt(3,obj.getId());
            i = ps.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(null,ps,null);
        }
        return i;
    }


    public food selectByPrimaryKeyWithObject(Integer id) {
        food food = null;
        business business = new business();
        String sql = "select f.id as ffid,\n" +
                "       f.foodName as foodName,\n" +
                "       f.foodExplain as foodExplain,\n" +
                "       f.foodPrice as foodPrice,\n" +
                "       f.aid as bid,\n" +
                "       f.uptime as fuptime,\n" +
                "       b.businessName as businessName\n" +
                "from food as f\n" +
                "    left join business as b on f.id = b.id\n" +
                "                      where f.id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            re = ps.executeQuery();
            if (re.next()){
                food = new food(re.getString("foodName"),
                        re.getDouble("foodPrice"),
                        re.getInt("bid"));
                food.setId(re.getInt("ffid"));
                food.setFoodExplain(re.getString("foodExplain"));
                food.setUptime(re.getTimestamp("fuptime"));
                business.setId(re.getInt("bid"));
                business.setBusinessName(re.getString("businessName"));
                food.setBusiness(business);
            }
        }catch (SQLException e){e.printStackTrace();}finally {
            DButils.close(re,ps,null);
        }
        return food;
    }

}
