package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by DimaMarina on 30.05.2016.
 */
public class LatteMaker extends DrinkMaker{

    @Override
    void getRightCup() {
        System.out.println("Берем чашку для латте");

    }

    @Override
    void putIngredient() {
        // TODO Auto-generated method stub
        System.out.println("Делаем кофе");

    }

    @Override
    void pour() {
        // TODO Auto-generated method stub
        System.out.println("Заливаем молоком с пенкой");

    }

}
