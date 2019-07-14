package com.javapractice.examples;

import java.util.Scanner;

public class HealthyHearts2 {

	public static void main(String[] args) {
		heartRate(25);
	}

	public static void heartRate(int ageOfUser) {
		Scanner inputReader = new Scanner(System.in);
		int age, maxHeartRate, lowHeartRate;
		double highHeartRate;
		System.out.print("What is your age? ");
		age = Integer.parseInt(inputReader.nextLine());
		maxHeartRate = 220 - age;
		lowHeartRate = maxHeartRate / 2;
		highHeartRate = maxHeartRate * 0.85;
		System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
		System.out.println("Your target HR Zone is " + lowHeartRate + " - " + (int) highHeartRate + " beats per minute.");
	}
}