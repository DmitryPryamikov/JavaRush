package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;



/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static SimpleDateFormat inSdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
    public static SimpleDateFormat outSdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);

    public static void main(String[] args) {
        //start here - начни тут
        if (args[0].equals("-c"))
        {
            createPerson(args);
        }
        else if (args[0].equals("-u"))
        {
            updatePerson(args);
        }
        else if (args[0].equals("-d"))
        {
            deletePerson(args);
        }
        else if (args[0].equals("-i"))
        {
            getInfo(args);
        }

    }

    private synchronized static void getInfo(String[] args) {

        for (int i = 1; i < args.length; i++)
        {
            String outline ="";
            Person iPerson = allPeople.get(Integer.parseInt(args[i]));
            outline = outline+iPerson.getName();
            if (iPerson.getSex()==Sex.MALE)
            {
                outline = outline+" м";
            }
            else
            {
                outline = outline+" ж";
            }
            //
            outline=outline+" "+outSdf.format(iPerson.getBirthDay());
            System.out.println(outline);
        }


    }

    private synchronized static void deletePerson(String[] args) {
        for (int i = 1; i < args.length;i++)
        {
            Person p = allPeople.get(Integer.parseInt(args[i]));
            p.setName(null);
            p.setBirthDay(null);
            p.setSex(null);
        }

    }

    private synchronized static void updatePerson(String[] args) {
        //
        int n = 1;
        //параметры
        //
        int id;
        String date,sex,name;
        //
        //Date birthDate=null;
        date="";
        sex="";
        name="";
        //цикл по всем значениям
        while (n < args.length)
        {
            if ((args[n+2]).equals("м")||(args[n+2]).equals("ж"))
            {
                id = Integer.parseInt(args[n]);
                name = args[n+1];
                sex = args[n+2];
                date = args[n+3];
                n=n+4;
            }
            else
            {
                id = Integer.parseInt(args[n]);
                name = args[n+1]+ " "+args[n+2];
                sex = args[n+3];
                date = args[n+4];
                n=n+5;
            }
            Person uPerson = allPeople.get(id);
            //
            uPerson.setName(name);
            //sex
            if (sex.equals("м"))
            {
                uPerson.setSex(Sex.MALE);
            }
            else
            {
                uPerson.setSex(Sex.FEMALE);
            }
            //date
            try {
                uPerson.setBirthDay(inSdf.parse(date));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    private synchronized static void createPerson(String[] args) {
        // TODO Auto-generated method stub
        //шаг
        int n = 1;
        //параметры
        String date,sex,name;
        //
        Date birthDate=null;
        date="";
        sex="";
        name="";
        //цикл по всем значениям
        while (n < args.length)
        {
            if ((args[n+1]).equals("м")||(args[n+1]).equals("ж"))
            {
                name = args[n];
                sex = args[n+1];
                date = args[n+2];
                n=n+3;
            }
            else
            {
                name = args[n]+" "+args[n+1];
                sex = args[n+2];
                date = args[n+3];
                n=n+4;
            }
            //
            try {
                birthDate = inSdf.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (sex.equals("м"))
            {
                Person newMan = Person.createMale(name, birthDate);
                allPeople.add(newMan);
                System.out.println(allPeople.indexOf(newMan));
            }
            else
            {
                Person newWoman = Person.createFemale(name, birthDate);
                allPeople.add(newWoman);
                System.out.println(allPeople.indexOf(newWoman));
            }

        }


    }
}
