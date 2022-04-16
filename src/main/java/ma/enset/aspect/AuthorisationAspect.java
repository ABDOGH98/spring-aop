package ma.enset.aspect;

import ma.enset.service.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorisationAspect {

    @Around(value = "@annotation(securedByAspect)", argNames = "proceedingJoinPoint,securedByAspect")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint, SecuredByAspect securedByAspect) throws Throwable {
        String[] roles = securedByAspect.roles();
        boolean authorize = false ;
        for (String role : roles){
            if(SecurityContext.hasRole(role)){
                authorize = true ;
                break;
            }
        }
        if (authorize==true){
            Object result = proceedingJoinPoint.proceed();
            return result;
        }
        throw new RuntimeException("Unauthorized "+proceedingJoinPoint.getSignature());
    }
}
