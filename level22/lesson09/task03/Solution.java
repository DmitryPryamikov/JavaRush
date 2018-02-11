package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileName = reader.readLine();
        //
        reader.close();
        //
        BufferedReader filereader = new BufferedReader (new FileReader(fileName));
        //
        String line = "";
        String wholeNames="";
        //
        while ((line = filereader.readLine())!=null)
        {
            wholeNames = wholeNames+line+" ";
        }
        wholeNames = wholeNames.trim();
        filereader.close();
        //
        String [] names = wholeNames.split(" ");

        StringBuilder result = getLine(names);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        //
        if (words == null || words.length == 0)
            return new StringBuilder();
        //
        if (words.length==1)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(words[0]);
            return sb;
        }
        //
        List<String> arrayList = new ArrayList<String>();
        //
        for (String s: words)
        {
            arrayList.add(s);
        }
        //
        int quantity = arrayList.size();
        //
        StringBuilder resultBuilder = new StringBuilder();
        //
        while (true)
        {
            //переменная для записывания слов
            int wordCounter = 0;
            //
            List<String> tempList = new ArrayList<String>(arrayList);
            //
            Collections.shuffle(tempList);
            //
            StringBuilder tempBuilder = new StringBuilder();
            tempBuilder.append(tempList.get(0));
            tempList.remove(0);
            //
            boolean canAdd = true;
            while (canAdd)
            {
                List<String> wordtoRemove = new ArrayList<String>();
                for (String s: tempList)
                {
                    StringBuilder word = new StringBuilder(s);
                    //добавляем в конец
                    if ((tempBuilder.substring(tempBuilder.length()-1)).equalsIgnoreCase(word.reverse().substring(word.length()-1)))
                    {
                        wordCounter++;
                        wordtoRemove.add(s);
                        tempBuilder.append(" "+s);
                        continue;
                    }
                    if (tempBuilder.toString().substring(0,1).equalsIgnoreCase(s.substring(s.length()-1)))
                    {
                        tempBuilder.reverse().append(" "+ word);
                        tempBuilder.reverse();
                        wordtoRemove.add(s);
                        wordCounter++;
                        continue;
                    }
                }
                //
                for (String s : wordtoRemove)
                {
                    tempList.remove(s);
                }
                //
                wordtoRemove.clear();
                //
                for (String s : tempList)
                {
                    StringBuilder word = new StringBuilder(s);
                    //
                    if (!tempBuilder.substring(tempBuilder.length()-1).equalsIgnoreCase(word.reverse().substring(word.length()-1))&&!tempBuilder.toString().substring(0,1).equalsIgnoreCase(s.substring(s.length()-1)))
                    {
                        canAdd = false;
                    }
                }
                if (tempList.size()==0)
                {
                    canAdd = false;
                }

            }
            //
            resultBuilder=tempBuilder;
            if (wordCounter==quantity-1)
            {
                return resultBuilder;
            }

        }
    }
}
//////////////