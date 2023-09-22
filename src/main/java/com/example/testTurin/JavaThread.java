package com.example.testTurin;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;

public class JavaThread {
    public static void main(String[] args) {
        System.out.println("inicio");
        try {
            String s = "Medium level test";
            byte[] b = s.getBytes();
            FileOutputStream fos = new FileOutputStream("myFile.txt");
            OutputStream os = new ObjectOutputStream(fos);
            os.write(b);
            os.flush();
            os.close();
        System.out.println("fin");

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}