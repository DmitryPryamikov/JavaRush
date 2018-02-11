package com.javarush.test.level26.lesson02.task01;

import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double median = 0;
        //
        Integer[]localArraay = array;
        //
        Arrays.sort(localArraay);
        //
        if (localArraay.length%2==0)
        {
            median = (localArraay[localArraay.length/2]+localArraay[localArraay.length/2-1])/2.0;
        }
        else
        {
            median = localArraay[localArraay.length/2];
        }
        //
        final double finalMedian = median;
        //
        Comparator<Integer> comparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int result  = (int)(Math.abs(o1-finalMedian)-Math.abs(o2-finalMedian));
                 return  result==0?o1-o2:result;
            }
        };
        Arrays.sort(array,comparator);
        /*localArraay = new  Integer[array.length];
        /////////////////////////////////////////////
        for (int i =0; i < localArraay.length;i++)
        {
            if (array[i]>median)
            {
                localArraay[i] = array[i]-median;
            }
            else
            {
                localArraay[i] = median-array[i];
            }
        }
        //
        Map<Integer,Integer> maps = new HashMap<Integer, Integer>();
        //
        for (int i = 0 ; i < localArraay.length;i++)
        {
            maps.put(localArraay[i],array[i]);
        }
        Map<Integer,Integer> sortredMap = new TreeMap<>(maps);
        int i=0;

        for (Map.Entry<Integer,Integer> entry : sortredMap.entrySet())
        {
            array[i++] = entry.getValue();
        }*/
        return array;
    }
    //
   public static void main(String[] args)
    {
        Integer[] arr1 = {2, 5, 6, 7, 21, 1};
        Integer[] arr = sort(arr1);
        for (Integer i : arr)
        {
            System.out.println(i);
        }
    }
}
