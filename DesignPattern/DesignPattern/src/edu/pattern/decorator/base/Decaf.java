package edu.pattern.decorator.base;

import edu.pattern.decorator.Beverage;

public class Decaf extends Beverage {
    public Decaf() {
        description = "๋์นดํ์ธ";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
