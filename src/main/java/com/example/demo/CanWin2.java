package com.example.demo;

import java.util.*;

public class CanWin2 {

    public static boolean canWin(int leap, int[] game, int i, boolean[] check) {
        // Return true if you can win the game; otherwise, return false.
        if ((i + leap) >= game.length){
            return true;
        } else if (game[i+leap] == 0) {
            return canWin(leap, game, i+leap, check);
        } else if (i-1 >= 0 && game[i-1] == 0 && check[i-1]) {
            if (game[i-1+leap] != 0) {
                check[i-1] = false;
            }
            return canWin(leap, game, i-1, check);
        } else if (game[i+1] == 0) {
            return canWin(leap, game, i+1, check);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            boolean check [] = new boolean [game.length];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
                check[i] = true;
            }

            System.out.println( (canWin(leap, game, 0, check)) ? "YES" : "NO" );
        }
        scan.close();
    }
}