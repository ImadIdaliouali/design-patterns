package org.example.entities;

import org.example.services.ICalculIGR;

public class Employe {
    private String cin;
    private float salaireBrutMensuel;
    private ICalculIGR strategieIGR;

    public Employe(String cin, float salaireBrutMensuel, ICalculIGR strategieIGR) {
        this.cin = cin;
        this.salaireBrutMensuel = salaireBrutMensuel;
        this.strategieIGR = strategieIGR;
    }

    public float calculerIGR() {
        return strategieIGR.calculerIGR(salaireBrutMensuel);
    }

    public float getSalaireNetMensuel() {
        float igr = calculerIGR();
        float salaireNetAnnuel = salaireBrutMensuel * 12 - igr;
        return salaireNetAnnuel / 12;
    }

    // Getters et Setters
    public void setStrategieIGR(ICalculIGR strategieIGR) {
        this.strategieIGR = strategieIGR;
    }
}