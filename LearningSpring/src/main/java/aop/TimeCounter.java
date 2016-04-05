package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/3/30
 * Email: zhanghui20@meituan.com
 */
@Component
@Aspect
public class TimeCounter {
    @Pointcut("execution(* service.TableService.*(..))")
    public void pointCut(){}
    @Around("pointCut()")
    public Object invoke(ProceedingJoinPoint joinPoint){
        System.out.println("#############################################Start:" + joinPoint.toLongString());
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            System.out.println("#############################################Cost:" + (System.currentTimeMillis() - start)/1000.0 + "s");
        }
        return result;
    }
}
