package com.javapractice.examples;

import java.util.Scanner;

public class BirthStones {
	public static void main(String[] args) {
		int month;
		String monthname;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter month number:");
		month = sc.nextInt();

		if (month == 1) {
			System.out.println(+month + " " + "January - Garnet");
		} else if (month == 2) {
			System.out.println(+month + "Feb - Amethyst");
		} else if (month == 3) {
			System.out.println(+month + "March - Amethyst");
		} else if (month == 4) {
			System.out.println(+month + "April - Amethyst");
		} else if (month == 5) {
			System.out.println(+month + "May - Amethyst");
		} else if (month == 6) {
			System.out.println(+month + "June - Amethyst");
		} else if (month == 7) {
			System.out.println(+month + "July - Amethyst");
		} else if (month == 8) {
			System.out.println(+month + "August - Amethyst");
		} else if (month == 9) {
			System.out.println(+month + "September - Amethyst");
		} else if (month == 10) {
			System.out.println(+month + "October - Amethyst");
		} else if (month == 11) {
			System.out.println(+month + "November - Amethyst");
		} else if (month == 12) {
			System.out.println(+month + "Decmeber - Amethyst");
		} else{
			System.out.println("Month name not availble");
		}
	}
}
