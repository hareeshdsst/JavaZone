package com.javapractice.examples;

import java.util.Scanner;

public class DoItBetter {
	public static void main(String[] args) {

		int miles = 0;
		int hotDogs = 0;
		int languages = 0;
		Scanner inputReader = new Scanner(System.in);

		System.out.println("Number of miles ran: ");
		miles = inputReader.nextInt();

		System.out.println("Number of Hotdogs ate: ");
		hotDogs = inputReader.nextInt();

		System.out.println("Number of languages know: ");
		languages = inputReader.nextInt();
		
        int moreMiles = miles * 2 + 1;  
        int moreHotDogs = hotDogs * 2 + 1;  
        int moreLanguages = languages * 2 + 1;  
        
		System.out.println("You can do more: ");

		System.out.println("Number of miles ran: " + moreMiles);

		System.out.println("Number of Hotdogs ate: " + moreHotDogs);
		
		System.out.println("Number of languages know: " + moreLanguages);

	}
}
