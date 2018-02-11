package com.javarush.test.level19.lesson05.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        Pattern p = Pattern.compile("\\p{Punct}");
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileName = reader.readLine();
        //
        reader.close();
        FileReader fReader = new FileReader(fileName);
        //
        String word="";
        int count=0;
        while (fReader.ready())
        {

            char c = ((char)fReader.read());

                word=word+c;


        }
        fReader.close();
        word = word.replaceAll("\\p{Punct}"," ").toLowerCase();
        word=word.replaceAll("\\s"," ");
        String [] words = word.split(" ");
        for (String s: words)
        {
            if (s.equals("world")) count++;
        }

        System.out.println(count);
    }
}