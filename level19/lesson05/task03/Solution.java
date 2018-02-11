package com.javarush.test.level19.lesson05.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileOne = reader.readLine();
        //
        String fileTwo = reader.readLine();
        //
        reader.close();
        FileReader fReader = new FileReader(fileOne);
        StringBuilder builder = new StringBuilder();
        //
        while (fReader.ready())
        {
            builder.append((char)fReader.read());
        }
        //
        fReader.close();
        //
        String [] numbers = builder.toString().split(" ");
        //
        FileWriter fWriter = new FileWriter(fileTwo);
        //
        String output="";
        for (String s:numbers)
        {
            try
            {
                int value = Integer.parseInt(s);
                output=output+s+" ";
            }
            catch (NumberFormatException e)
            {

            }
        }
        output=output.trim();
        fWriter.write(output);
        //
        fWriter.close();

    }
}
