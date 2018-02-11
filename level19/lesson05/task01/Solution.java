package com.javarush.test.level19.lesson05.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
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
        int i = 1;
        //
        FileReader fReader = new FileReader(fileOne);
        FileWriter fWriter = new FileWriter(fileTwo);
        //
        while (fReader.ready())
        {
            int data = fReader.read();
            if (i%2==0)
            {
                fWriter.write(data);
            }
            i++;
        }
        //
        fReader.close();
        fWriter.close();

    }
}
