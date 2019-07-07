package com.javapractice.examples;

public class DifferentKettleOfFish {
	public static void main(String[] args) {
		int fish = 1;
		for(int i = fish; fish <= 10; fish++) {
			if (fish == 3) {
				System.out.println("RED fish!");
			} else if (fish == 4) {
				System.out.println("BLUE fish!");
			} else {
				System.out.println(fish + " fish!");
			}
		}
	}
}

