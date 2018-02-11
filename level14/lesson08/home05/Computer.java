package com.javarush.test.level14.lesson08.home05;

/**
 * Created by DimaMarina on 15.05.2016.
 */
public class Computer
{
    private Keyboard m_Keyboard;
    private Mouse m_Mouse;
    private Monitor m_Monitor;

    public Computer()
    {
        this.m_Keyboard = new Keyboard();
        this.m_Mouse = new Mouse();
        this.m_Monitor = new Monitor();
    }

    public Keyboard getKeyboard()
    {
        return m_Keyboard;
    }

    public Mouse getMouse()
    {
        return m_Mouse;
    }

    public Monitor getMonitor()
    {

        return m_Monitor;
    }
}
