package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
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

	// @Test
	void javaVistorPatternMainTest() throws IOException, URISyntaxException {
		URL resource = getClass().getClassLoader().getResource("vp_1000_test3.txt");
		if (resource == null) {
			throw new IllegalArgumentException("file not found!");
		} else {

			File file = new File(resource.toURI());
			FileInputStream fileIS = new FileInputStream(file);
			System.setIn(new ByteArrayInputStream(fileIS.readAllBytes()));
			JavaVistorPattern.main(null);
		}
	}

	@Test
	void mainTest() {
		data = "5\n" // number of nodes in the tree
				+ "4 7 2 5 12\n" // values of nodes
				+ "0 1 0 0 1\n" // color of nodes 0 denotes red and 1 denotes green
				+ "1 2\n" // Edge of nodes or connections inter nodes.
				+ "1 3\n"
				+ "3 4\n"
				+ "3 5\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		JavaVistorPattern.main(null);
	}

	// @Test
	void test() {
		int condition = 0;
		do {
			System.out.println(condition);
			condition++;
		} while (condition < 4);
	}

}
