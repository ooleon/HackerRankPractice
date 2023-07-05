/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;
import java.util.Scanner;


/**
 *
 * @author leo
       https://www.hackerrank.com/challenges/java-exception-handling/problem?isFullScreen=true
 */

class TheCalculator {

    Integer power(int n, int p) throws Exception {

        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");            
        }

        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");            
        }
        
        int _power = 1; 
        
        for (int i = 0; i <= p - 1; i++) {
            System.out.println("i" + i + " n" + n + " p " + p + " _power " + _power);
            _power = _power * n;
        }
        
        return _power;
    }
    /*
    * Create the method long power(int, int) here.
    */
    
}

public class JavaExceptionHandling {
    public static final TheCalculator theCalculator = new TheCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            
            try {
                System.out.println(theCalculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}