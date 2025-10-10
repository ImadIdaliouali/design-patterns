package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Folder root =new Folder("Root");
        root.add(new File("Java.txt"));
        root.add(new File("pom.xml"));
        Folder src = (Folder) root.add(new Folder("src"));
        src.add(new File("data.csv"));
        src.add(new File("config.txt"));
        Folder org = (Folder) src.add(new Folder("org"));
        src.add(new File("config2.txt"));
        org.add(new File("data.bin"));
        root.display();
    }
}
