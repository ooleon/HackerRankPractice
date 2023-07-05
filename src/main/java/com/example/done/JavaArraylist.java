/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leo
 */
public class JavaArraylist {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<List<Integer>> listOfArray = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int d = s.nextInt();
            List<Integer> listd = new ArrayList<Integer>();
            for (int j = 0; j < d; j++) {
                listd.add(s.nextInt());
            }
            listOfArray.add(listd);
        }
        // System.out.println(listOfArray);
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            try {
                System.out.println(listOfArray.get(x - 1).get(y - 1));
            } catch (Exception ex) {
                System.out.println("ERROR!");
            }
        }
        s.close();

    }

}
