package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/



public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        // Два дедушки, две бабушки, отец, мать, трое детей.
        Human gFather_1 = new Human("Коля", true, 80,null,null);
        Human gFather_2 = new Human("Толя", true, 85,null,null);
        //
        Human gMother_1 = new Human("Таня", false, 80,null,null);
        Human gMother_2 = new Human("Валя", false, 85,null,null);
        //

        Human father = new Human("Саша", true, 40,gFather_1,gMother_1);
        Human mother = new Human("Оля", false, 40,gFather_2,gMother_2);
        //
        Human child_1 = new Human("Саша", true, 10,father,mother);
        Human child_2 = new Human("Катя", false, 8,father,mother);
        Human child_3 = new Human("Аша", false, 4,father,mother);
        //
        System.out.println(gFather_1);
        System.out.println(gFather_2);
        System.out.println(gMother_1);
        System.out.println(gMother_2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child_1);
        System.out.println(child_2);
        System.out.println(child_3);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        int age;
        Human father;
        Human mother;
        boolean sex;
        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
