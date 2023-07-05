/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

/**
 *
 * @author leo
 */
public class JavaInheritance2 {

    public static void main(String[] args) {
        Arithmetic ari = ((Arithmetic) new Adder());
        System.out.println("My superclass is: " + ari.getClass().getName());
        System.out.println(ari.add(40, 2) + " " + ari.add(10, 3) + " " + ari.add(10, 10));
    }
}

abstract class Arithmetic {

    public abstract int add(int a, int b);
}

final class Adder extends Arithmetic {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
