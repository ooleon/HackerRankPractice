package com.example.demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author leo
 *         https://www.hackerrank.com/challenges/java-lambda-expressions/problem?isFullScreen=true
 *         https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * 
 */

public class JavaLambdaExpressions {
	void getArr() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		System.out.println(" arr " + arr.length);
	}

	Scanner scan;
	String[][] arr;

	public JavaLambdaExpressions() {
		scan = new Scanner(System.in);

		// System.out.print("leer n: ");
		int n = scan.nextInt();
		System.out.println();

		arr = new String[n][2];

		for (int i = 0; i < n; i++) {
			// System.out.println(String.format("n[%s]: ", i));
			arr[i][0] = scan.next();
			arr[i][1] = scan.next();
		}

		scan.close();
	}

	public static void main(String[] args) {
		JavaLambdaExpressions j = new JavaLambdaExpressions();
		String result="";
		for (int i = 0; i < j.arr.length; i++) {
		    PerformOperation1 op = isOdd();
		    switch (j.arr[i][0]) {
			   case "1":
				  op = isOdd();
				  result = op.test(j.arr[i][1]) == true? "ODD" : "EVEN";
				  break;
  
			   case "2":
				  op = isPrime();
				  result = op.test(j.arr[i][1]) == true? "PRIME" : "COMPOSITE";
				  break;
  
			   case "3":
				  op = isPalindrome();
				  result = op.test(j.arr[i][1]) == true? "PALINDROME" : "";
				  break;
  
			   default:
				  op = isOdd();
				  break;
		    }
		    System.out.println(result);
  
		}
	}

	static PerformOperation1 isOdd() {
		return x -> {
			// int
			return Integer.valueOf(x) % 2 != 0;
		};
	}

	static PerformOperation1 isPrime() {
		return x -> {
			BigInteger bi = new BigInteger(x);
			return bi.isProbablePrime(1);
		};
	}

	static PerformOperation1 isPalindrome() {
		return x -> {
			return x.equals(new StringBuilder(x).reverse().toString()) ? true : false;
		};
	}
}

interface PerformOperation1 {
	boolean test(String n);
}