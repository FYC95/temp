package fyc.epss.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataTransaction {

    @Pointcut("execution(void fyc.epss.service.impl.*Impl.*(..))")
    private void definePointCut(){}

    @Before("definePointCut()")
    public void beginTransaction(){
        System.out.println("------@Before------");
    }
    @After("definePointCut()")
    public void endTransaction(){
        System.out.println("------ @After------");
    }
    @AfterReturning(pointcut="definePointCut()",returning="result")
    public void afterReturnning(JoinPoint joinpoint, Object result){
        System.out.println("------ @AfterReturning------");
    }
    /*@AfterThrowing(pointcut="definePointCut()",throwing="ex")
    public void afterThrowing(JoinPoint joinpoint,Exception ex){
        System.out.println("------ @AfterThrowing------");
    }*/
    @Around("definePointCut()")
    public Object aroundMethod(ProceedingJoinPoint pjp) {
        Object obj = null;
        try{
            System.out.println("------ @Around------");
            obj = pjp.proceed();
        }catch(Throwable e){
            e.printStackTrace();
        }
        return obj;
    }
}
