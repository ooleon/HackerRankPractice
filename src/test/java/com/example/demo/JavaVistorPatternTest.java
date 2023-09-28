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
		data = "5\n"	// number of nodes in the tree
				+ "4 7 2 5 12\n"	//values of nodes
				+ "0 1 0 0 1\n"		// color of nodes	0 denotes red and 1 denotes green
				+ "1 2\n"
				+ "1 3\n"
				+ "3 4\n"
				+ "3 5\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		JavaVistorPattern.main(null);
		System.out.println("fin");
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
