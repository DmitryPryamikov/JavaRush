package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    /*
    public static void main(String[] args) throws Exception {

    	new Solution().fillInPropertiesMap();
    }*/

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileName = reader.readLine();
        //
        reader.close();
        //
        File fileProperties = new File(fileName);
        //
        InputStream is = new FileInputStream(fileProperties);
        //OutputStream os= new FileOutputStream(fileProperties);
        //
        //save(os);
        //os.flush();
        //
        load(is);
        //os.close();
        is.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        //
        for (Map.Entry<String, String> set : properties.entrySet())
        {
            prop.setProperty(set.getKey(), set.getValue());
        }
        prop.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties isProperties = new Properties();
        isProperties.load(inputStream);
        Set setProperties = isProperties.keySet();
        //
        Iterator itr = setProperties.iterator();
        while (itr.hasNext())
        {
            String key=(String)itr.next();
            properties.put(key, isProperties.getProperty(key));
        }

    }
}
