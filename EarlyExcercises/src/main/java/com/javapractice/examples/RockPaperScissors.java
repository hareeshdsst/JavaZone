package com.javapractice.examples;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
	    final int ROCK = 1;
		final int PAPER = 2;
		final int SCISSORS = 3;
		Scanner scn = new Scanner(System.in);
		Random rng = new Random();
		int noOfRounds, playerInput, computerOutput;
		String computerOutputString = new String();
		while (true) {
			System.out.print("How many noOfRounds would you like to play? (1-10) : ");
			noOfRounds = Integer.parseInt(scn.nextLine());

			if (noOfRounds <= 0 || noOfRounds > 10) {
				System.out.println("Error: invalid number of noOfRounds. Exiting...");
				break;
			}
			while (noOfRounds > 0) {
				int cpuCounter = 0;
				int playerWin = 0;
				int draw = 0;
				System.out.print("Choose your move! 1 = Rock, 2 = Paper, 3 = Scissors : ");
				playerInput = Integer.parseInt(scn.nextLine());
				computerOutput = rng.nextInt(3) + 1;

				switch (computerOutput) {
				case ROCK:
					computerOutputString = "ROCK";
					break;
				case PAPER:
					computerOutputString = "PAPER";
					break;
				case SCISSORS:
					computerOutputString = "SCISSORS";
					break;
				}
				System.out.println("\nThe CPU chose... " + computerOutputString + "!\n");

				if (playerInput == computerOutput) {
					draw++;
				} else if (playerInput == PAPER && computerOutput == ROCK) {
					playerWin++;
				} else if (playerInput == ROCK && computerOutput == SCISSORS) {
					playerWin++;
				} else if (playerInput == SCISSORS && computerOutput == PAPER) {
					playerWin++;
				} else {
					cpuCounter++;
				}
				System.out.println("CURRENT STANDINGS");
				System.out.println("Player victories: " + playerWin);
				System.out.println("CPU victories: " + cpuCounter);
				System.out.println("Draws: " + draw + "\n");
				noOfRounds--;
			}

			System.out.print("Would you like to play again? (Y/N) ");
			if (!scn.nextLine().toLowerCase().contains("y")) {
				System.out.println("Thanks for playing!");
				break;
			}
		}
	}
}