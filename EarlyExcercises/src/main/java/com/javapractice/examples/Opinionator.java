package com.javapractice.examples;

import java.util.Random;

public class Opinionator {
	public static void main(String[] args) {
		Random randomizer = new Random();
		System.out.println("I can't decide what animal I like the best.");
		System.out.println("I know Random can decide FOR ME! ");
        // need to add plus one to generate numbers from 1 to 5.
		int x = randomizer.nextInt(5) + 1;

		System.out.println("The number choose was: " + x);

		if (x == 0) {
			System.out.println("Llamos are the best!");
		} else if (x == 1) {
			System.out.println("Dodos are the bset");
		} else if (x == 2) {
			System.out.println("Woolly Mammoths are DEFINITELY the best!");
		} else if (x == 3) {
			System.out.println("Sharks are the greatest, they have their own week!");
		} else if (x == 4) {
			System.out.println("Cockatoos are just so awesomme!");
		} else if (x == 5) {
			System.out.println("Have you ever met a Mole-Rat? They're GREAT!");
		}
		
	    System.out.println("Thanks Random, maybe YOU'RE the best!");
	}
}
