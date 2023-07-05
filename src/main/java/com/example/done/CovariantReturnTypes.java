/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-covariance/problem?isFullScreen=true
 * Java allows for Covariant Return Types, which means you can vary your return
 * type as long you are returning a subclass of your specified return type.
 * Method Overriding allows a subclass to override the behavior of an existing
 * superclass method and specify a return type that is some subclass of the
 * original return type. It is best practice to use the @Override annotation
 * when overriding a superclass method.
 *
 * Resources: Covariant Return Type http://c2.com/cgi/wiki?CovariantReturnTypes
 * Java Covariant Type
 * https://blogs.oracle.com/sundararajan/entry/covariant_return_types_in_java
 *
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Complete the classes below
abstract class Flower {

//    abstract String whatsYourName();
    String whatsYourName() {
        return this.getClass().getSimpleName();
    }
}

class Jasmine extends Flower {

    public Jasmine() {
    }

    Jasmine yourNationalFlower() {
        return new Jasmine();
    }

    String JasmineSito() {
        return "JasmineSito";
    }
}

class Lily extends Flower {

    public Lily() {
    }

    Lily yourNationalFlower() {
        return new Lily();
    }
}

abstract class Region {

    abstract Flower yourNationalFlower();
}

class WestBengal extends Region {

    WestBengal() {
    }

    @Override
    Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class AndhraPradesh extends Region {

    AndhraPradesh() {
    }

    @Override
    Lily yourNationalFlower() {
        return new Lily();
    }
}

public class CovariantReturnTypes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
        if (flower instanceof Jasmine) {
            System.out.println(((Jasmine) flower).JasmineSito());

        }
    }
}
