package org.example.services;

public class CalculIGRMaroc implements ICalculIGR {
    @Override
    public float calculerIGR(float salaireBrutMensuel) {
        float salaireAnnuel = salaireBrutMensuel * 12;
        float taux;

        if (salaireAnnuel < 40000)
            taux = 5;
        else if (salaireAnnuel < 120000)
            taux = 20;
        else
            taux = 42;

        return salaireAnnuel * taux / 100;
    }
}
