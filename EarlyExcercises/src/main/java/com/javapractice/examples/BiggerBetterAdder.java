package com.javapractice.examples;

import java.util.Scanner;

public class BiggerBetterAdder {
	public static void main(String[] args) {
		int number1;
		int number2;
		int number3;
		int sum = 0;
		
		Scanner inputReader = new Scanner(System.in);
		
		System.out.println("Enter First number: ");
		number1 = inputReader.nextInt();

		System.out.println("Enter Second number: ");
		number2 = inputReader.nextInt();
		
		System.out.println("Enter Third number: ");
		number3 = inputReader.nextInt();
		
		sum = number1 + number2 + number3;
		
		System.out.println("Sum of 3 numbers is : " + sum);

	}
}
