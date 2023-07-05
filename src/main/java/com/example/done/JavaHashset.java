/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-hashset/problem?isFullScreen=true
 */
public class JavaHashset {
    public static void main(String[] args) {
    Scanner a= new Scanner(System.in);
    int b= a.nextInt();

   HashSet<String> hs = new HashSet<String>();
   for(int i=0; i<b; i++){
       String c= a.next();
       String d= a.next();

       hs.add(c + " " + d);

       System.out.println(hs.size());

   }
}
}
