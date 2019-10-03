package com.example.basic.thread;

public class MyThreadDemo {

    public static void main(String[] args) {

        MyThread t1=new MyThread("thread 1");
        MyThread t2=new MyThread("thread 2");
        MyThread t3=new MyThread("thread 2");

        t1.start();
        t2.start();
        t3.start();

    }
}
