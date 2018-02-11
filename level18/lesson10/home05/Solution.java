package com.javarush.test.level18.lesson10.home05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


/* Округление чисел
 1 Считать с консоли 2 имени файла
 2 Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
 3 Округлить числа до целых и записать через пробел во второй файл
 4 Закрыть потоки. Не использовать try-with-resources
 Принцип округления:
 3.49 - 3
 3.50 - 4
 3.51 - 4
 -3.49 - -3
 -3.50 - -3
 -3.51 - -4
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        final int space = (int)' ';
        //1
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String filNameTwo = reader.readLine();
        reader.close();
        //2
        InputStream readFile = new FileInputStream(fileNameOne);
        //
        String number ="";
        String output="";
        while (readFile.available()>=0)
        {
            int count = readFile.available();
            int element;
            if (((element=readFile.read())==space)||(count==0))
            {
                output = output+String.valueOf(Math.round(Double.parseDouble(number)))+" ";
                if (count==0) break;
                number="";
            }
            else
            {
                number +=(char)element;
            }


        }
        readFile.close();

        output = output.substring(0,output.length()-1);
        //4
        byte[] outputByte = output.getBytes();
        OutputStream oStream = new FileOutputStream(filNameTwo);
        oStream.write(outputByte);
        oStream.close();



    }
}
