package com.javarush.test.level18.lesson10.home10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;


/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName="";
        ArrayList<String> fileParts = new ArrayList<>();
        //
        while (!(fileName=reader.readLine()).equals("end"))
        {
            fileParts.add(fileName);
        }
        //
        reader.close();
        //
        Collections.sort(fileParts);
        //
        String [] fileSplit = fileParts.get(0).split("\\.");
        fileName = fileSplit[0]+"."+fileSplit[1];
        //
        File output = new File(fileName);
        OutputStream fileOutput = new FileOutputStream(fileName,true);

        for (String s: fileParts)
        {
            InputStream iStream = new FileInputStream(s);
            byte[]buffer = new byte[iStream.available()];
            iStream.read(buffer);
            iStream.close();
            fileOutput.write(buffer);
        }
        //
        fileOutput.close();
    }
}
