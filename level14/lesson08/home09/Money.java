package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double wholeSum;
    public Money(double amount)
    {
        wholeSum = amount;
    }

    public double getAmount()
    {
        return wholeSum;
    }

    public abstract String getCurrencyName();
}

