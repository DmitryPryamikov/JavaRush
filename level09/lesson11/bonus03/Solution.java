package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //создаем массивы строки и числе
        ArrayList<String> numbers = new ArrayList<String>();
        ArrayList<String> words = new ArrayList<String>();
        //
        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {
                numbers.add(array[i]);
            }
            else
            {
                words.add(array[i]);
            }
        }
        //преобразуем их в массивы
        String[] arrayWord = words.toArray(new String[words.size()]);
        String[] arrayNumbers = numbers.toArray(new String[numbers.size()]);
        //сортируем в переделах каждого массива
        for (int i = 0; i < arrayWord.length-1; i++)
        {
            for (int j = 0; j < arrayWord.length-1-i;j++)
            {
                if (isGreaterThan(arrayWord[j],arrayWord[j+1]))
                {
                    String s = arrayWord[j];
                    arrayWord[j] = arrayWord[j+1];
                    arrayWord[j+1] = s;
                }
            }
        }
        //
        for (int i = 0; i < arrayNumbers.length-1; i++)
        {
            for (int j = 0; j < arrayNumbers.length-1-i;j++)
            {
                int a = Integer.parseInt(arrayNumbers[j]);
                int b = Integer.parseInt(arrayNumbers[j+1]);
                if (a < b)
                {
                    String s = arrayNumbers[j];
                    arrayNumbers[j] = arrayNumbers[j+1];
                    arrayNumbers[j+1] = s;
                }
            }
        }
        //
        //array = new String[arrayNumbers.length+arrayWord.length];
        //обьеденяем
        int n = 0;
        int s = 0;
        for (int i =0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {
                array[i] = arrayNumbers[n];
                n++;
            }
            else
            {
                array[i] = arrayWord[s];
                s++;
            }
        }
        /*while (n < array.length)
        {
            if (isGreaterThan(arrayNumbers[i],arrayWord[i]))
            {
                array[n] = arrayNumbers[i];
                array[n+1] = arrayWord[i];
            }
            else
            {
                array[n] = arrayWord[i];
                array[n+1] = arrayNumbers[i];

            }
            n = n+2;
            i++;
        }*/




    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
