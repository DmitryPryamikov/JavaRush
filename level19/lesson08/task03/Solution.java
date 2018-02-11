package com.javarush.test.level19.lesson08.task03;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //
        PrintStream consoleStream = System.out;
        //
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //
        PrintStream stream = new PrintStream(outputStream);
        //
        System.setOut(stream);
        //
        testString.printSomething();
        //
        String result = outputStream.toString();
        //
        System.setOut(consoleStream);
        //
        String output="";
        //
        for (int i = 0; i<result.length();i++)
        {
            char c = result.charAt(i);
            try
            {
                Integer.parseInt(Character.toString(c));
                output=output+c;
            }
            catch (NumberFormatException e)
            {

            }

        }
        //
        System.out.println(output);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}