package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human gFather1 = new Human();
        gFather1.name = "Дед Вася";
        gFather1.age = 85;
        gFather1.sex = true;
        //второй дед
        Human gFather2 = new Human();
        gFather2.name = "Дед Коля";
        gFather2.age = 88;
        gFather2.sex = true;
        //бабуля 1
        Human gMother1 = new Human();
        gMother1.name = "Баба Валя";
        gMother1.age = 85;
        gMother1.sex = false;
        //
        Human gMother2 = new Human();
        gMother2.name = "Баба Галя";
        gMother2.age = 88;
        gMother2.sex = false;
        //Отец
        Human father = new Human();
        father.name = "Толя";
        father.age = 55;
        father.sex = true;
        //Мать
        Human mother = new Human();
        mother.name = "Таня";
        mother.age = 55;
        mother.sex = false;
        //Дети
        Human child1= new Human();
        child1.name = "Саша";
        child1.age = 15;
        child1.sex = true;
        //
        Human child2= new Human();
        child2.name = "Петя";
        child2.age = 20;
        child2.sex = true;
        //
        Human child3= new Human();
        child3.name = "Оля";
        child3.age = 10;
        child3.sex = false;
        //
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        //
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);
        //
        gFather1.children.add(father);
        gMother1.children.add(father);
        //
        gFather2.children.add(mother);
        gMother2.children.add(mother);
        //
        System.out.println(gFather1);
        System.out.println(gFather2);
        System.out.println(gMother1);
        System.out.println(gMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();
        //напишите тут ваш код


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
