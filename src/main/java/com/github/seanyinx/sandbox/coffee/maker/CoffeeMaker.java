package com.github.seanyinx.sandbox.coffee.maker;

import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.BLACK;
import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.CAPPUCCINO;
import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.ESPRESSO;
import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.LATTE;
import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.MOCHA;

public class CoffeeMaker {
    static final String WATER = "Water";

    public void makeCoffee(
            Pourable pourable,
            CoffeeType type
    ) {
        if (type == CAPPUCCINO) {
            pouringCappuccinoPowder(pourable);
        } else if (type == BLACK) {
            pouringBlackPowder(pourable);
        } else if (type == MOCHA) {
            pouringMochaPowder(pourable);
        } else if (type == LATTE) {
            pouringLattePowder(pourable);
        } else if (type == ESPRESSO) {
            pouringEspressoPowder(pourable);
        }

        pouringBoilingWater(pourable);
    }

    private void pouringBoilingWater(Pourable pourable) {
        pourable.pour(WATER);
    }

    private void pouringBlackPowder(Pourable pourable) {
        // more secret recipe here
        pourable.pour(BLACK.name());
    }

    private void pouringMochaPowder(Pourable pourable) {
        // more secret recipe here
        pourable.pour(MOCHA.name());
    }

    private void pouringLattePowder(Pourable pourable) {
        // more secret recipe here
        pourable.pour(LATTE.name());
    }

    private void pouringEspressoPowder(Pourable pourable) {
        // more secret recipe here
        pourable.pour(ESPRESSO.name());
    }

    private void pouringCappuccinoPowder(Pourable pourable) {
        // more secret recipe here
        pourable.pour(CAPPUCCINO.name());
    }
}
