package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> mapCat = new HashMap<String, Cat>();
        mapCat.put("Вася", new Cat("Вася"));
        mapCat.put("Маша", new Cat("Маша"));
        mapCat.put("Саша", new Cat("Саша"));
        mapCat.put("Петя", new Cat("Петя"));
        mapCat.put("Барсик", new Cat("Барсик"));
        //
        mapCat.put("Вася1", new Cat("Вася1"));
        mapCat.put("Маша1", new Cat("Маша1"));
        mapCat.put("Саша1", new Cat("Саша1"));
        mapCat.put("Петя1", new Cat("Петя1"));
        mapCat.put("Барсик1", new Cat("Барсик1"));

        return  mapCat;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> cats = new HashSet<Cat>();
        for (Map.Entry<String,Cat> entry : map.entrySet())
        {
                cats.add(entry.getValue());
        }

        return cats;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
