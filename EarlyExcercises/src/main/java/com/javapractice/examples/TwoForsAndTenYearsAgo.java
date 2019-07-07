package com.javapractice.examples;

import java.util.Scanner;

public class TwoForsAndTenYearsAgo {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("What year would you like to count back from? ");
		int year = userInput.nextInt();

		for (int i = 0; i <= 10; i++) {
			System.out.println(i + " years ago would be " + (year - i));
		}

		System.out.println("\nI can count backwards using a different way too...");

		for (int i = year; i >= year - 10; i--) {
			//2010 2010 - 10 = 2000
			//2009 2009 - 10 = 1999
			//2008 2008 - 10 = 1998
			//2007 2007 - 10 = 1997
			//2006 
			System.out.println((year - i) + " years ago would be " + i);
		}
	}
}
