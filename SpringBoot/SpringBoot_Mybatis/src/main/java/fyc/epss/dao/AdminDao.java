package fyc.epss.dao;

import fyc.epss.domain.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
//@Repository
@Mapper
public interface AdminDao {
    @Select("select * from admin where id=#{val}")
    Admin selectByPrimaryKey(Integer id);

    @Delete("delete from admin where id=#{val}")
    Integer deleteByPrimaryKey(Integer id);


    @Update("update admin set adminname=#{adminname},password=#{password} where id=#{id}")
    Integer updateByPrimaryKey(Admin admin);

    @Select("select * from admin")
    List<Admin> selectByExample();

    @Insert("insert into admin (id,adminname,password) value (#{id},#{adminname},#{password})")
    Integer insert(Admin admin);


}
