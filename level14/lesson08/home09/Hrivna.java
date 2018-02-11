package com.javarush.test.level14.lesson08.home09;

/**
 * Created by DimaMarina on 16.05.2016.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public double getAmount()
    {
        return super.getAmount();
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
