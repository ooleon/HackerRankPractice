package com.example.testTurin;

import java.lang.reflect.Array;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;

public class JavaCertTest01 {
	static char c;
	public static void main(String[] args) {
		System.out.println();
		for (c = 0; c < 600; c++ ){
			System.out.print(c + "  ") ;
			if (c % 20 == 0){
						System.out.println(" <-");
						// System.out.println();

			}
}
		System.out.println();
		System.out.println("->fin");

		System.out.println((int) '¶');
	}
}