package com.springboot.springbootioc;

public class ZhangSan {

    private Car car;

    public ZhangSan(Car car){
        this.car=car;
    }

    private  void GoHome(){

        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
