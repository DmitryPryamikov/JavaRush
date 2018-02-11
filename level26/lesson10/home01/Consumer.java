package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    protected BlockingQueue<String> queue;
    //
    public Consumer(BlockingQueue<String> queue)
    {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println( queue.poll());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }

    }


}

