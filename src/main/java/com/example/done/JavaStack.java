/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.util.*;

/**
 *
 * @author leo
 * Brackets in Balance 
 * https://www.hackerrank.com/challenges/java-stack/problem?isFullScreen=true
 *
 */
public class JavaStack {

    public static void main(String[] argh) {
         String s = "{}({()()()()}{{}}{})";
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
		String input=sc.next();
                System.out.println(
				isBoolean(validar(input))
				);
		}
    }

    static boolean validar(String s) {
        Stack st = new Stack();

        if (s.isEmpty()) {
            return true;
        }
        for (Character c : s.toCharArray()) {
            if ("({(".contains(c.toString())) {
                st.push(c);
            }
            if (st.empty() && ")})".contains(c.toString())) {
                return false;
            }
            if (")})".contains(c.toString())) {
                st.pop();
            }
        }
        if (st.empty()) {
            return true;
        }
        if (!st.empty()) {
            return false;
        }
        return false;
    }

    static String isBoolean(boolean s){
	Boolean b = new Boolean(s);
	return b.toString();
    }
}
