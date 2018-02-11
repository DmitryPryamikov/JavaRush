package com.javarush.test.level18.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        String fileName="";
        InputStream is=null;
        BufferedReader reader = null;
        try{

            reader = new BufferedReader(new InputStreamReader(System.in));
            while ((fileName=reader.readLine())!=null)
            {
                is = new FileInputStream(fileName);
                int count = is.available();
                is.close();
            }

        }
        catch (FileNotFoundException e)
        {

            System.out.println(fileName);
        }
        finally
        {
            reader.close();
            if (is!=null)is.close();
        }
    }
}