package com.example.basic.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//用线程池来获取线程返回值
public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException {

        ExecutorService newCacheThreadPool= Executors.newCachedThreadPool();
        Future<String> future=newCacheThreadPool.submit(new MyCallable());

        if(!future.isDone()){
            System.out.println("task has not finished, please wait!");
        }

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            newCacheThreadPool.shutdown();
        }

    }
}
