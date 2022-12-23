package fyc.epss.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckModel {
    @Before("execution(int fyc.epss.service.*.*(..))")
    public void checkCode(){
        System.out.println("-----检查-----");
    }
}
