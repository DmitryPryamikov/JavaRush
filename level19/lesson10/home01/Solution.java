package com.javarush.test.level19.lesson10.home01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //получем имя файла
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
        Comparator<Map.Entry<String, Double>> byMapValues = new Comparator<Map.Entry<String,Double>>() {

            @Override
            public int compare(Entry<String, Double> o1,
                               Entry<String, Double> o2) {
                // TODO Auto-generated method stub
                return o1.getKey().compareTo(o2.getKey());
            }
        };
        Set<Entry<String,Double>> set = salaries.entrySet();
        //
        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
        //
        Collections.sort(list, byMapValues);
        //
        for (Map.Entry<String , Double> entry: list)
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}