package ma.enset.banking;

import ma.enset.banking.model.Compte;
import ma.enset.banking.service.IMetierBanque;
import ma.enset.banking.service.MetierBanqueImpl;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IMetierBanque metier = new MetierBanqueImpl();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  APPLICATION BANCAIRE - AspectJ Demo  ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        System.out.print("Entrez le code du compte à créer : ");
        Long code = scanner.nextLong();

        System.out.print("Entrez le solde initial : ");
        double soldeInitial = scanner.nextDouble();

        Compte compte = new Compte(code, soldeInitial);
        metier.addCompte(compte);

        boolean continuer = true;
        while (continuer) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Verser");
            System.out.println("2. Retirer");
            System.out.println("3. Consulter");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Montant à verser : ");
                    double montantVersement = scanner.nextDouble();
                    metier.verser(code, montantVersement);
                    break;

                case 2:
                    System.out.print("Montant à retirer : ");
                    double montantRetrait = scanner.nextDouble();
                    try {
                        metier.retirer(code, montantRetrait);
                    } catch (RuntimeException e) {
                        System.out.println("ERREUR : " + e.getMessage());
                    }
                    break;

                case 3:
                    metier.consulter(code);
                    break;

                case 4:
                    continuer = false;
                    System.out.println("\nMerci d'avoir utilisé l'application bancaire !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }
        }

        scanner.close();
    }
}
