package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

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
            deletePerson(Integer.parseInt(args[1]));
        }
        else if (args[0].equals("-i"))
        {
            getInfo(Integer.parseInt(args[1]));
        }

    }
    private static void getInfo(int idPerson) {
        String outline="";
        Person iPerson = allPeople.get(idPerson);
        outline=outline+iPerson.getName();
        //
        if (iPerson.getSex()==Sex.MALE)
        {
            outline = outline+" м";
        }
        else
        {
            outline = outline+" ж";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        outline=outline+" "+sdf.format(iPerson.getBirthDay());
        System.out.println(outline);

    }
    private static void updatePerson(String [] args) {
        ///
        //-u id name sex bd
        //
        String date, sex,name;
        //
        int idP =Integer.parseInt(args[1]);
        //get person
        Person uPeron = allPeople.get(idP);
        //name
        date="";
        sex="";
        name="";
        //
        if (args[3].equals("м")||(args[3].equals("ж")))
        {
            name=args[2];
            sex=args[3];
            date = args[4];
        }
        else
        {
            name = args[2]+" "+args[3];
            sex = args[4];
            date = args[5];

        }
        uPeron.setName(name);
        //sex
        if (sex.equals("м"))
        {
            uPeron.setSex(Sex.MALE);
        }
        else
        {
            uPeron.setSex(Sex.FEMALE);
        }
        //date
        try {
            uPeron.setBirthDay(new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(date));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    private static void createPerson(String [] args) {
        //-c Миронов м 15/04/1990
        String date,sex,name;
        date="";
        sex="";
        name="";
        if (args[2].equals("м")||(args[2].equals("ж")))
        {
            name=args[1];
            sex=args[2];
            date = args[3];
        }
        else
        {
            name = args[1]+" "+args[2];
            sex = args[3];
            date = args[4];

        }
        Date birthDate=null;
        try {
            birthDate = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(date);
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
    ////

    private static void deletePerson(int personId) {
        Person p = allPeople.get(personId);
        p.setName(null);
        p.setBirthDay(null);
        p.setSex(null);


    }

}