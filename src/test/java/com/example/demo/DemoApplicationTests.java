package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        Integer[] i = {42, 8, 1, 34, 6, 407, 25, 57, 67, 77, 87, 97, 107, 99, 307, 27, 17, 47, 37, 7, 48, 3, 2, 62};
        List l = Arrays.asList(i);
        ArrayList<Integer> al = new ArrayList<Integer>(l);
        System.out.println(al);

        al.sort((Integer o1, Integer o2) -> {
            if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        });
        System.out.println(al);
        Set<Integer> s = new HashSet<>();
        al.forEach((t) -> {
            BigInteger bi;
            bi = BigInteger.valueOf((long) t);
            if (bi.isProbablePrime(1)) {
                System.out.print(t + " ");
                s.add(t);
            }
        });
        System.out.println();
        System.out.println(al);
        al.removeAll(s);
        System.out.println(al);

//        Arrays.sort(al, Collections.reverseOrder(Comparator<Integer>.comparing(Integer::new)));
//

        al.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(al);

        Stream<Integer> st = al.stream();
        st.sorted((o1, o2) -> {
            if (o1 < o2) {
                return 1;
            } else {
                return -1;
            }

        });
        System.out.println(st);
        st.close();

        
    }

}
