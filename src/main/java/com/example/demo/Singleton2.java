/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author leo
 */
public class Singleton2 {

    public String str;
    private static Singleton2 INSTANCE;

    private Singleton2() {
    }

    public static Singleton2 getSingleInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (Singleton2.class) {
            if (INSTANCE != null) {
                return INSTANCE;
            }
            INSTANCE = new Singleton2();
            return INSTANCE;
        }
    }
    public static void main(String[] args) {

        Singleton2 instancia = getSingleInstance();
        instancia.str="nuevo";
        System.out.println(instancia.str);
        Singleton2 s2 = getSingleInstance();
        System.out.println(s2.str);
    }
}
