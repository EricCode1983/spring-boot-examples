package com.example.basic.entity;

public class Cat implements Pet2,Animal{

    @Override
    public void bark() {
        System.out.println("wang wang wang");
    }

    @Override
    public void move() {
        System.out.println("run");
    }

    @Override
    public void sleep() {
        System.out.println("sleep");
    }
}
