package com.javapractice.examples;

import java.util.Scanner;

public class QuestForTheUserInput {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);

		String yourName;
		String yourQuest;
		double velocityOfSwallow;

		String stringVelocityOfSwallow;

		System.out.println("What is your name?? ");
		yourName = inputReader.nextLine();

		System.out.println("What is your quest?? ");
		yourQuest = inputReader.nextLine();

		System.out.print("What is the airspeed velocity of an unladen swallow?!?! ");
		stringVelocityOfSwallow = inputReader.nextLine();
		inputReader.nextLine();
		
		velocityOfSwallow = Double.parseDouble(stringVelocityOfSwallow);

		System.out.println("How do you know " + velocityOfSwallow + " is correct," + yourName + ",");
		System.out.println("when you didn't even know if the swallow was African or European!");
		System.out.println("Maybe skip answering things about birds and instead go " + yourQuest);

	}
}
