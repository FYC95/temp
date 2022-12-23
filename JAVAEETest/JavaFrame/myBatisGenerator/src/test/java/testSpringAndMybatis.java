import fyc.epss.service.AdminService;
import fyc.epss.service.CommonService;
import fyc.epss.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpringAndMybatis {
    @Test
    public void testByAnnotationBusinessService(){
    //读取Spring配置文件,获取Spring容器
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    //通过Spring容器的getBean方法获得对象
    AdminService adminService = context.getBean("adminService", AdminService.class);
        int i = adminService.deleteByPrimaryKey(33);
        System.out.println(i);
    }
}
