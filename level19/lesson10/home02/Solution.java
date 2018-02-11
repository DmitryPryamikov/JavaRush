package com.javarush.test.level19.lesson10.home02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String fileName = args[0];
        //
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        //
        String line="";
        Map<String, Double> salaries = new HashMap<String, Double>();
        //
        while ((line=reader.readLine())!=null)
        {
            String [] values = line.split(" ");
            if (salaries.containsKey(values[0]))
            {
                salaries.put(values[0], salaries.get(values[0])+Double.parseDouble(values[1]));
            }
            else
            {
                salaries.put(values[0], Double.parseDouble(values[1]));
            }
        }
        //
        reader.close();
        //
        Map.Entry<String, Double> maxEntry=null;
        //
        for (Map.Entry<String, Double> pair: salaries.entrySet())
        {
            if (maxEntry==null||(maxEntry.getValue().compareTo(pair.getValue()))<0)
            {
                maxEntry = pair;
            }
        }
        //
        for(Map.Entry<String, Double> pair: salaries.entrySet())
        {
            //
            if (pair.getValue()==maxEntry.getValue())
            {
                System.out.println(maxEntry.getKey());
            }
        }

    }
}