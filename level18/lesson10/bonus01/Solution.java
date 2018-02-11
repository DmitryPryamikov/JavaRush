package com.javarush.test.level18.lesson10.bonus01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //
        if (args[0].equals("-e"))
        {
            shifrData (args);
        }
        else if (args[0].equals("-d"))
        {
            deShifrData(args);
        }

    }

    private static void deShifrData(String[] args) throws IOException {
        InputStream is = new FileInputStream(args[1]);
        //
        byte[] data = new byte[is.available()];
        is.read(data);
        //
        is.close();
        OutputStream os = new FileOutputStream(args[2]);
        //
        os.write(reverseArray (data));
        os.close();

    }

    private static void shifrData(String[] args) throws IOException {
        InputStream is = new FileInputStream(args[1]);
        //
        byte[] data = new byte[is.available()];
        is.read(data);
        //
        is.close();
        OutputStream os = new FileOutputStream(args[2]);
        //
        os.write(reverseArray (data));
        os.close();

    }

    private static byte[] reverseArray(byte[] data) {
        byte [] newByte = new byte[data.length];
        //
        int k=0;
        for (int i = (data.length-1);i>=0;i--)
        {
            newByte[k] = data[i];
            k++;
        }
        //
        return newByte;
    }

}
