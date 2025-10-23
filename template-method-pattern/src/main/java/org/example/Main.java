package org.example;

import org.example.templates.Template;
import org.example.templates.MoroccoImpl;
import org.example.templates.SpainTemplateImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Template template = new MoroccoImpl();
        System.out.println(template.perform(2, 5));
        template = new SpainTemplateImpl();
        System.out.println(template.perform(2, 5));
    }
}
