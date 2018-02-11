package com.javarush.test.level18.lesson10.home03;


import java.io.*;


/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        String fileNameThree = reader.readLine();
        //
        reader.close();
        InputStream input = new FileInputStream(fileNameTwo);
        OutputStream output = new FileOutputStream(fileNameOne, true);
        //
        byte[] buffer = new byte[input.available()];
        //
        input.read(buffer);
        //
        output.write(buffer);
        //
        input.close();
        //output.close();
        ///////
        InputStream input1 = new FileInputStream(fileNameThree);
        buffer = new byte[input1.available()];
        //
        input1.read(buffer);
        output.write(buffer);
        input1.close();
        output.close();

    }
}
