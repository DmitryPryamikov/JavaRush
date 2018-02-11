package com.javarush.test.level14.lesson08.home05;

/**
 * Created by DimaMarina on 15.05.2016.
 */
public class Mouse implements CompItem
{
    @Override
    public String getName()
    {
        return new Mouse().getClass().getSimpleName();
    }
}
