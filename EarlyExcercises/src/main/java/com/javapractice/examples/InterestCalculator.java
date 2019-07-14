package com.javapractice.examples;

import java.util.Scanner;

public class InterestCalculator {
	public static void main(String[] args) {

		Scanner inputReader = new Scanner(System.in);
		System.out.println("Enter Annual interest rate: ");// 10
		double annualInterestRate = inputReader.nextDouble();
		System.out.println("Enter Initial amount of principal");// 1000
		double pricipalAmount = inputReader.nextDouble();
		System.out.println("Enter The number of years the money is to stay in the fund");// 2Years
		int numberOfYears = inputReader.nextInt();
		interestCalculator(annualInterestRate, pricipalAmount, numberOfYears);
	}

	public static void interestCalculator(double annualInterestRate, double pricipalAmount, int numberOfYears) {
		double quaterelyInterestRate = annualInterestRate / 4;
		double amountEachQuater = pricipalAmount * (1 + (quaterelyInterestRate / 100));
		double amountEachYear = 4 * amountEachQuater;
		double pricipalAmountBeginningYear = pricipalAmount + amountEachYear;
		double finalPrincipalAmount = numberOfYears * amountEachYear;
		
		System.out.println("The year number " + numberOfYears);
		System.out.println("The principal at the beginning of the year " + pricipalAmountBeginningYear
				) ;
		System.out.println("The total amount of interest earned for the year" + amountEachYear);
		System.out.println("The principal at the end of the year : " + finalPrincipalAmount );
	}
}
