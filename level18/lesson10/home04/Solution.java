package com.javarush.test.level18.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        //
        reader.close();
        InputStream inputFileOne = new FileInputStream(fileNameOne);
        //


        //
        byte [] bufferFileOne = new byte[inputFileOne.available()];
        inputFileOne.read(bufferFileOne);
        inputFileOne.close();
        //////
        InputStream inputFileTwo = new FileInputStream(fileNameTwo);
        byte[] bufferFileTwo = new byte [inputFileTwo.available()];
        inputFileTwo.read(bufferFileTwo);
        inputFileTwo.close();
        //
        OutputStream fileTwo = new FileOutputStream(fileNameOne);
        fileTwo.write(bufferFileTwo);
        fileTwo.close();
        OutputStream fileOnetoOne = new FileOutputStream(fileNameOne,true);
        fileOnetoOne.write(bufferFileOne);
        fileOnetoOne.close();


    }
}
