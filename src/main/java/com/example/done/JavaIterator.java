/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

/**
 *
 * @author leo
 * https://www.hackerrank.com/challenges/java-iterator/problem?isFullScreen=true

       Logica engañosa
 */

import java.util.*;
public class JavaIterator{
	
   static Iterator func(ArrayList mylist){
      Iterator it=mylist.iterator();
      while(it.hasNext()){
         Object element = it.next();
         if (!(element instanceof Integer )) 
                  
			break;
		}
      return it;
      
   }
   @SuppressWarnings({ "unchecked" })
   public static void main(String []args){
      ArrayList mylist = new ArrayList();
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      for(int i = 0;i<n;i++){
         mylist.add(sc.nextInt());
      }
      
      mylist.add("###");
      for(int i=0;i<m;i++){
         mylist.add(sc.next());
      }
      
      Iterator it=func(mylist);
      while(it.hasNext()){
         Object element = it.next();
         System.out.println((String)element);
      }
   }
}