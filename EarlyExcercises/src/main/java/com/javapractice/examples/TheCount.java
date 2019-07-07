package com.javapractice.examples;

import java.util.Scanner;

public class TheCount {
	/*
	 * I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! *** Start at : 3 Stop
	 * at : 35 Count by : 7 3 10 17 - Ah ah ah! 24 31
	 */
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Enter starting point");
		int start = inputReader.nextInt();
		System.out.println("Enter stoping point");
		int stop = inputReader.nextInt();
		System.out.println("Enter count point");
		int count = inputReader.nextInt();
		int counter = 0;
		for (int i = start; i < stop; i = i + count) {
			counter++;
			if (counter <= 3) {
				System.out.println(i);
				if(counter == 3){
					System.out.println("Ah ah ah");	
				}
			} else {
				System.out.println(i);
			}
		}
	}
}
