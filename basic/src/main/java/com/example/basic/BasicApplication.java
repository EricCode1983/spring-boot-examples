package com.example.basic;

import com.example.basic.entity.Animal;
import com.example.basic.entity.Cat;
import com.example.basic.entity.Person;
import com.example.basic.entity.Pet2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {

     ApplicationContext ctx= SpringApplication.run(BasicApplication.class, args);
     Person person=ctx.getBean(Person.class);
     System.out.println("Name is "+ person.getName());
     person.call();
    }

}
