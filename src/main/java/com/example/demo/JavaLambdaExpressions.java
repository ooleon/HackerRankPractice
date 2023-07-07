package com.example.demo;

/**
 *
 * @author leo
 *         https://www.hackerrank.com/challenges/java-lambda-expressions/problem?isFullScreen=true
 *         https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * 
 */

public class JavaLambdaExpressions {

	public static void main(String[] args) {
		JavaLambdaExpressions j = new JavaLambdaExpressions();

	}

	boolean isOdd(int numero) {
		return false;
	}

	boolean isPrime(int numero) {
		return false;
	}

	boolean isPalindrome(int numero) {
		return false;
	}

	boolean f1(CheckPerson p) {
		boolean b1 = false;
		return p.test("");
	}

	interface CheckPerson {
		boolean test(String p);
	}

}
