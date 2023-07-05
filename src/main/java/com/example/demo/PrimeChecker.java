/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

import static java.lang.System.in;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Prime{

        public void checkPrime(int ... n){
        for(int e : n){
            java.math.BigInteger i = java.math.BigInteger.valueOf(e);
            if(i.isProbablePrime(1)){
                System.out.printf("%s ",i);
            }
        }
        System.out.println();
    }
    
        /*
    void checkPrime_stream(Integer ... n) {
        
        Stream<Integer> streamForCalculate = Stream.of(n);
        Stream<Integer> streamForSentence = Stream.of(n);
        Optional<Integer> total = streamForCalculate.forEach(n)-> {
                //reduce((acumulador,numero)-> {

            return 0;
        });
        String sentence = streamForSentence.map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(sentence);
    }
    */
    
}

/**
 *
 * @author leo
 */


public class PrimeChecker {

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}

