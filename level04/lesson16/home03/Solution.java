package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int summ = 0;
        boolean exit = false;
        while(!exit)
        {
            int i = Integer.parseInt(br.readLine());
            if (i==(-1))
            {
                summ+=i;
                System.out.println(summ);
                exit = true;
            }
            else
            {
                summ+=i;
            }
        }

    }
}
