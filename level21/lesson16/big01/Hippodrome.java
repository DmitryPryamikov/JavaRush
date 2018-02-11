package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by DimaMarina on 09.08.2016.
 */
/*Задание 3
Раз это ипподром, то на нем должны быть лошади.
А, значит наш ипподром должен хранить список всех его лошадей.
Добавь переменную horses типа ArrayList<Horse> в класс Hippodrome.
Добавь getter для этого поля.*/
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;
    public static void main(String[] args) throws InterruptedException
    {
        //
        game = new Hippodrome();
        //
        Horse hOne = new Horse("Zefir",3.0,0);
        Horse hTwo = new Horse("Frost", 3.0,0);
        Horse hThree = new Horse("Zamba", 3.0,0);
        //
        game.getHorses().add(hOne);
        game.getHorses().add(hTwo);
        game.getHorses().add(hThree);
        //
        game.run();
        game.printWinner();

    }
    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
    //
    public void run() throws InterruptedException
    {
        for (int i =0; i< 100;i++)
        {
            move();
            print();
            Thread.sleep(200);

        }
    }
    public void move()
    {
        for (Horse h : horses)
        {
            h.move();
        }
    }
    public void print()
    {
        for (Horse h : horses)
        {
            h.print();
            System.out.println();
            System.out.println();
        }
    }
    public Horse getWinner()
    {
        double maxDistance=0;
        Horse winner = null;
        for (Horse h : horses)
        {
            if (h.getDistance()>maxDistance)
            {
                winner = h;
            }
        }
        return  winner;
    }
    public void printWinner()
    {
        System.out.println("Winner is "+getWinner().getName()+"!");
    }


}
