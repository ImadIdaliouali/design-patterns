package org.example;

import org.example.entities.Employe;
import org.example.services.CalculIGRAlgerie;
import org.example.services.CalculIGRMaroc;
import org.example.services.ICalculIGR;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ICalculIGR calculMaroc = new CalculIGRMaroc();
        ICalculIGR calculAlgerie = new CalculIGRAlgerie();

        Employe emp1 = new Employe("AA123", 10000, calculMaroc);
        Employe emp2 = new Employe("BB456", 10000, calculAlgerie);

        System.out.println("Salaire net Maroc : " + emp1.getSalaireNetMensuel());
        System.out.println("Salaire net Algérie : " + emp2.getSalaireNetMensuel());
    }
}
