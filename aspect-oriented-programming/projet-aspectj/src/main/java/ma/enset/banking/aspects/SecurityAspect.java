package ma.enset.banking.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {

    @Pointcut("execution(* ma.enset.banking.Application.main(..))")
    public void applicationStart() {
    }

    @Around("applicationStart()")
    public Object authenticate(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   AUTHENTIFICATION REQUISE             ║");
        System.out.println("╚════════════════════════════════════════╝");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username : ");
        String username = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        if ("root".equals(username) && "1234".equals(password)) {
            System.out.println("\n✓ Authentification réussie ! Bienvenue " + username);
            System.out.println("Démarrage de l'application...\n");

            return joinPoint.proceed();
        } else {
            System.out.println("\n✗ ACCÈS REFUSÉ : Credentials invalides !");
            System.out.println("L'application ne peut pas démarrer.");

            throw new SecurityException("Access Denied: Invalid credentials");
        }
    }
}
