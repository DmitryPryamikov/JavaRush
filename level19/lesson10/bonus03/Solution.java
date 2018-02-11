package com.javarush.test.level19.lesson10.bonus03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //
        String tag = args[0];
        //
        String openTag = '<'+tag;
        String closedTag = "</"+tag;
        //
        //
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //
        Stack<Integer> locationStack = new Stack<>();
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String osFileName = reader.readLine();
        //
        reader.close();
        //
        BufferedReader reader1 = new BufferedReader(new FileReader(osFileName));

        StringBuilder builder = new StringBuilder();
        //
        String textLine="";
        while ((textLine=reader1.readLine())!=null)
        {
            builder.append(textLine);
        }

        String fileName =builder.toString().replaceAll("\r\n", "");
        //
        reader.close();
        //
        for (int i =0; i<fileName.length();i++)
        {
            if (fileName.charAt(i)=='<')
            {
                String tempOpen="<";
                String tempClosed="</";
                for (int j = 0; j<tag.length();j++)
                {
                    tempClosed = tempClosed+fileName.charAt(i+2+j);
                    tempOpen = tempOpen+fileName.charAt(i+1+j);
                }
                //
                if (tempOpen.equals(openTag))
                {
                    locationStack.push(i);
                }
                else if (tempClosed.equals(closedTag))
                {
                    map.put(locationStack.pop(), i+closedTag.length()+1);
                }
            }
            //
        }
        //
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        //
        for (Map.Entry<Integer, Integer> eSet :set)
        {
            System.out.println(fileName.substring(eSet.getKey(),eSet.getValue()));
        }

    }
}
