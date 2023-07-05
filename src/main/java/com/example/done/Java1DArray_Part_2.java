/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author leo
 */
public class Java1DArray_Part_2 {

    static InputStream stdin = System.in;
    static Scanner scanner;
    static String data = "5\n"
            + "6 2\n"
            + "0 0 0 1 1 0 1\n"
            + "5 3\n"
            + "0 0 0 0 0\n"
            + "6 5\n"
            + "0 0 0 1 1 1\n"
            + "6 3\n"
            + "0 0 1 1 1 0\n"
            + "3 1\n"
            + "0 1 0\n"
            
            ;

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr < 0 || game[curr] == 1) continue;
            if (curr + leap >= game.length || curr + 1 >= game.length) return true;
            game[curr] = 1;
            queue.add(curr - 1);
            queue.add(curr + 1);
            queue.add(curr + leap);
        }
        return false;
   
      }

    public static void main(String[] args) {
        //entrada();
        Scanner scan = new Scanner(System.in);
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            scan = new Scanner(System.in);

            int q = scan.nextInt();
            while (q-- > 0) {
                int n = scan.nextInt();
                int leap = scan.nextInt();

                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }

                System.out.println((canWin(leap, game)) ? "YES" : "NO");
            }
        } finally {
            System.setIn(stdin);
        }

        scan.close();

    }

    private static void entrada() {

        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());
            /*
            System.setIn(new ByteArrayInputStream("0 0 1 1 1".getBytes()));
            scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());

            System.setIn(new ByteArrayInputStream("asdf \n qwer".getBytes()));
            scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
             */
        } finally {
            System.setIn(stdin);
        }
        //scanner.close();
    }
}
