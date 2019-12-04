package com.example.basic.thread;

import com.example.basic.entity.Bird;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;

import java.util.Optional;

public class TestDemo {

    public static void main(String[] args) {
        Bird bird=null;

        if(Optional.ofNullable(bird).isPresent()){
            System.out.println("bird is exist");
        }
        else
        {

        }

    }
}
