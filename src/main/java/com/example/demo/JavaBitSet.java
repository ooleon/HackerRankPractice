/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.io.*;
import java.util.*;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-bitset/problem?isFullScreen=true
 * 
 */


public class JavaBitSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        BitSet[] bitset = new BitSet[3];
        
        bitset[2] = b2;
        bitset[1] = b1;
        
        while(m-- > 0) {
            String s = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            switch(s) {
                case "AND":
                bitset[x].and(bitset[y]);
                break;
                case "OR":
                bitset[x].or(bitset[y]);
                break;
                case "XOR":
                bitset[x].xor(bitset[y]);
                break;
                case "FLIP":
                bitset[x].flip(y);
                break;
                case "SET":
                bitset[x].set(y);
            }
            
            System.out.printf("%d %d%n", b1.cardinality(), b2.cardinality());
        }
    }
}