/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword/problem?isFullScreen=true
 * 
 */


import java.util.*;
import java.io.*;


class BiCycle{
    String define_me(){
        return "a vehicle with pedals.";
    }
}

class MotorCycle extends BiCycle{
    String define_me(){
        return "a cycle with an engine.";
    }
    
    MotorCycle(){
        System.out.println("Hello I am a motorcycle, I am "+ define_me());
        BiCycle b1 = new BiCycle();

        String temp=b1.define_me(); //Fix this line

        System.out.println("My ancestor is a cycle who is "+ temp );
    }
    
}
class Java_MethodOverriding2_SuperKeyword{
    public static void main(String []args){
        MotorCycle M=new MotorCycle();
    }
}


