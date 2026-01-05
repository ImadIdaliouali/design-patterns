package ma.enset.banking.aspects;

import ma.enset.banking.model.Compte;
import ma.enset.banking.service.IMetierBanque;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PatchRetraitAspect {

    @Around("execution(* ma.enset.banking.service.IMetierBanque.retirer(..)) && args(code, montant)")
    public Object patchRetrait(ProceedingJoinPoint joinPoint, Long code, double montant) throws Throwable {
        System.out.println("\n[PATCH] Interception de la méthode retirer()");
        System.out.println("[PATCH] Vérification du solde avant retrait...");

        IMetierBanque metier = (IMetierBanque) joinPoint.getTarget();
        Compte compte = metier.consulter(code);

        if (compte == null) {
            System.out.println("[PATCH] Compte introuvable, abandon du retrait");
            return null;
        }

        if (compte.getSolde() < montant) {
            System.out.println("[PATCH] ERREUR : Solde insuffisant !");
            System.out.println("[PATCH] Solde actuel : " + compte.getSolde() + " | Montant demandé : " + montant);
            throw new RuntimeException("Solde insuffisant pour effectuer ce retrait");
        }

        System.out.println("[PATCH] Solde suffisant, autorisation du retrait");

        return joinPoint.proceed();
    }
}
