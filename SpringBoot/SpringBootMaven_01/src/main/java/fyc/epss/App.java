package fyc.epss;

import fyc.epss.service.AdminService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        /*ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        AdminService adminService = run.getBean("adminService", AdminService.class);
        adminService.test();*/

       /* ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = applicationContext.getBean("adminService", AdminService.class);
        adminService.test();*/
    }
}
