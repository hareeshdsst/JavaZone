package com.javapractice.examples;

import java.util.Scanner;

public class TriviaNight {
	public static void main(String[] args) {
		int answer1 = 4;
		int answer2 = 2;
		int answer3 = 3;
		int total = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("*****It's TRIVIA NIGHT! Are you ready?!*****");
		System.out.println("\nFirst Question");
		System.out.println("What is the Lowest Level Programming Language?");
		System.out.println("1) Source Code" + "        "  + "2) Assembly Language" );
		System.out.println("3) C#" + "        "  + "4)  Machine Code" );
		answer1 = sc.nextInt();
		if(answer1 == 4){
			total++;
		}
		
		System.out.println("Your answer is: " + answer1);
	
		System.out.println("\nSecond Question");
		System.out.println("\nWebsite Security CAPTCHA Forms Are Descended From the Work of?");
		System.out.println("1) Grace Hopper" + "        "  + "2) Alan Turing" );
		System.out.println("3)  Charles Babbage" + "        "  + "4) Charles Babbage" );
		answer2 = sc.nextInt();
		if(answer2 == 2){
			total++;
		}

		System.out.println("Your answer is: " + answer2);
		
		System.out.println("\nThird Question");
		System.out.println("\nWhich of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
		System.out.println("1) Serenity" + "        "  + "2) The Battlestar Galactica" );
		System.out.println("3) The USS Enterprise" + "        "  + "4)  The Millennium Falcon" );
		answer3 = sc.nextInt();
		if(answer3 == 3){
			total++;
		}
		System.out.println("Your answer is: " + answer3);
		
		System.out.println("You got total " + total + " answers! correct......");
		if(total == 0){
			System.out.println("Better luck next time!");
		}
	}
}
