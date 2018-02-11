package com.javarush.test.level18.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* Встречаемость символов
 1Программа запускается с одним параметром - именем файла, который содержит английский текст.
 2Посчитать частоту встречания каждого символа.
 3Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
 4Вывести на консоль отсортированный результат:
 [символ1]  частота1
 [символ2]  частота2
 Закрыть потоки. Не использовать try-with-resources

 Пример вывода:
 , 19
 - 7
 f 361
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        // 1
        ArrayList<Integer> acII = new ArrayList<Integer>();
        ArrayList<Character> listCharacters = new ArrayList<Character>();
        ArrayList<Integer> frequency = new ArrayList<Integer>();
        //
        String fileName = args[0];
        //
        char eChar;
        //
        int r;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        //
        while ((r = reader.read()) != -1) {
            eChar = (char) r;
            if (!listCharacters.contains(eChar)) {
                listCharacters.add(eChar);
                //
                frequency.add(1);
                acII.add(r);
            } else {
                int index = listCharacters.indexOf(eChar);
                frequency.set(index,frequency.get(index) + 1);
            }

        }
        reader.close();
        //3
        Collections.sort(acII);
        for (int i : acII)
        {
            char temp = (char)i;
            int index = listCharacters.indexOf(temp);
            System.out.println (listCharacters.get(index)+" "+frequency.get(index));
        }
    }
}
