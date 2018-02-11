package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;


/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        //

        String fileInput = args[0];
        String fileOutput = args[1];
        //
        FileInputStream fis = new FileInputStream(fileInput);
        byte[]bufferin = new byte[fis.available()];
        //
        Charset win1251 = Charset.forName("windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        //
        fis.read(bufferin);
        String s = new String(bufferin,utf8);
        //
        fis.close();
        byte[]bufferout = new byte[bufferin.length];
        FileOutputStream fos = new FileOutputStream(fileOutput);
        bufferout = s.getBytes(win1251);
        fos.write(bufferout,0,bufferout.length);
        fos.close();

    }
}
