package fyc.epss.service;

import fyc.epss.dao.AdminMapper;
import fyc.epss.dao.CommonMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service(value = "adminService")
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
        public void selectOne(Integer id) {
            adminMapper.selectByPrimaryKey(id);
            System.out.println("service层实现");
        }
    public void testMethod1(){
        System.out.println("testMethod1:");
        adminMapper.selectByPrimaryKey(1);
    }
    public int testMethod2(){
        System.out.println("testMethod2:");
        adminMapper.selectByPrimaryKey(1);
        return 2;
    }
    /*public static void main(String[] args) {
        AdminService adminService = new AdminService();
        adminService.selectOne(5);
        System.out.println();
    }*/
}
