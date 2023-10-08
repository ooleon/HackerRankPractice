/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author leo
 */
public class JavaMultiSum {

	public static void main(String[] args) {
		Arithmetic ari = new Arithmetic();
		System.out.println("My superclass is: " + ari.getClass().getName());
		System.out.println(ari.sum(new Integer[] { 21, 34, 324, 4 }));
		System.out.println(ari.sum(new String[] { "21", "Hola", " ", "Mundo" }));
		System.out.println(ari.sum(new Integer[] { }));
		System.out.println(ari.sum(new  String[] { }));

	}
}

class Arithmetic {

	// OverLoad
	public String sum(String[] value) {
		StringBuilder acc = new StringBuilder();

		if (value.length != 0) {
			for (String string : value) {
				acc.append(string);
			}
		}

		return acc.toString();

	}

	// OverLoad
	public Integer sum(Integer[] value) {
		Integer acc = 0;
		if (value.length != 0) {
			for (Integer integer : value) {
				acc = acc + integer;
			}
		}
		return acc;
	}

}
