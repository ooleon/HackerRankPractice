/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.math.*;

/**
 *
 * @author leo
 */
public class JavaInterface {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        bufferedReader.close();
        int n = Integer.valueOf(s).intValue();

        MyCalculator mc = new MyCalculator();
        System.out.println("I implemented: " + mc.getClass().getInterfaces()[0].getName());

        System.out.println(mc.divisorSum(n));
    }

}

class MyCalculator implements AdvancedArithmetic {

    ArrayList<Integer> divisors = new ArrayList<Integer>();

    @Override
    public int divisorSum(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        Stream<Integer> s = divisors.stream();
        

        return s.mapToInt(Integer::intValue).sum();
    }
}

interface AdvancedArithmetic {

    int divisorSum(int n);
}
