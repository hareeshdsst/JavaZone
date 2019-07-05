package com.javapractice.examples;

import java.util.Scanner;

public class HealthyHearts {
	public static void main(String[] args) {
		int age = 0;
		int heartRate;

		@SuppressWarnings("resource")
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Enter you age: ");
		age = inputReader.nextInt();
		heartRate = 220 - age;
		double targe50tHearRate = heartRate * 50 / 100;
		double targe85tHearRate = heartRate * 85 / 100;
		System.out.println("Maximum Heart Rate " + heartRate);
		System.out.println("Target heart rate is" + targe50tHearRate + " - " + targe85tHearRate + "beats per minute.");
	}
}
