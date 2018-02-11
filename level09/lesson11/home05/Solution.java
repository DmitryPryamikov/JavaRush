package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        //
        ArrayList<Character> vowel = new ArrayList<Character>();
        ArrayList<Character> Noowel = new ArrayList<Character>();
        //char[] vowel;
        //char[] novowel;
        for (int i = 0; i < text.length();i++)
        {
            if (isVowel(text.charAt(i)))
            {
                vowel.add(text.charAt(i));
            }
            else
            {
                if((text.charAt(i))!= ' ')
                Noowel.add(text.charAt(i));
            }
        }
        for (char c : vowel)
        {
            System.out.print(c +" ");
        }
        System.out.println();
        for (char c : Noowel)
        {
            System.out.print(c +" ");
        }

    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
