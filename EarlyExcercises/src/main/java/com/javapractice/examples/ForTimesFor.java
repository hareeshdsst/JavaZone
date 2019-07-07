package com.javapractice.examples;

import java.util.Scanner;

public class ForTimesFor {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int numberToBeMultipled = sc.nextInt();
		int counter = 0;
		for (int i = 1; i < 16; i++) {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String stringMultiplication = "";
			System.out.println(i + " * " + numberToBeMultipled + " : " + stringMultiplication);
			stringMultiplication = scanner.nextLine();
			int integerMultiplication = Integer.parseInt(stringMultiplication);
			if (integerMultiplication == i * numberToBeMultipled){
				counter ++;
				System.out.println("Correct! ");
			} else {
				System.out.println("Sorry answer is " + i + " * " + numberToBeMultipled + " : " + i * numberToBeMultipled);
			}
		}
		System.out.println("You got " + counter + " answers");
		if(counter <= 7 ){
			System.out.println("Study more guys");
		} else {
			System.out.println("Congratulations you scored more than 50%");
		}
	}
}
