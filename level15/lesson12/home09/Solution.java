package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
http://javarush.ru/alpha/index.html?obj=text&name=Amigo
Вывод:
obj name
double 3.14
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        String line, lineParameters, nameParameters="";
        String[] params;
        ArrayList<String> stringObj = new ArrayList<String>();

        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        line = reader.readLine();
        //
        lineParameters = line.substring(line.indexOf('?')+1);
        //
        params = lineParameters.split("&");
        //
        for (String s: params)
        {
    		/*String[] small = s.split("=");
    		nameParameters = nameParameters+" "+small[0];
    		if (small[0].equals("obj"))
    		{
    			if ((small[1].contains(".")))
    			{
    				doubleObj.add(Double.parseDouble(small[1]));
    			}
    			else
    			{
    				stringObj.add(small[1]);
    			}
    		}*/
            if (s.contains("=")&&(!("=".equals(s.substring(s.length()-1)))))
            {
                String [] small = s.split("=");
                nameParameters = nameParameters+" "+small[0];
                //
                if (small[0].equals("obj"))
                stringObj.add(small[1]);
            }
            else if ((s.contains("=")&&("=".equals(s.substring(s.length()-1)))))
            {
                String temp = s;
                temp = temp.substring(0,s.length()-1);
                nameParameters = nameParameters+" "+ temp;
                if (temp.equals("obj"))
                stringObj.add("");
            }
            else if (!s.contains("="))
            {
                nameParameters = nameParameters+" "+ s;
            }

        }
        nameParameters = nameParameters.substring(1);
        //

        System.out.println(nameParameters);
        //
        for (String s : stringObj)
        {
            try
            {
                double temp = Double.parseDouble(s);
                alert(temp);
            }
            catch (Exception e)
            {
                alert(s);
            }

        }


        reader.close();
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}