package com.example.basic.thread;

public class MyRunnableDemo {

    public static void main(String[] args) {
        MyRunnable mr1=new MyRunnable("thread 1");
        MyRunnable mr2=new MyRunnable("thread 2");
        MyRunnable mr3=new MyRunnable("thread 3");


        Thread t1=new Thread(mr1);
        Thread t2=new Thread(mr2);
        Thread t3=new Thread(mr3);

        t1.start();
        t2.start();
        t3.start();


    }
}
