package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        //
        String s = reader.readLine();
        int temp = Integer.parseInt(s);
        if (temp>0)
        {
            int k = 0;
            while(k<temp)
            {
                if (k==0)
                    maximum = Integer.parseInt(reader.readLine());
                else
                {
                    int ltemp = Integer.parseInt(reader.readLine());
                    maximum = (ltemp > maximum) ? ltemp : maximum;
                }
                k++;
            }
        }

        //напишите тут2 ваш код




        System.out.println(maximum);
    }
}
