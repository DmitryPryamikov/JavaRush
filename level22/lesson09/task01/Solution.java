package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileName = br.readLine();
        //
        br.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line="";
        StringBuilder sb = new StringBuilder();
        //
        while ((line = fileReader.readLine())!=null)
        {
            sb.append(line);
            sb.append(" ");
        }
        fileReader.close();
        String lresult = sb.toString();
        lresult = lresult.trim();
        String [] list = lresult.split(" ");
        //
        Map<String, String>pairs = new HashMap<String,String>();
        for (int i = 0; i < list.length;i++)
        {
            StringBuilder sbLocal = new StringBuilder();
            sbLocal.append(list[i]);
            sbLocal.reverse();
            String temp = sbLocal.toString();
            for (int j=i+1;j<list.length;j++)
            {
                if (pairs.containsKey(list[i]))
                    continue;
                if (pairs.containsKey(temp))
                    continue;
                if (list[j].equals(temp))
                {
                    pairs.put(list[i], temp);
                }
            }
        }
        //
        for(Map.Entry<String,String> entry: pairs.entrySet()) {
            Pair pair = new Pair();
            pair.first = entry.getKey(); pair.second=entry.getValue();
            result.add(pair);
        }
        //
        for (Pair p:Solution.result)
        {
            System.out.println(p);
        }

    }



    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
