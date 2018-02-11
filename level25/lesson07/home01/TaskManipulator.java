package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    //
    private String _threadName;
    //
    Thread t;
    //
    @Override
    public void run() {
        try
        {

            while (!t.isInterrupted())
            {
                Thread.sleep(0);
                System.out.println(_threadName);
                t.sleep(90);
            }
        }
        catch (InterruptedException e)
        {

        }
    }

    @Override
    public void start(String threadName) {
        // TODO Auto-generated method stub
        _threadName = threadName;
        t = new Thread(this);
        t.start();

    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        t.interrupt();

    }
}
