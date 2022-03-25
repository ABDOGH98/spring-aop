package ma.enset.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogAspect {
    Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Around("execution(* ma.enset.service.IMetier..*())")
    Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("From logging Aspect ....... Before "+proceedingJoinPoint.getSignature().getName());
        Object result = proceedingJoinPoint.proceed();
        return result;
    }
}
