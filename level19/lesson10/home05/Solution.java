package com.javarush.test.level19.lesson10.home05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //fileinput
        String fileInput = args[0];
        //
        String fileOutput = args[1];
        //
        String output="";
        //
        String line="";
        //
        BufferedReader reader = new BufferedReader(new FileReader(fileInput));
        //
        while ((line = reader.readLine())!=null)
        {
            int count=0;
            String [] array = line.split(" ");
            //
            for (String s : array)
            {
                for (int i =0; i <s.length();i++)
                {
                    try {
                        Integer.parseInt(Character.toString(s.charAt(i)));
                        count++;

                    }
                    catch (NumberFormatException e)
                    {

                    }
                }
                if (count!=0)
                {
                    output=output + " "+s;
                    count=0;
                }
            }
        }
        reader.close();
        //
        output = output.trim();
        FileWriter fW = new FileWriter(fileOutput);
        fW.write(output);
        fW.close();

    }
}