package com.javarush.test.level19.lesson08.task04;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
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
        //
        System.setOut(consoleStream);
        //
        System.out.println(getOperation(result));
    }

    private static String getOperation(String result) {
        String [] values = result.split(" ");
        //
        int res=0;
        //
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        if(values[1].equals("+"))
        {
            res = first+second;
        }
        else if (values[1].equals("-"))
        {
            res = first-second;
        }
        else if (values[1].equals("*"))
        {
            res = first*second;
        }
        int index = result.lastIndexOf(' ');
        result = result.substring(0,index+1)+String.valueOf(res)+result.substring(index+1);
        return result;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

