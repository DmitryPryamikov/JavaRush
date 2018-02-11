package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //создаем деда//
        //читаем имя
        String grandFatherName = reader.readLine();
        //создаем обьект дед
        Cat grandFather = new Cat(grandFatherName);
        //создаем бабку//
        String grandMotherName = reader.readLine();
        //
        Cat grandMother = new Cat(grandMotherName);
        //
        String fatherName = reader.readLine();
        //
        Cat fatherCat = new Cat(fatherName,grandFather,null);
        //
        String motherName = reader.readLine();
        Cat motherCat = new Cat(motherName, null,grandMother);
        //
        String sonName = reader.readLine();
        //
        Cat sonCat = new Cat(sonName,fatherCat, motherCat);
        //
        String  dautherName = reader.readLine();
        Cat dautherCat = new Cat(dautherName,fatherCat,motherCat);

        //
        System.out.println(grandFather);
        System.out.println(grandMother);
        System.out.println(fatherCat);
        System.out.println(motherCat);
        System.out.println(sonCat);
        System.out.println(dautherCat);

        /*String motherName = reader.readLine();
        Cat catMother = new Cat(motherName);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother);

        System.out.println(catMother);
        System.out.println(catDaughter);*/
    }

    public static class Cat
    {
        private String name;
        private Cat father;
        private Cat mother;

        Cat(String name)
        {
            this.name = name;
            this.mother = null;
            this.father = null;
        }

        Cat(String name, Cat father, Cat mother)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString()
        {
            if ((father == null)&&(mother == null))
                return "Cat name is " + name + ", no mother, no father ";
            else if (((father == null)&&(mother != null)))
                return "Cat name is " + name + ", mother is " + mother.name+", no father";
            else if (((father != null)&&(mother == null)))
                return "Cat name is " + name + ", no mother, father is "+father.name;

            else
                return "Cat name is " + name + ", mother is " + mother.name+", father is "+father.name;
        }
    }
    /* public static class Cat
    {
        private String name;
        private Cat parent;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parent)
        {
            this.name = name;
            this.parent = parent;
        }

        @Override
        public String toString()
        {
            if (parent == null)
                return "Cat name is " + name + ", no mother ";
            else
                return "Cat name is " + name + ", mother is " + parent.name;
        }
    }*/

}
