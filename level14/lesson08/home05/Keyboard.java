package com.javarush.test.level14.lesson08.home05;

/**
 * Created by DimaMarina on 15.05.2016.
 */
public class Keyboard implements CompItem
{
    @Override
    public String getName()
    {
        return (new Keyboard()).getClass().getSimpleName();
    }
}
