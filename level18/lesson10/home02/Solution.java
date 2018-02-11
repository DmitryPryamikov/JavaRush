package com.javarush.test.level18.lesson10.home02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;




/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        String fileName = args[0];
        //
        char eChar;
        //
        int r;
        //
        int sum=0;
        //
        int probel=0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        //
        while ((r=reader.read())!=-1)
        {
            sum++;
            eChar = (char)r;

            if (eChar==' ')
            {
                probel++;
            }


        }
        reader.close();
        double result = 100*((double)probel/(double)sum);
        //
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat dc = new DecimalFormat("###.##",otherSymbols);


        System.out.println(dc.format(result));


    }
}