/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.*;

/**
 *
 * @author leo
 */
public class JavaPriorityQueueTest {

    String data;

    @BeforeEach
    void setUpBeforeEach() {
    }

    @AfterEach
    void setUpAfterEach() {
        System.setIn(System.in);
    }

    @Test
    void mainTest() {
        data = "6 3\n"
                + "5 3 5 2 3 2\n";

        Priorities priorities = new Priorities();
        List<String> events = new ArrayList<>();

        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("SERVED");
        events.add("ENTER Samiha 3.85 36");
        events.add("SERVED");
        events.add("ENTER Ashley 3.9 42");
        events.add("ENTER Maria 3.6 46");
        events.add("ENTER Anik 3.95 49");
        events.add("ENTER Dan 3.95 50");
        events.add("SERVED");

        /*
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        JavaPriorityQueue.main(null);
        
        System.out.println(events.get(0).split("\\ ").length);
        System.out.println(events.get(0).split("\\ ")[0]);
        System.out.println(events.get(0).split("\\ ")[1]);
        System.out.println(events.get(0).split("\\ ")[2]);
        System.out.println(events.get(0).split("\\ ")[3]);
         */
        List<Student> students = priorities.getStudents(events);
/*        for (Student student : students) {
            System.out.println("id: " + student.id
                    + " name: " + student.name
                    + " cgpa: " + student.cgpa);
        }
*/
        for (Student st : students) {
            System.out.println(st.getName());
        }

    }

}
