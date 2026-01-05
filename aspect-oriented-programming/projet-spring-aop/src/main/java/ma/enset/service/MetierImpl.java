package ma.enset.service;

import ma.enset.annotations.Log;
import ma.enset.annotations.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {

    @Log
    @SecuredByAspect(roles = { "USER", "ADMIN" })
    @Override
    public void process() {
        System.out.println(">>> Exécution de la méthode process() - Traitement métier en cours...");
    }

    @Log
    @SecuredByAspect(roles = { "ADMIN" })
    @Override
    public double compute() {
        System.out.println(">>> Exécution de la méthode compute() - Calcul en cours...");
        double result = Math.random() * 100;
        System.out.println(">>> Résultat du calcul : " + result);
        return result;
    }
}
