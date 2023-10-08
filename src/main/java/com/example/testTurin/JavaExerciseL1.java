package com.example.testTurin;

import java.lang.reflect.Array;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;

public class JavaExerciseL1 {
	int i = 10;

	private static void init() {
		
	}

//1	What function could be used to slashes for dashes in a list of dates?
	private static void utilFunction_1() {
		List<String> dates = new ArrayList<String>();

//		Consumer<Date> replaceSlashes_1 = date -> date.replace("/", "-");
//		The method replace(String, String) is undefined for the type Date

//		Function<String, String> replaceSlashes_2 = date -> date.replace("/", "-");
//		(UnaryOperator<String>) replaceSlashes; Function can be cast to UnaryOperator

//		Map<String, String> replaceSlashes_3 = dates.replace("/", "-");
//		The method replace(String, String) is undefined for the type List<String>

		UnaryOperator<String> replaceSlashes_4 = date -> date.replace("/", "-");
		var replaceSlashes = replaceSlashes_4;
		dates.replaceAll(replaceSlashes);
	}

//2	Which is the correct return type for the processFunction method?
	static String processFuction(Integer number, Function<Integer, String> lambda) {
		return lambda.apply(number);
	}

	private static void processFuction_2() {
		String string = processFuction(2, null);
	}

//3	What variable type should be declared for capitalize?
	private static void p_3() {

		List<String> songTitles = Arrays.asList("humble", "element", "dna");
		Function<String, String> capitalize = str -> str.toUpperCase();
		songTitles.stream().map(capitalize).forEach(System.out::println);

//		 Map<String,String> 
//		 Stream<String,String> 
//		 Function<String,String>
//		 Stream<String>
	}

//4	Which OOP concept is this code an example of?
	private static void p_4() {
		List[] myList = {
			new ArrayList<>(),
			new LinkedList<>(),
			new Stack<>(),
			new Vector<>()
		};
	
		for (List list : myList) {
			list.clear();
		}
//		composition.
//		encapsulation.
//		generics.
//		polymorphism.
		
	}

	private static void p_5() {
	}

	private static void p_6() {
	}

	private static void p_7() {
	}

	private static void p_8() {
	}

	private static void p_9() {
	}

	private static void p_10() {
	}

	private static void p_11() {
	}

	private static void p_12() {
	}

	private static void p_13() {
	}

	private static void p_14() {
	}

	private static void p_15() {
	}

	private static void method(JavaExerciseL1 javaThread) {
		javaThread.i = 2;
	}

	public static void main(String[] args) {
		JavaExerciseL1 jt = new JavaExerciseL1();
		method(jt);
		System.out.println(jt.i);

		System.out.println("inicio");
		try {
			listRemove();
			System.out.println("fin");

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	private static void listRemove() throws ConcurrentModificationException {
		List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));
		for (String value : list) {
//            if (value.equals("b")) list.remove(value);
			System.out.println(value);
			String s = "b";
			list.remove(s);
			System.out.println(value);
		}
		System.out.println("paso");
		System.out.println(list.size());

	}

	private static void file() throws Exception {
		String s = "Medium level test";
		byte[] b = s.getBytes();
		FileOutputStream fos = new FileOutputStream("myFile.txt");
		OutputStream os = new ObjectOutputStream(fos);
		os.write(b);
		os.flush();
		os.close();
	}

}