package com.oneapm.coffee.maker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.oneapm.coffee.maker.CoffeeType.BLACK;
import static com.oneapm.coffee.maker.CoffeeType.CAPPUCCINO;
import static com.oneapm.coffee.maker.CoffeeType.ESPRESSO;
import static com.oneapm.coffee.maker.CoffeeType.LATTE;
import static com.oneapm.coffee.maker.CoffeeType.MOCHA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

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
