package com.javarush.test.level19.lesson05.task05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        Pattern p = Pattern.compile("\\p{Punct}|\n");
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileOne = reader.readLine();
        //
        String fileTwo = reader.readLine();
        //
        reader.close();
        //////////////////////
        FileReader fReader = new FileReader(fileOne);
        //
        StringBuilder builder = new StringBuilder();
        //
        while (fReader.ready())
        {
            char c = (char)fReader.read();
            String s = Character.toString(c);
            Matcher m = p.matcher(s);
            if (!m.matches())
            {
                builder.append(c);
            }
        }
        //
        fReader.close();
        //
        FileWriter fW = new FileWriter(fileTwo);
        //
        fW.write(builder.toString());
        fW.close();
    }
}