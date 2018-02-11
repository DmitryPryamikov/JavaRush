package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        ArrayList<String> families = new ArrayList<String>();
        ArrayList<String> cities = new ArrayList<String>();
        while (true)
        {
            String city = reader.readLine();
            if (city.isEmpty()) break;

            cities.add(city);
            //
            String family = reader.readLine();
            if (family.isEmpty()) break;
            //
            families.add(family);
        }

        //read home number
        String currentCity = reader.readLine();

        for (int i = 0; i < cities.size();++i)
        {
            if (cities.get(i).equals(currentCity))
            {
                System.out.println(families.get(i));
            }
        }

    }
}
