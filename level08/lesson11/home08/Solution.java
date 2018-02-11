package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        //

        //
    }

    public static void sort(int[] array)
    {
        /*for (int j = 0; j < 5; j++) {
            for (int i = array.length - 1; i > 0; i--) {
                if (array[i] > array[i - 1]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
            }

        }*/

       //напишите тут ваш
        int maxIndex = 0;
        int localIndex = 0;
        int temp = 0;
        while(maxIndex < 5)
        {
            int max = array[maxIndex];
            for(int i = maxIndex; i < array.length; ++i)
            {
                if (max < array[i])
                {
                    max = array[i];
                    localIndex = i;
                    temp = array[i];
                }

            }
            //
            array[localIndex] = array[maxIndex];
            array[maxIndex] = temp;
            maxIndex++;
        }
    }
}
