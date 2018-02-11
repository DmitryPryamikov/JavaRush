package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //
        InputStream stream = new FileInputStream(fileName);
        //
        StringBuilder builder = new StringBuilder();
        int ch;
        while (stream.available()>0)
        {
ch = stream.read();
            builder.append((char)ch);
        }
        System.out.println(builder.toString());
        stream.close();
    }
}
/*int ch;
while((ch = fis.read()) != -1){
    builder.append((char)ch);*/