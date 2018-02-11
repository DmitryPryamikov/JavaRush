package com.javarush.test.level21.lesson16.big01;

/**
 * Created by DimaMarina on 09.08.2016.
 */
public class Horse
{
    public void setName(String name)
    {
        this.name = name;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public String getName()
    {

        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    /*Задание 5
    Закончим написание класса "лошадь"
    Добавь конструктор с параметрами (name, speed, distance).
    Добавь getter'ы и setter'ы для всех полей класса Horse.
    Делай все методы public, если явно не указано обратное.*/
    String name;
    double speed, distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    //
    public void move()
    {
        distance+=speed*Math.random();
    }
    public void print(){
        for (int i =0; i < (int)distance;i++)
        {
            System.out.print(".");
        }
        System.out.print(getName());
        System.out.println();
    }
}
