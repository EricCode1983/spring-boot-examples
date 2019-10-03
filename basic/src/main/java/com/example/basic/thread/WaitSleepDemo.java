package com.example.basic.thread;

import lombok.Synchronized;

public class WaitSleepDemo {


    public static void main(String[] args) {
        final Object lock=new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread a is waitting to get lock");
                synchronized (lock) {

                    try {
                        System.out.println("thread A get lock");
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
                        lock.wait();
                        //Thread.sleep(1000);
                        System.out.println("thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread b is waiting to get lock");
                synchronized (lock) {

                    try {
                        System.out.println("thread b get lock");
                        System.out.println("thread b is sleeping 10 ms");
                        Thread.sleep(10);
                        //lock.wait(10);
                        System.out.println("thread b is done");
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
