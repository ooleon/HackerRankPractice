package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;


public class MyPintor implements Schedule {

    public static void main(String[] args) {
        Schedule p = new MyPintor();
        p.wakeUp();
        MyPintor pintor = new MyPintor();

    }


}
