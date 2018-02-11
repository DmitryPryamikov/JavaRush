package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by DimaMarina on 30.05.2016.
 */
public abstract class DrinkMaker {
    //
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();
    //
    public final void makeDrink()
    {
        getRightCup();
        //
        putIngredient();
        //
        pour();
    }

}