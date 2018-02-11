package com.javarush.test.level19.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileName = reader.readLine();
        //
        reader.close();
        BufferedReader freader = new BufferedReader(new FileReader(fileName));
        String line="";
        while ((line=freader.readLine())!=null)
        {
            StringBuilder sb = new StringBuilder(line);
            sb.reverse();
            System.out.println(sb.toString());
        }
        freader.close();
    }
}