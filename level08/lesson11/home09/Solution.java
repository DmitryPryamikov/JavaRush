package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
        System.out.println(isDateOdd("MAY 1 2013"));

    }

    public static boolean isDateOdd(String date) throws ParseException
    {

        Date d = new Date(date);
        int year = d.getYear();
        Date newdate = new Date();
        newdate.setMonth(11);
        newdate.setDate(31);
        newdate.setYear(year-1);
        newdate.setHours(23);
        newdate.setSeconds(59);
        newdate.setMinutes(59);
        long seconds = d.getTime() - newdate.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = (int) (seconds/msDay);
        if (dayCount%2 ==0)
            return true;
        else
            return false;




    }
}
