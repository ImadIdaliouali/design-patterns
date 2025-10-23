package org.example.templates;

public class SpainTemplateImpl extends Template {
    @Override
    protected int param1() {
        return 9;
    }

    @Override
    protected double compute(int a, int b) {
        return a*b;
    }
}
