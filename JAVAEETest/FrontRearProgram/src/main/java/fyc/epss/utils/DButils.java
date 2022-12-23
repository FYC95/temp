package fyc.epss.utils;

import java.sql.*;

//数据库工具类，方便获取connection和关闭资源
public class DButils {
    static Connection conn = DButils.getConn();
    static PreparedStatement ps = null;
    static ResultSet re = null;
//    static Connection conn = null;
    //类加载时就需要驱动,卸载static代码块，编译时加载且只加载一次
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//打印调试
        }
    }

    public static Connection getConn(){
        if(conn == null){
            String url= "jdbc:mysql://localhost:3310/ele_se?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            try {
                conn = DriverManager.getConnection(url,"root","000000");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    //释放资源
    public static void close(ResultSet rs,Statement st,Connection conn){
        try {
            if (rs != null){
                try {
                    rs.close();
                }catch (SQLException e){e.printStackTrace();}
            }
        }finally {
            try {
                if (st != null){
                    try {
                        st.close();
                    }catch (SQLException e){e.printStackTrace();}
                }
            }finally {
                if (conn != null){
                    try {
                        conn.close();
                    }catch (SQLException e){e.printStackTrace();}
                }
            }
        }
    }

    public static void delete(String sql,Integer id){
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DButils.close(null,ps,null);
        }
    }

}
