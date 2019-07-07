package com.javapractice.examples;

import java.util.Scanner;

public class StayPositive {
	public static void main(String[] args) {

		int num;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		num = sc.nextInt();
		
		while(num != 0){
			System.out.println(num);
			num--;
		}
		System.out.println(num);
	}
}
