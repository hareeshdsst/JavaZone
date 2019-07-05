package com.javapractice.examples;

import java.util.Random;

public class WhileExample {
	public static void main(String[] args) {

		Random rm = new Random();
		int randumNum = rm.nextInt(10) + 1;
		System.out.println(randumNum);
		while(randumNum < 8){
			System.out.println(randumNum);
			randumNum = rm.nextInt(10) + 1;
		}

	}
}
