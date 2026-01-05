package ma.enset.banking.service;

import ma.enset.banking.model.Compte;

import java.util.HashMap;
import java.util.Map;

public class MetierBanqueImpl implements IMetierBanque {
    private Map<Long, Compte> comptes = new HashMap<>();

    @Override
    public void addCompte(Compte cp) {
        comptes.put(cp.getCode(), cp);
        System.out.println("Compte ajouté : " + cp);
    }

    @Override
    public void verser(Long code, double montant) {
        Compte compte = comptes.get(code);
        if (compte != null) {
            compte.setSolde(compte.getSolde() + montant);
            System.out.println("Versement effectué. Nouveau solde : " + compte.getSolde());
        } else {
            System.out.println("Compte introuvable !");
        }
    }

    @Override
    public void retirer(Long code, double montant) {
        Compte compte = comptes.get(code);
        if (compte != null) {
            compte.setSolde(compte.getSolde() - montant);
            System.out.println("Retrait effectué. Nouveau solde : " + compte.getSolde());
        } else {
            System.out.println("Compte introuvable !");
        }
    }

    @Override
    public Compte consulter(Long code) {
        Compte compte = comptes.get(code);
        if (compte != null) {
            System.out.println("Consultation : " + compte);
            return compte;
        } else {
            System.out.println("Compte introuvable !");
            return null;
        }
    }
}
