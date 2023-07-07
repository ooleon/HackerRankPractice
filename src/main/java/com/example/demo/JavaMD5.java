package com.example.demo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaMD5 {

	static String s;

	public JavaMD5() {
		Scanner scan;
		scan = new Scanner(System.in);

		s = scan.next();

		scan.close();
	}

	// hash function to get the md5 hash
	public static String getMd5Hash(String input) {

		try {
			// static getInstance() method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// calculating message digest of an input that return array of byte
			byte[] messageDigest = md.digest(input.getBytes());
			// converting byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);
			// converting message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}
		// for specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {

		JavaMD5 j = new JavaMD5();
		//HelloWorld		68e109f0f40ca72a15e05cc22786f8e6

		System.out.println(getMd5Hash(s));

	}

}
