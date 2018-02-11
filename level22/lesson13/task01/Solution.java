package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args)
    {
        String [] a = getTokens("level22.lesson13.task01", null);
        for (String s :a)
        {
            System.out.println(s);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        if (query==null||query.isEmpty())
        {
            return null;
        }
        //
        if (delimiter==null||delimiter.isEmpty())
        {
            return null;
        }
        List<String> list = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        //
        while (tokenizer.hasMoreElements())
        {
            list.add(tokenizer.nextToken());
        }
        String[] array  = new String[list.size()];
        return list.toArray(array);
    }
}
