package com.example.basic.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyRunnable implements Runnable  {

    private String name;



    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("Thread start:"+this.name+",i="+i);
        }

    }


}
