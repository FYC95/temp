package fyc.epss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class AdminLineApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminLineApplication.class, args);
    }

}
