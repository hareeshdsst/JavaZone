package com.javapractice.examples;

import java.util.Scanner;

public class FieldDay {
	public static void main(String[] args) {
		String teamA = "Red Dragons";
		String teamB = "Dark Wizards";
		String teamC = "Moving Castles";
		String teamD = "Golden Snitches";
		String teamE = "Night Guards";
		String teamF = "Black Holes";
		
		String bAlphabet = "Baggins";
		String dAlphabet = "Dresden";
		String hAlphabet = "Howl";
		String pAlphabet = "Potter";
		String vAlphabet = "Vimes";
		
		String name = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		name =  sc.nextLine();
		
		int compareBResult = name.compareTo(bAlphabet);
		int compareDResult = name.compareTo(dAlphabet);
		int compareHResult = name.compareTo(hAlphabet);
		int comparePResult = name.compareTo(pAlphabet);
		int compareVResult = name.compareTo(vAlphabet);
		//TODO check with instructor
		if(compareBResult <= 2){
			System.out.println("You belongs to:"+ teamA);
		}
		if(compareBResult >= 2 && compareDResult < 4){
			System.out.println("You belongs to:"+ teamB);
		}
		if(compareDResult >= 4 && compareHResult < 8){
			System.out.println("You belongs to:"+ teamC);
		}
		if(compareHResult >= 8 && comparePResult < 16){
			System.out.println("You belongs to:"+ teamD);
		}
		if(comparePResult >= 16 && compareVResult < 22){
			System.out.println("You belongs to:"+ teamE);
		}
		if(compareVResult >= 22){
			System.out.println("You belongs to:"+ teamF);
		}
	}
}
