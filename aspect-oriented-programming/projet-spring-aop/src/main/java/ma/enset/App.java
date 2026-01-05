package ma.enset;

import ma.enset.config.AppConfig;
import ma.enset.security.SecurityContext;
import ma.enset.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║  APPLICATION SPRING AOP - Démonstration       ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        System.out.println("→ Initialisation du contexte Spring...");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("✓ Contexte Spring initialisé\n");

        IMetier metier = context.getBean(IMetier.class);
        System.out.println("✓ Bean IMetier récupéré (Type réel : " + metier.getClass().getName() + ")");
        System.out.println("  → Notez que c'est un PROXY créé par Spring, pas l'instance MetierImpl directe\n");

        System.out.println("\n" + "═".repeat(60));
        System.out.println("SCÉNARIO 1 : Authentification avec rôle USER");
        System.out.println("═".repeat(60));

        SecurityContext.authenticate("alice", "pass123", new String[] { "USER" });

        System.out.println("\n→ Appel de process() (requiert USER ou ADMIN)...");
        try {
            metier.process();
            System.out.println("✓ Méthode process() exécutée avec succès");
        } catch (RuntimeException e) {
            System.out.println("✗ Erreur : " + e.getMessage());
        }

        System.out.println("\n→ Appel de compute() (requiert ADMIN uniquement)...");
        try {
            metier.compute();
            System.out.println("✓ Méthode compute() exécutée avec succès");
        } catch (RuntimeException e) {
            System.out.println("✗ Erreur : " + e.getMessage());
        }

        System.out.println("\n\n" + "═".repeat(60));
        System.out.println("SCÉNARIO 2 : Authentification avec rôle ADMIN");
        System.out.println("═".repeat(60));

        SecurityContext.authenticate("bob", "admin456", new String[] { "ADMIN" });

        System.out.println("\n→ Appel de process() (requiert USER ou ADMIN)...");
        try {
            metier.process();
            System.out.println("✓ Méthode process() exécutée avec succès");
        } catch (RuntimeException e) {
            System.out.println("✗ Erreur : " + e.getMessage());
        }

        System.out.println("\n→ Appel de compute() (requiert ADMIN uniquement)...");
        try {
            double result = metier.compute();
            System.out.println("✓ Méthode compute() exécutée avec succès - Résultat : " + result);
        } catch (RuntimeException e) {
            System.out.println("✗ Erreur : " + e.getMessage());
        }

        System.out.println("\n\n" + "═".repeat(60));
        System.out.println("SCÉNARIO 3 : Authentification avec rôle GUEST (aucun accès)");
        System.out.println("═".repeat(60));

        SecurityContext.authenticate("charlie", "guest789", new String[] { "GUEST" });

        System.out.println("\n→ Appel de process() (requiert USER ou ADMIN)...");
        try {
            metier.process();
            System.out.println("✓ Méthode process() exécutée avec succès");
        } catch (RuntimeException e) {
            System.out.println("✗ Erreur : " + e.getMessage());
        }

        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║  Démonstration terminée                        ║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }
}
