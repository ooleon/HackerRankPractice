/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-singleton/problem?isFullScreen=true
 *
 */
public class Singleton {

    public static  Singleton INSTANCE;
    public String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        Singleton temp;
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        } 
        return INSTANCE;

    }

    public static void main(String[] args) {

        Singleton instancia = getSingleInstance();
        instancia.str="nuevo";
        System.out.println(instancia.str);
        Singleton s2 = getSingleInstance();
        System.out.println(s2.str);
    }

}
