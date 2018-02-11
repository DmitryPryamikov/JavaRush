package com.javarush.test.level18.lesson10.home07;

import java.io.*;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //id
        int id = Integer.parseInt(args[0]);
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileName = reader.readLine();
        //
        reader.close();
        //////////////////
        String temp="";
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        //
        while ((temp=readerFile.readLine())!=null)
        {

           if (temp.startsWith(args[0]+" "))
            {
                System.out.println(temp);
                break;
            }
        }
        readerFile.close();
    }
}
////////////////////////////