package com.github.seanyinx.sandbox.coffee.maker;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.BLACK;
import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.CAPPUCCINO;
import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.ESPRESSO;
import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.LATTE;
import static com.github.seanyinx.sandbox.coffee.maker.CoffeeType.MOCHA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class CoffeeMakerTest {

    private final List<String> contents = new ArrayList<>();

    private final Pourable pourable = contents::add;

    private final CoffeeMaker coffeeMaker = new CoffeeMaker();

    @Test
    public void makesCappuccino() {
        coffeeMaker.makeCoffee(pourable, CAPPUCCINO);

        assertThat(contents, contains(CAPPUCCINO.name(), CoffeeMaker.WATER));
    }

    @Test
    public void makesBlack() {
        coffeeMaker.makeCoffee(pourable, BLACK);

        assertThat(contents, contains(BLACK.name(), CoffeeMaker.WATER));
    }

    @Test
    public void makesMocha() {
        coffeeMaker.makeCoffee(pourable, MOCHA);

        assertThat(contents, contains(MOCHA.name(), CoffeeMaker.WATER));
    }

    @Test
    public void makesLatte() {
        coffeeMaker.makeCoffee(pourable, LATTE);

        assertThat(contents, contains(LATTE.name(), CoffeeMaker.WATER));
    }

    @Test
    public void makesEspresso() {
        coffeeMaker.makeCoffee(pourable, ESPRESSO);

        assertThat(contents, contains(ESPRESSO.name(), CoffeeMaker.WATER));
    }

}
