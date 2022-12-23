package fyc.epss.dao;

import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository(value = "adminMapper")
public class AdminMapper implements CommonMapper{
    @Override
    public void selectByPrimaryKey(Integer id){
        System.out.println("dao层AdminMapper");
    }
}
