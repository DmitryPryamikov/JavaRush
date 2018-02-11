package com.javarush.test.level19.lesson05.task04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        //
        reader.close();
        //
        FileReader fReader = new FileReader(fileOne);
        //
        StringBuilder builder = new StringBuilder();
        //
        while (fReader.ready())
        {
            char c = (char)fReader.read();
            if (c=='.')
            {
                c='!';
            }
            builder.append(c);
        }
        //
        fReader.close();
        //
        FileWriter fWriter = new FileWriter(fileTwo);
        //
        fWriter.write(builder.toString());
        fWriter.close();
    }
}
