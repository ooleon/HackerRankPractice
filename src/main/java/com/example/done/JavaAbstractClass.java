/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author leo
 */
public class JavaAbstractClass {

    public static void main(String[] args)  throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        bufferedReader.close();

        MyBook mb = new MyBook();
        mb.setTitle(s);

        System.out.println("The title is: " + mb.getTitle());
    }
}

abstract class Book {

    String title;

    abstract void setTitle(String s);

    String getTitle() {
        return title;
    }
}

class MyBook extends Book {

    void setTitle(String s) {
        this.title = s;
    }
}
