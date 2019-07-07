package com.javapractice.examples;

import java.util.Random;
import java.util.Scanner;

public class CoinFlipper {
	public static void main(String[] args) {
		Random randomizer = new Random();

		Scanner sc = new Scanner(System.in);
		boolean result = randomizer.nextBoolean();

		System.out.println("Please Toss coin: ");

		if (result == true) {
			System.out.println("Its head");
		} else {
			System.out.println("Its tails");
		}

	}
}
