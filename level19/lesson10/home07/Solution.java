package com.javarush.test.level19.lesson10.home07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        String fileInput = args[0];
        String fileOutput = args[1];
        //
        String line="";
        String outString="";
        //
        BufferedReader reader = new BufferedReader(new FileReader(fileInput));
        //
        while ((line=reader.readLine())!=null)
        {
            String [] array = line.split(" ");
            //
            for (String s: array)
            {
                if (s.length()>6)
                {
                    outString=outString+","+s;
                }
            }
        }
        outString=outString.substring(1);
        reader.close();
        FileWriter fw = new FileWriter(fileOutput);
        fw.write(outString);
        fw.close();


    }
}