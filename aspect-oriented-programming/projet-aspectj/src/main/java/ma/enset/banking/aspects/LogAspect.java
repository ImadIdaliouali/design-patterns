package ma.enset.banking.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

    @Pointcut("execution(* ma.enset.banking.service.*.*(..))")
    public void serviceLayer() {
    }

    @Around("serviceLayer()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("========================================");
        System.out.println("[LOG] Avant l'exécution de la méthode : " + methodName);

        long t1 = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long t2 = System.currentTimeMillis();

        System.out.println("[LOG] Après l'exécution de la méthode : " + methodName);
        System.out.println("[LOG] Durée d'exécution : " + (t2 - t1) + " ms");
        System.out.println("========================================");

        return result;
    }
}
