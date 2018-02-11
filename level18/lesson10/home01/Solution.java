package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    //
    public static final char[] alphabet =  {'a','b','c','d','e','f','g','h','i','j','k','l',
            'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    //
    public static void main(String[] args) throws IOException {
        //

        //
        String fileName = args[0];
        //
        char eChar;
        //
        int r;
        //
        int sum=0;
        //
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        //
        while ((r=reader.read())!=-1)
        {
            eChar = (char)r;
            eChar = Character.toLowerCase(eChar);
            if (isEnglish(eChar))
            {
                sum++;
            }


        }
        reader.close();
        System.out.println(sum);
    }
    public static boolean isEnglish(char eCh)
    {
        for (int i=0; i<alphabet.length;i++)
        {
            if (eCh==alphabet[i])
            {
                return true;
            }
        }
        return false;
    }
}
