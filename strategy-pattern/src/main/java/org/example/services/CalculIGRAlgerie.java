package org.example.services;

public class CalculIGRAlgerie implements ICalculIGR {
    @Override
    public float calculerIGR(float salaireBrutMensuel) {
        float salaireAnnuel = salaireBrutMensuel * 12;
        float taux = 35;
        return salaireAnnuel * taux / 100;
    }
}
