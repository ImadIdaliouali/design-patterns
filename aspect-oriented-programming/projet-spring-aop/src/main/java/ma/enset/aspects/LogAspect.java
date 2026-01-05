package ma.enset.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Around("@annotation(ma.enset.annotations.Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("\n[LOG ASPECT] ════════════════════════════════");
        System.out.println("[LOG ASPECT] Méthode appelée : " + methodName);
        System.out.println("[LOG ASPECT] Classe : " + joinPoint.getTarget().getClass().getSimpleName());

        Object result = joinPoint.proceed();

        System.out.println("[LOG ASPECT] Méthode terminée : " + methodName);
        System.out.println("[LOG ASPECT] ════════════════════════════════\n");

        return result;
    }
}
