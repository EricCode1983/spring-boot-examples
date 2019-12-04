package com.example.basic.aop;

public class RealPayment implements Payment {

    @Override
    public void pay() {
       System.out.println("只关心支付功能");
    }
}
