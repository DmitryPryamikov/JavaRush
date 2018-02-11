package com.javarush.test.level18.lesson10.bonus02;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;



/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
        String m_productName="";
        for (int i = 1; i< args.length-2;i++)
        {
            m_productName = m_productName+args[i]+" ";
        }
        String m_price=args[args.length-2];
        String m_quantity=args[args.length-1];

        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //
        String fileName = reader.readLine();
        //
        reader.close();
        //
        reader = new BufferedReader( new FileReader(fileName));
        String line="";
        //
        ArrayList<Integer> idList = new ArrayList<Integer>();
        //
        while( (line=reader.readLine())!=null)
        {

            if (line.length()<8) continue;
            line=line.substring(0,8);
            line = line.trim();
            idList.add(Integer.parseInt(line));

        }
        reader.close();
        //
        Collections.sort(idList);
        //
        int max = idList.get(idList.size()-1)+1;
        //записываем данные
        String id = String.valueOf(max);
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
        OutputStream os = new FileOutputStream(fileName,true);
        os.write(output.getBytes());
        os.close();




    }
}
