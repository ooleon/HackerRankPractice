/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.ExpectedException;

/**
 *
 * @author leo
 */
public class CanYouAccessTest {

    String data;

    @BeforeEach
    void setUpBeforeEach() {
    }

    @AfterEach
    void setUpAfterEach() {
        System.setIn(System.in);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    void test_8() {
        data = "8\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        try {
            exception.expect(DoNotTerminate.ExitTrappedException.class);
            CanYouAccess.main(null);

        } catch (Exception ex) {
            Logger.getLogger(CanYouAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    void test_3() {
        data = "3\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        try {
            exception.expect(DoNotTerminate.ExitTrappedException.class);
            CanYouAccess.main(null);

        } catch (Exception ex) {
            Logger.getLogger(CanYouAccessTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
