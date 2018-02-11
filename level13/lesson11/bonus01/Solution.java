package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String line;
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //
        InputStream fis = new FileInputStream(fileName);
        reader = new BufferedReader(new InputStreamReader(fis));

        while ((line=reader.readLine())!=null)
        {


            if (Integer.parseInt(line)%2==0)
            {
                //System.out.println(Integer.parseInt(line));
                list.add(Integer.parseInt(line));
            }
        }
        fis.close();
        Collections.sort(list);
        for (int i:list)
        {
            System.out.println(i);
        }
    }
}
