package com.javarush.test.level18.lesson10.home08;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        //
        String fileName="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        while (!((fileName=reader.readLine()).equals("exit")))
        {
            new ReadThread(fileName).start();
        }


    }

    public static class ReadThread extends Thread {
        //
        private String mfileName;
        public ReadThread(String fileName) {
            //implement constructor body
            mfileName = fileName;
            //start();
        }

        @Override
        public void run() {
            //
            try {
                FileInputStream inputStream = new FileInputStream(mfileName);
                //
                Map<Integer,Integer> byteMap = new HashMap<Integer, Integer>();
                //
                while (inputStream.available()>0)
                {
                    int data = inputStream.read();
                    if (!byteMap.containsKey(data))
                    {
                        byteMap.put(data, 1);
                    }
                    else
                    {

                        byteMap.put(data,byteMap.get(data)+1);
                    }
                }
                inputStream.close();
                //
                //max value
                Map.Entry<Integer, Integer> maxEntry = null;
                for (Map.Entry<Integer, Integer> entry : byteMap.entrySet())
                {
                    if (maxEntry==null||entry.getValue().compareTo(maxEntry.getValue())>0)
                    {
                        maxEntry = entry;
                    }
                }
                //
                resultMap.put(mfileName, maxEntry.getKey());
            } catch (Exception e) {

            }

        }


    }
}
