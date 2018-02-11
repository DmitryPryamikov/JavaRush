package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int summa = 0;
        String exit = "сумма";
        String s ;//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //
        while (!((s=br.readLine()).equals(exit)))
        {
            summa+=Integer.parseInt(s);
        }
        System.out.println(summa);
    }
}
