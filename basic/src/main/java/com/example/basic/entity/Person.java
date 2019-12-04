package com.example.basic.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
@Data
public class Person {
    @Value("1")
    private Long id;
    @Value("Jack")
    private String name;
    @Autowired
    private Pet pet;

    @Autowired
    private Bird bird;

    public void call(){
        pet.move();
    }






}
