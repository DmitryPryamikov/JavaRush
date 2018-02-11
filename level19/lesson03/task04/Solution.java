package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner mScanner;
        //
        public PersonScannerAdapter (Scanner scanner)
        {
            mScanner = scanner;
        }

        @Override
        public Person read ()
        {
                if (mScanner.hasNext())
                {
                    Date date =null;
                    String line = mScanner.nextLine();
                    String [] data = line.split(" ");
                    DateFormat df = new SimpleDateFormat("dd MM yyyy");
                    try
                    {
                        date = df.parse(data[3] + " " + data[4] + " " + data[5]);
                    }
                    catch (ParseException e)
                    {

                    }
                    Person p = new Person(data[1], data[2], data[0], date);
                    return  p;
                }
            return null;
        }

        @Override
        public void close() throws IOException
        {
            mScanner.close();
        }
    }
}
