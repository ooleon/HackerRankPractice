/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;

/**
 *
 * @author leo
 */
public class BigDecimalSortArray101Test {

    String data;

//    @BeforeEach
    void setUpBeforeEach() {
    }

//    @AfterEach
    void setUpAfterEach() {
        System.setIn(System.in);
    }

//    @Test
    void mainTest() {
        data = "9\n"
                + "-100\n"
                + "50\n"
                + "0\n"
                + "56.6\n"
                + "90\n"
                + "0.12\n"
                + ".12\n"
                + "02.34\n"
                + "000.000\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BigDecimalSortArray101.main(null);
    }

//    @Test
    void mainTest_concat() {
        System.out.println(1 + 3 + " a " + 2 * 3 + 3 * 4);
        Integer amor = -129;
        Integer roma = -129;
        System.out.println("trestristes".substring(2, 7)); // desde, hasta -1
        //  subString( int, int); no incluye al ultimo valor
        //  en el final del SubString. 
    }

//    @Test
    void mainTest_arrays() {
        int[] aint = {5, (2 + 6), 9};
        System.out.println();
    }

//    @Test
    void loopTest_100() {
//        for (int i = 1; i <= 100; i++) { for (int j = 1; j <= 100; j++) { System.out.print(j + " "); } } 
//        for (int i = 1; i <= 100; i++) { for (int j = 1; j <= i; j++) { System.out.print(j + " "); } } 
//        for (int i = 100; i >= 0; i--) { for (int j = i; j <= 100; j++) { System.out.print(j + " "); } } 
        for (int i = 1; i <= 100; i++) { for (int j = 1; j <= i; j++) { System.out.print(i + " "); break; } } 
    }

//    @Test
    void dateTimeTest_1() {
    }

    @Test
    void hashTest_1() {
        System.out.println(Integer.toBinaryString(13 & 0xff));
        String s = "b";
        StringBuilder b = new StringBuilder("a");
        StringBuilder c = new StringBuilder("a");
//        s="a";
        s=b.toString();
        String l = "a";
        System.out.println(s.hashCode());
        System.out.println(l.hashCode());
        System.out.println(s == l);
        
        
    }
        
        
    
//    @Test
    void arraysTest_1() {
        int[] i = {123, 2, 22};
        Double[] d = {0.0__0,.1,3___3.00,5___6.1,800D,.0,};
        Float[] f = {};
        String[] s = {};
        Character[] c = {};
        System.out.println(d.length);

        List<Double> l = new ArrayList<>();
        l.add(30.0);
        l.add(10.0);
        l.remove(new Double(30));
        System.out.println(l);
    }
//    @Test
    void stringPoolTest_1() {
        String a = "Hola";
        StringBuilder s = new StringBuilder(a);
        String b = "Hola";
/* JDK 17
        String t = """
                   """  + a + """
                                  """;
        System.out.print(t);
        System.out.println(a == t);
        System.out.println(t);
*/
        System.out.println(a == b);
        System.out.print(a == s.toString());
        System.out.print(a == "Hola");

    }
    
//    @Test
    void stringBuilderTest_1() {
        StringBuilder s = new StringBuilder("sadf");
        s=s.insert(1, " aaa ");
        s=s.replace(0, s.length(), "b");
        System.out.println(s);
    }

//        @Test
    void corridoTest_1() {
        int b = -14;
        int r = 2;
        
        System.out.println(Integer.toBinaryString(b));
        System.out.println(b >> r);
        System.out.println(Integer.toBinaryString(b >> r));
        System.out.println(b >>> r);
        System.out.println(Integer.toBinaryString(b >>> r));
    }

//    @Test
    void binaryTest_18() {
        int b18 = 18;
        int b16 = 16;
        int b2 = 2;

        System.out.println("|");
        System.out.println(Integer.parseInt("10010", 2));
        System.out.println(Integer.toBinaryString(b18));
        System.out.println("16: " + Integer.toBinaryString(16));
        System.out.println("2:  000" + Integer.toBinaryString(2));
        System.out.println(b16 | b2);

        System.out.println();

        System.out.println("&");
        System.out.println(Integer.parseInt("11011", 2));
        System.out.println(Integer.parseInt("10110", 2));
        System.out.println(27 & 22);
        System.out.println("27 en binario es: " + Integer.toBinaryString(27));
        System.out.println("22 en binario es: " + Integer.toBinaryString(22));

        System.out.println();

        System.out.println("^"); //XOR, OR Exclusiva, OR Excluyente
        System.out.println(27 ^ 22);
        System.out.println(227 ^ 222 | 82 ^ 41);   //1110 0011 ^ 1101 1110 | 0101 0010 ^ 0010 1001 

        System.out.println();
        System.out.println(Integer.parseInt("11100011", 2));
        System.out.println(Integer.parseInt("11011110", 2));
        System.out.println(Integer.parseInt("01010010", 2));
        System.out.println(Integer.parseInt("00101001", 2));

    }

}
