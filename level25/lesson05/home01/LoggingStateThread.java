package com.javarush.test.level25.lesson05.home01;

/**
 * Created by DimaMarina on 16.11.2016.
 */
public class LoggingStateThread extends Thread {
    //
    private Thread _thread;

    public LoggingStateThread (Thread t)
    {
        this._thread = t;
        setDaemon(true);

    }
    @Override
    public void run() {

        State state = this._thread.getState();
        System.out.println(state);
        while (state!=State.TERMINATED)
        {
            if (state !=this._thread.getState())
            {
                state = this._thread.getState();
                System.out.println(state);
            }
        }
    }





}
