package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.*;

import com.example.done.VistorPattern.JavaVistorPattern;

public class JavaVistorPatternTest {

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
		data = "5\n"
				+ "4 7 2 5 12\n"
				+ "0 1 0 0 1\n"
				+ "1 2\n"
				+ "1 3\n"
				+ "3 4\n"
				+ "3 5\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		JavaVistorPattern.main(null);
		System.out.println(1);
	}

	//@Test
	void test() {
		int condition = 0;
		do {
			System.out.println(condition);
			condition++;
		} while (condition < 4);
	}

}
