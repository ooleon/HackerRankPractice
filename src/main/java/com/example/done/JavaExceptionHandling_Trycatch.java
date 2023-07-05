    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;


import java.io.*;
import java.util.*;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem?isFullScreen=true
 * 
 */



public class JavaExceptionHandling_Trycatch {

    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int x;
        int y;
        
        try{
            x = input.nextInt();
            y = input.nextInt();
            float resp = x/y;
            if(resp%10==0){
                System.out.println(Math.round(resp));
            }else{
                System.out.println(y);
            }
        
        }catch(InputMismatchException e){
            System.out.println(e.getClass().toString().substring(6));
        }catch(ArithmeticException e){
            System.out.println(e);
        }
    }
}

