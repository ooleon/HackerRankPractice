package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Scanner;

//import org.springframework.util.DigestUtils;
//import org.apache.commons.codec.digest.DigestUtils;

public class JavaSHA256 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner scan;
		scan = new Scanner(System.in);

		String originalString = scan.next();

		scan.close();
		
//		Apache Commons
//		String sha256hex = DigestUtils.sha256Hex(originalString);

//		Java Pure
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(
		  originalString.getBytes(StandardCharsets.UTF_8));
		

		System.out.println(bytesToHex(encodedhash));
	}

	@Deprecated
	private static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
