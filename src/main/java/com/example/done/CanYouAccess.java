/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done;

/**
 *
 * @author leo
 * https://www.hackerrank.com/rest/contests/master/challenges/can-you-access/hackers/ostyleon/download_solution
 */
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;

public class CanYouAccess {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
/**
 * Acceder a una sub clase privada en una clase estatica.
 */
            Inner.Private innerPrivate = new Inner().new Private();
            o = innerPrivate;
            System.out.println(num + " is " + innerPrivate.powerof2(num));

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try
        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main

    static class Inner {

        private class Private {

            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
