/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-priority-queue/problem?isFullScreen=true
 */
class Priorities {

    List<Student> getStudents(List<String> events) {
        List<Student> st = new ArrayList<>();
        PriorityQueue pq = new PriorityQueue();

        try {

            for (String event : events) {
                if (event.startsWith("ENTER")) {

                    pq.add(new Student(
                            Integer.parseInt(event.split("\\ ")[3]), // id
                            event.split("\\ ")[1], // name
                            Double.parseDouble(event.split("\\ ")[2]) // cgpa
                    ));
                } else {
                    pq.poll();
                    /*                    System.out.println("r-> "
                            + "id: " + ((Student) pq.peek()).id
                            + " name: " + ((Student) pq.peek()).name
                            + " cgpa: " + ((Student) pq.peek()).cgpa
                    );
                     */
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        porque es diferente?
        */

        for (Object o : pq.toArray()) {
            st.add((Student) o);
        }

        while (!pq.isEmpty()) {
            st.add((Student)pq.poll());
         }

        return st;

    }

}

class Student implements Comparable<Student> {

    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student s) {
        if (this.cgpa == s.cgpa && this.name.compareTo(s.getName())==0 ) {
            if (this.id < s.id) {
                return -1;

            } else {
                return 1;
            }
        }
        if (cgpa == s.getCgpa()) {
            return name.compareTo(s.getName());
        }

        if (this.cgpa > s.cgpa) {
            return -1;

        } else {
            return 1;
        }

    }

}

public class JavaPriorityQueue {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
