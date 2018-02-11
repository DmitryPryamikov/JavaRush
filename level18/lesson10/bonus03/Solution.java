package com.javarush.test.level18.lesson10.bonus03;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        //
        if (args[0].equals("-u"))
        {
            updateData(fileName, args);
        }
        else if (args[0].equals("-d"))
        {
            deleteID (fileName, args);
        }
    }

    private static void deleteID(String fileName, String[] args) throws IOException {
        String id = args[1];
        //
        BufferedReader reader = new BufferedReader (new FileReader(fileName));
        String line="";
        //
        ArrayList<String> dataList = new ArrayList<>();
        //
        while ((line=reader.readLine())!=null)
        {
            String loclalID = line;
            if (loclalID.length()<8) continue;

            loclalID = loclalID.substring(0,8);
            loclalID = loclalID.trim();
            if (!loclalID.equals(id))
            {
                dataList.add("\r\n"+line);
            }

        }
        reader.close();
        OutputStream os = new FileOutputStream(fileName);
        String output="";
        for (String s : dataList)
        {
            output=output+s;
        }
        os.write(output.getBytes());
        os.close();

    }

    private static void updateData(String fileName, String[] args) throws IOException {
        //
        String id = args[1];
        //
        BufferedReader reader = new BufferedReader (new FileReader(fileName));
        String line = "";
        //
        ArrayList<String> dataList = new ArrayList<>();
        //
        while ((line = reader.readLine())!=null)
        {
            String idLine = line;
            if (line.length()<8) continue;
            idLine = idLine.substring(0,8);
            idLine = idLine.trim();

            String wholeLineString = line;

            if (id.equals(idLine.toString()))
            {
                String m_productName="";
                for (int i = 2; i< args.length-2;i++)
                {
                    m_productName = m_productName+args[i]+" ";
                }
                String m_price=args[args.length-2];
                String m_quantity=args[args.length-1];
                //
                while (id.length()!=8)
                {
                    id=id+" ";
                }
                //
                while (m_productName.length()!=30)
                {
                    if (m_productName.length()>30)
                    {
                        m_productName=m_productName.substring(0,30);
                    }
                    else
                    {
                        m_productName=m_productName+" ";
                    }
                }
                //
                while (m_price.length()!=8)
                {
                    m_price = m_price+" ";
                }
                //
                while (m_quantity.length()!=4)
                {
                    m_quantity = m_quantity+" ";
                }
                String output = "\r\n"+id+m_productName+m_price+m_quantity;
                dataList.add(output);

            }
            else
            {
                dataList.add("\r\n"+wholeLineString);
            }

        }
        reader.close();
        OutputStream os = new FileOutputStream(fileName);
        String output="";
        for (String s : dataList)
        {
            output=output+s;
        }
        os.write(output.getBytes());
        os.close();



    }
}
