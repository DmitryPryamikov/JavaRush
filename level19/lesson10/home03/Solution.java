package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        //
        String fileName = args[0];
        //
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        //
        String line="";
        //
        while ((line=reader.readLine())!=null)
        {
            int dateIndex = getDayIndex(line);
            //
            String [] values = line.split(" ");

            //
            String name="";
            //
            for (int i =0; i< dateIndex;i++)
            {
                name = name+" "+ values[i];
            }
            //
            name = name.trim();
            //
            Date personDate = new Date();
            personDate.setYear(Integer.parseInt(values[dateIndex+2])-1900);
            personDate.setDate(Integer.parseInt(values[dateIndex]));
            personDate.setMonth(Integer.parseInt(values[dateIndex+1])-1);
            //
            System.out.println(name+" "+personDate);
            //
            PEOPLE.add(new Person(name, personDate));
        }
        reader.close();
    }

    private static int getDayIndex(String line) {
        String [] values = line.split(" ");
        int index = 0;
        //
        for (int i = 0; i < values.length; i++)
        {
            try {
                Integer.parseInt(values[i]);
                index = i;
                break;
            }
            catch (NumberFormatException e)
            {

            }
        }
        return index;
    }

}