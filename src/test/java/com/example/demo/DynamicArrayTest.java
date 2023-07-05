/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.*;

/**
 *
 * @author leo
 */
public class DynamicArrayTest {

    String data;

    @BeforeEach
    void setUpBeforeEach() {
    }

    @AfterEach
    void setUpAfterEach() {
        System.setIn(System.in);
    }

    @Test
    void test_2_5() {
        data = "2 5\n"
                + "1 0 5\n"
                + "1 1 7\n"
                + "1 0 3\n"
                + "2 1 0\n"
                + "2 1 1\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        try {
            DynamicArray.main(null);
        } catch (IOException ex) {
            Logger.getLogger(DynamicArrayTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
