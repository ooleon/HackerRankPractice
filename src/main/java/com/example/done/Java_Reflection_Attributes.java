/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-reflection-attributes/problem?isFullScreen=true
 * 
 */
public class Java_Reflection_Attributes {

    public static void main(String[] args) {
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();

        for (int i = 0; i < methods.length; i++) {

            methodList.add(methods[i].getName());
        }
        Collections.sort(methodList);
        for (String name : methodList) {
            System.out.println(name);
        }
    }

}

class Student {

    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void zLastMethod() {
    }

    public void someMoreMethods() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void anothermethod() {
    }

}
