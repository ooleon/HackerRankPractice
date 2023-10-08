package com.example.done.VistorPattern5;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.*;

// import com.example.done.VistorPattern.JavaVistorPattern;



public class JavaVistorPattern_bkTest {

	String data;

	@BeforeEach
	void setUpBeforeEach() {
	}

	@AfterEach
	void setUpAfterEach() {
		System.setIn(System.in);
	}

//	@Test
	void mainDataTest() throws IOException {
		data = "5\n"
				+ "4 7 2 5 12\n"
				+ "0 1 0 0 1\n"
				+ "1 2\n"
				+ "1 3\n"
				+ "3 4\n"
				+ "3 5\n"
				;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		JavaVistorPattern_bk.main(null);
	}

	@Test
	void bkMainPathTest() throws IOException, URISyntaxException {
		URL resource = getClass().getClassLoader().getResource("vp_1000_test3.txt");
		if (resource == null) {
			throw new IllegalArgumentException("file not found!");
		} else {

			File file = new File(resource.toURI());
			FileInputStream fileIS = new FileInputStream(file);
			System.setIn(new ByteArrayInputStream( fileIS.readAllBytes()));
			JavaVistorPattern_bk.main(null);
		}
	}

//	@Test
	void mainByteArrayTest() throws IOException {
		String sfile = "/opt/ws/hackerrankpractice/src/test/java/com/example/done/VistorPattern1/vp_1000_test1.txt";


		File file = new File(sfile);
		byte[] bytes = new byte[(int) file.length()];

		try (FileInputStream fis = new FileInputStream(file)){
		fis.read(bytes);
		}
		
		System.setIn(new ByteArrayInputStream(bytes ));
		JavaVistorPattern_bk.main(null);
	}

}
