import fyc.epss.service.AdminService;
import fyc.epss.service.BusinessService;
import fyc.epss.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpringDI {
    public static void main(String[] args) {
        //读取Spring配置文件,获取Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过Spring容器的getBean方法获得对象
        AdminServiceImpl adminServiceImpl = context.getBean("adminServiceImpl",AdminServiceImpl.class);
        adminServiceImpl.selectOne(5);
    }
    @Test
    public void testByAnnotationBusinessService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过Spring容器的getBean方法获得对象
        BusinessService businessService = context.getBean("businessService",BusinessService.class);
        businessService.selectOne(5);
    }
    //测试bean相关属性
    @Test
    public void testIstance(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过Spring容器的getBean方法获得对象
        //bean默认是单例的
        AdminService adminService = context.getBean("adminService",AdminService.class);
        AdminService adminService1 = context.getBean("adminService",AdminService.class);
        System.out.println(adminService);
        System.out.println(adminService1);
    }
    @Test
    public void testSpringAopByAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过Spring容器的getBean方法获得对象
        AdminService adminService = context.getBean("adminService",AdminService.class);
//        adminService.testMethod1();
        adminService.testMethod2();
    }
}
