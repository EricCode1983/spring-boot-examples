package com.example.basic.thread;


import java.util.concurrent.Callable;

//用callable 来获得线程返回值
public class MyCallable implements Callable<String> {


    @Override
    public String call() throws Exception {
        String value="test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
