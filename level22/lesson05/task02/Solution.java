package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null||string.isEmpty())
        {
            throw new Solution.TooShortStringException();
        }
        char tabSymbol = '\t';
        //
        int firstSymbol = string.indexOf(tabSymbol);
        int secondIndex = string.indexOf(tabSymbol,firstSymbol+1);
        String returnString=null;
        if (firstSymbol!=-1&&secondIndex!=-1)
        {
            returnString = string.substring(firstSymbol+1,secondIndex);
        }
        else
        {
            throw new Solution.TooShortStringException();
        }
        return returnString;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
