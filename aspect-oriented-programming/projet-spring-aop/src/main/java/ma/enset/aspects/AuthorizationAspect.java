package ma.enset.aspects;

import ma.enset.annotations.SecuredByAspect;
import ma.enset.security.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class AuthorizationAspect {

    @Around("@annotation(ma.enset.annotations.SecuredByAspect)")
    public Object checkAuthorization(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SecuredByAspect securedAnnotation = method.getAnnotation(SecuredByAspect.class);
        String[] requiredRoles = securedAnnotation.roles();

        System.out.println("\n[AUTHORIZATION ASPECT] ══════════════════════");
        System.out.println("[AUTHORIZATION ASPECT] Vérification des autorisations...");
        System.out.println("[AUTHORIZATION ASPECT] Méthode : " + method.getName());
        System.out.print("[AUTHORIZATION ASPECT] Rôles requis : ");
        for (String role : requiredRoles) {
            System.out.print(role + " ");
        }
        System.out.println();
        System.out.println("[AUTHORIZATION ASPECT] Utilisateur : " + SecurityContext.getUsername());

        boolean authorized = false;
        for (String role : requiredRoles) {
            if (SecurityContext.hasRole(role)) {
                authorized = true;
                System.out.println("[AUTHORIZATION ASPECT] ✓ Rôle trouvé : " + role);
                break;
            }
        }

        if (!authorized) {
            System.out.println("[AUTHORIZATION ASPECT] ✗ ACCÈS REFUSÉ : Rôle insuffisant");
            System.out.println("[AUTHORIZATION ASPECT] ══════════════════════\n");
            throw new RuntimeException("Not Authorized: User does not have required role");
        }

        System.out.println("[AUTHORIZATION ASPECT] ✓ ACCÈS AUTORISÉ");
        System.out.println("[AUTHORIZATION ASPECT] ══════════════════════\n");

        return joinPoint.proceed();
    }
}
