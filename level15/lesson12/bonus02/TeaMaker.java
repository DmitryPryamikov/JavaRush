package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by DimaMarina on 30.05.2016.
 */
public class TeaMaker extends DrinkMaker{

    @Override
    void getRightCup() {
        // TODO Auto-generated method stub
        System.out.println("Берем чашку для чая");

    }

    @Override
    void putIngredient() {
        // TODO Auto-generated method stub
        System.out.println("Насыпаем чай");
    }

    @Override
    void pour() {
        // TODO Auto-generated method stub
        System.out.println("Заливаем водой");
    }

}
