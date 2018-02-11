package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int [] num = new int[3];
       //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num[0] = Integer.parseInt(br.readLine());
        num[1] = Integer.parseInt(br.readLine());
        num[2] = Integer.parseInt(br.readLine());
        //
        int min = num[0];
        int max = num[0];
        //
        for (int i = 1;i<3;++i)
        {
            if (num[i]<min)
                min=num[i];
            if (num[i]>max)
                max=num[i];
        }
        for (int i = 0;i<3;++i)
        {
            if ((num[i]!=min)&&(num[i]!=max))
            {
                System.out.println(num[i]);
            }
        }

    }
}
