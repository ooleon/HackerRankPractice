/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-sort/problem?isFullScreen=true
 * 
 */
class Student2 {

    private int id;
    private String fname;
    private double cgpa;

    public Student2(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}


public class JavaSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student2> studentList = new ArrayList<Student2>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student2 st = new Student2(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(new Comparator<Student2>() {
            @Override
            public int compare(Student2 s1, Student2 s2) {
                if (s1.getCgpa() == s2.getCgpa()) {
                    if (s1.getFname() == s2.getFname()) {
                        return String.valueOf(s1.getId()).compareTo(String.valueOf(s2.getId()));
                    } else {
                        return s1.getFname().compareTo(s2.getFname());
                    }
                } else if (s1.getCgpa() < s2.getCgpa()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (Student2 st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
