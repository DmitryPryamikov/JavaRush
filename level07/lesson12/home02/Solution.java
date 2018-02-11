package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        int N, M;
        //
        ArrayList<String> list = new ArrayList<String>();
        //
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        //
        for (int i = 0; i < N;i++)
            list.add(i,reader.readLine());
        //
        for (int i = 0; i<M;i++)
        {
            list.add(list.get(i));
        }
        int k = 0;
        while (k<M)
        {
            list.remove(0);
            k++;
        }
        //
        for (int i = 0; i<list.size();i++)
        {
            System.out.println(list.get(i));
        }

        //напишите тут ваш код
    }
}
