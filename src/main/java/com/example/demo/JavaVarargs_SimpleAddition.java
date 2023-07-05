/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Add{
    void add(Integer ... n) {
        Stream<Integer> streamForCalculate = Stream.of(n);
        Stream<Integer> streamForSentence = Stream.of(n);
        Integer total = streamForCalculate.reduce(0, (s1, s2) -> s1 + s2);
        String sentence = streamForSentence.map(String::valueOf).collect(Collectors.joining("+"));
        System.out.println(sentence + "=" + total);
        
    }
}

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/simple-addition-varargs/problem?isFullScreen=true
 * 
 */

public class JavaVarargs_SimpleAddition {

    public static void main(String[] args) {
       try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int n1=Integer.parseInt(br.readLine());
			int n2=Integer.parseInt(br.readLine());
			int n3=Integer.parseInt(br.readLine());
			int n4=Integer.parseInt(br.readLine());
			int n5=Integer.parseInt(br.readLine());
			int n6=Integer.parseInt(br.readLine());
			Add ob=new Add();
			ob.add(n1,n2);
			ob.add(n1,n2,n3);
			ob.add(n1,n2,n3,n4,n5);	
			ob.add(n1,n2,n3,n4,n5,n6);
			Method[] methods=Add.class.getDeclaredMethods();
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
				e.printStackTrace();
			}
		}
		
	
	

}

