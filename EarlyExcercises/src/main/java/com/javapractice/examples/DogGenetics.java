package com.javapractice.examples;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		Random rng = new Random();
		String dogName;
		String[] breeds = { "St. Bernard", "Chihuahua", "Dramatic Red Nosed Asian Pug", "Common Cur", "King Doberman" };
		int[] scores = new int[5];
		int random;
		double sum = 0;

		System.out.print("What is your dog's name? ");
		dogName = scn.nextLine();

		System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");

		for (int i = 0; i < 5; i++) {
			scores[i] = rng.nextInt(100);
			sum += scores[i];
		}
		
		for (int i = 0; i < 5; i++) {
			scores[i] = (int) Math.round(100 * (scores[i] / sum));
		}
		
		sum = 0;
		System.out.println("\n" + dogName + " is: \n");
		for (int i = 0; i < 5; i++) {
			sum += scores[i];
			System.out.println(scores[i] + "%\t" + breeds[i]);
		}
		System.out.println("\nWow, that's QUITE the dog! Sum:" + sum);
	}
}