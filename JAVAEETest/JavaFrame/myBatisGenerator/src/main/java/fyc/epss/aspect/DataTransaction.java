package fyc.epss.aspect;

import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataTransaction {

    @Pointcut("execution(int fyc.epss.service.impl.*Impl.*(..))")
    private void definePointCut(){}


    @Before("definePointCut()")
    public void beginTransaction(JoinPoint joinPoint){
        System.out.println("@Before     ........" + joinPoint);
    }

    @After("definePointCut()")
    public void endTransaction(JoinPoint joinPoint){
        System.out.println("@After   ........" + joinPoint);
    }

    @AfterReturning(pointcut="definePointCut()",returning="ret")
    public void afterReturnning(JoinPoint joinPoint,Object ret){
        System.out.println("@AfterReturning   ........" + joinPoint + (Integer)ret*(Integer)ret);
    }

    /*@AfterThrowing(pointcut="definePointCut()",throwing="ex")
    public void afterThrowing(JoinPoint joinpoint,Exception ex){
        System.out.println("------ @AfterThrowing------");
    }*/

    @Around("definePointCut()")
    public Object aroundMethod(ProceedingJoinPoint pjp) {
        Object obj = null;
        try{
            System.out.println("------ @Around before------");
            obj = pjp.proceed();
            System.out.println("------@Around  after ........");
        }catch(Throwable e){
            e.printStackTrace();
        }
        return obj;
    }
}
