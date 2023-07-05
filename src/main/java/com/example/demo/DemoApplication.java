package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("leer n:");
        int n = scan.nextInt();
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = scan.next();
        }

        scan.close();

        Arrays.sort(s, Collections.reverseOrder(Comparator.comparing(BigDecimal::new)));

        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }

    }

}
