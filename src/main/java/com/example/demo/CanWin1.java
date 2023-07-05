package com.example.demo;

import java.util.*;

public class CanWin1 {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.


        if (leap >= game.length - 1) {
            return true;
        }

        for (int i = 0; i < game.length; i++) {
            if (i + 1 >= game.length) {
                if (game[i] == 0) {
                    return true;
                }
            }

            /*
            if (i - 1 > 0) {
                if (game[i - 1] == 0) {
                    i = i - 2;
                    continue;

                }
            }
            */

            if (i + leap >= game.length - 1) {
                return true;
            }
            if (i + leap < game.length - 1) {
                if (game[i + leap] == 0) {
                    i = i + leap - 1;
                    continue;
                }
            }

            if (i + 1 < game.length) {
                if (game[i + 1] == 0) {
                    continue;
                } else {
                    break;
                }
            } else {
                return true;
            }
        }
        return false;

  
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
