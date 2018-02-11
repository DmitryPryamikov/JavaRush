package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        /*for(int i = 0; i < s.length();++i)
        {
            char space = ' ';
           if (i!=0)
           {
               if ((s.charAt(i) != space) && (s.charAt(i - 1) == space))
               {
                   Character.toUpperCase(s.charAt(i));
               }
           }
            else
           {
               if (s.charAt(i) != space)
               Character.toUpperCase(s.charAt(i));
           }
        }*/

        //напишите тут ваш код
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length;++i)
        {
            if ((i==0)&&(!Character.isWhitespace(array[i])))
            {
                array[i] = Character.toUpperCase(array[i]);
            }
            else if (i!=0)
            {
                if ((Character.isWhitespace(array[i - 1])) &&(!Character.isWhitespace(array[i])))
                {
                    array[i] = Character.toUpperCase(array[i]);
                }
               }
            //

        }
        System.out.println(new String(array));
        /*char[] array = value.toCharArray();
	// Uppercase first letter.
	array[0] = Character.toUpperCase(array[0]);

	// Uppercase all letters that follow a whitespace character.
	for (int i = 1; i < array.length; i++) {
	    if (Character.isWhitespace(array[i - 1])) {
		array[i] = Character.toUpperCase(array[i]);
	    }
	}

	// Result.
	return new String(array);*/
    }


}
