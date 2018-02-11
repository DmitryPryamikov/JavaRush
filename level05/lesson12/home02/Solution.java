package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1 = new Man("im",10,"simple");
        Man man2 = new Man("im1",110,"simple1");
        //
        Woman woman1 = new Woman("you1",15,"clver");
        Woman woman2 = new Woman("you12",125,"1clver");

        //выведи их на экран тут
        System.out.println(man1.toString());
        System.out.println(man2.toString());
        System.out.println(woman1.toString());
        System.out.println( woman2.toString());
    }

    //добавьте тут ваши классы
    public static class Man
    {
        String name;
        int age;
        String address;
        //
        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        //
        public Man(String name, String address)
        {
            this.name = name;
            this.age = 30;
            this.address = address;
        }
        //
        public Man(String name, int age)
        {
            this.name = name;
            this.age = age;
            this.address = null;
        }
        public Man(int age, String address)
        {
            this.name = null;
            this.age = age;
            this.address = address;
        }
        public String toString ()
        {
            //[name + " " + age + " " + address]
            return name+" "+age+" "+address;
        }
    }
    //
    public static class Woman
    {
        String name;
        int age;
        String address;
        //
        public Woman (String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        //
        public Woman (String name, String address)
        {
            this.name = name;
            this.age = 30;
            this.address = address;
        }
        //
        public Woman (String name, int age)
        {
            this.name = name;
            this.age = age;
            this.address = null;
        }
        public Woman (int age, String address)
        {
            this.name = null;
            this.age = age;
            this.address = address;
        }
        //
        public String toString ()
        {
            //[name + " " + age + " " + address]
            return name+" "+age+" "+address;
        }
    }
}
