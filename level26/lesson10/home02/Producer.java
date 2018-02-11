package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by DimaMarina on 12.12.2016.
 */
public class Producer implements Runnable
{
    //
    protected ConcurrentHashMap<String, String> map;
    //
    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        try {
            int i = 1;
            while (true) {
                String s=String.format("Some text for %d", i);
                map.putIfAbsent(String.valueOf(i),s);
                i++;
                //System.out.println ("Some text for "+ i );
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
