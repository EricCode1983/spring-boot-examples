package com.example.basic.thread;

import oracle.jvm.hotspot.jfr.ThreadStates;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> task=new FutureTask<String>(new MyCallable());
        Thread thread= new Thread(task);
        thread.start();
        if(!task.isDone()){
            System.out.println("task has not finished, please wait");
        }
        System.out.println("task  return :"+ task.get());


    }
}
