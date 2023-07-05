/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author leo https://www.hackerrank.com/challenges/java-dequeue/problem
 *
 */
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

public class JavaDequeue {
    static InputStream stdin = System.in;
    static Scanner in;
    static String data = "6 3\n"
            + "5 3 5 2 3 2\n"
            
            ;

    public static void main(String[] args) {

        try {
            //System.setIn(new ByteArrayInputStream(data.getBytes()));

           in = new Scanner(System.in);
            Deque deque = new ArrayDeque<>();
            HashSet<Integer> hs = new HashSet<>();
            int n = in.nextInt();
            int m = in.nextInt();
            
            int max = 0;
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deque.add(num);
                hs.add(num);
                if(deque.size() == m){
                    if(hs.size() > max){
                        max = hs.size();
                    }
                    int removed = (int)deque.removeFirst();
                    if(!deque.contains(removed)){
                        hs.remove(removed);
                    }
                }
            }
            System.out.println(max);
            
        } finally {
            //System.setIn(stdin);
        }

        in.close();

    }
}
