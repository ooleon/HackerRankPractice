/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.*;

/**
 *
 * @author leo
 */
public class JavaDequeueTest {

    String data;

    @Test
    void constructorTest_1() {
        /*
        final es constante, solo se puede definir una vez o en el constructor.
         no es posible en ningun otro metodo.
        */
        SuperShop sp = new SuperShop();
        //System.out.println(sp.n);
    }

    //    @Test
    void calendarTest_1() {
        Calendar c = Calendar.getInstance();

    }

//    @Test
    void lamdaTest_1() {
        String[] s = {"Pedro", "Maria", "Luis", "Lena"};
        List l = new ArrayList<>();
        List l1 = new ArrayList<>();
        l=Arrays.asList(s);
        List lCopy = l;
/*
        l.forEach(n -> {
            lCopy.set(lCopy.indexOf(n), lCopy.get(lCopy.indexOf(n)) + " - " + lCopy.indexOf(n));
            if (lCopy.indexOf(n) < 1){
                l1.add(n);
                System.out.println(n);
            }
        }) ;
*/
        l.forEach(n -> {
//            lCopy.set(lCopy.indexOf(n), lCopy.get(lCopy.indexOf(n)) + " - " + lCopy.indexOf(n));
//            System.out.println(lCopy.indexOf(n));
            if (lCopy.indexOf(n) < 3){
                l1.add(n);
            }
        }) ;

        System.out.println(lCopy);
        System.out.println(l1);
    }

        //    @Test
    void operadoresBinariosTest_1() {
        int i = 7, b=22;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(b));
        i|=b;
        System.out.println(i);
        i^=b;
        System.out.println(i);
        i&=b;
        System.out.println(i);
    }

    //@Test
    void test_6_3() {
        data = "6 3\n"
                + "5 3 5 2 3 2\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        JavaDequeue.main(null);
    }


//    @Test
    void test_12_2() {
        data = "12 4\n"
                + "5 3 8 5 5 5 3 3 3 2 3 2\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        JavaDequeue.main(null);
    }


    //@Test
    void test_12_3() {
        data = "12 3\n"
                + "5 3 5 2 3 2 5 3 5 2 3 2\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        JavaDequeue.main(null);
    }

    @BeforeEach
    void setUpBeforeEach() {}

    //    @AfterEach
    void setUpAfterEach() {
        System.setIn(System.in);
    }


}
