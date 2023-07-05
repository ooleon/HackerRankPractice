/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.util.*;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-comparator/problem?isFullScreen=true
 *
 */
// Write your Checker class here
class Checker implements Comparator {

    Checker() {
    }

    @Override
    public int compare(Object o1, Object o2) throws UnsupportedOperationException {
        Player p1 = (Player) o1;
        Player p2 = (Player) o2;
        if (p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        } else if (p1.score < p2.score) {
            return 1;
        } else {
            return -1;
        }
    }

}

/*
//        if (p1.name.compareTo(p2.name)) {
        if (p1.name == p2.name) {
            if (p1.score < p2.score) {
                return 1;
            } else {
                return -1;
            }
//String.valueOf(s1.getId()).compareTo(String.valueOf(s2.getId()));
        } else {
            return p1.name.compareTo(p2.name);
        }
    }
 */
class Player {

    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class JavaComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
