package com.javapractice.examples;

import java.util.Scanner;

public class MiniMadLibs {
	public static void main(String[] args) {

		String noun;
		String adj;
		String anotherNoun;
		int number;
		String stringNumber;
		String anotherAdj;
		String pluaralNoun;
		String anotherPluaralNoun;
		String oneMorePluaralNoun;
		String verbPresentTense;
		String verbPastTense;

		@SuppressWarnings("resource")
		Scanner inputReader = new Scanner(System.in);

		System.out.println("Enter a noun: ");
		noun = inputReader.nextLine();

		System.out.println("Enter a adjective: ");
		adj = inputReader.nextLine();

		System.out.println("Enter another noun: ");
		anotherNoun = inputReader.nextLine();

		System.out.println("Enter a number: ");
		stringNumber = inputReader.nextLine();
		number = Integer.parseInt(stringNumber);

		System.out.println("Enter another adjective: ");
		anotherAdj = inputReader.nextLine();

		System.out.println("Enter a plural noun: ");
		pluaralNoun = inputReader.nextLine();

		System.out.println("Enter another plural noun: ");
		anotherPluaralNoun = inputReader.nextLine();

		System.out.println("Enter one more plural noun: ");
		oneMorePluaralNoun = inputReader.nextLine();

		System.out.println("Enter a verb present tense: ");
		verbPresentTense = inputReader.nextLine();

		System.out.println("Enter a verb past tense: ");
		verbPastTense = inputReader.nextLine();

		System.out.println("\n\n*** NOW LETS GET MAD (libs) ***");
		
		System.out.println( "\n\n" + noun + "the" + adj + "frontier. These are the voyages of the starship " + anotherNoun + 
				"."  + "Its" + number +" - " + "\n year mission: to explore strange " + anotherAdj + "" + pluaralNoun + ", \nto seek out "
				+ anotherAdj + " " + anotherPluaralNoun + "and" + anotherAdj + " "  + oneMorePluaralNoun + ", " + 
				"to boldy " + verbPresentTense + " where no one has" + verbPastTense + "before");
	}
}
