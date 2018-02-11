package com.javarush.test.level14.lesson08.bonus01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        //1
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        //2
        try
        {
            int[] array = new int[5];
            int boom = array[10];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //3
        try
        {
            Object[] s = new Integer[4];
            s[0] = 4.4;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //4
        try
        {
            Object i = Integer.valueOf(42);
            String s = (String)i;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //5 negativeArraySizeException
        try
        {
            String [] s = new String[-5];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //6 null pointer
        try
        {
            String str = null;

            if(str.equals("Test")) {
            }
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //7 NumberFormatException
        try {
            String s = "FOOBAR";
            int i = Integer.parseInt(s);
            // this line of code will never be reached
            System.out.println("int value = " + i);
        }
        catch (Exception e
                ) {
            exceptions.add(e);
        }
        //8
        try
        {
            String str = "Java Code Geeks!";
            char ch = str.charAt(50);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //9
        try
        {
            throw new IllegalArgumentException("n must be positive");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //10
        try
        {
            throw new IOException("Big");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
