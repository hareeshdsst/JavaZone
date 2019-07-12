package com.javapractice.examples;

import java.util.Scanner;

public class windowsMaster {

	public static void main(String[] args) {
		
		float height;
		float width;
		
		String stringHeight;
		String stringWidth;
		
		float areaOfWindow;
		float cost;
		float perimeterOfWindow;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter height of the window: ");
		stringHeight = sc.nextLine();
		
		System.out.println("Enter width of the window: ");
		stringWidth = sc.nextLine();
		
		height = Float.parseFloat(stringHeight);
		width = Float.parseFloat(stringWidth);
		
		areaOfWindow = height * width;
		perimeterOfWindow = 2 * (height + width);
	    cost = (3.50f * areaOfWindow) + (2.25f * perimeterOfWindow);
	    System.out.println("Area : " + areaOfWindow);	
	    System.out.println("Perimeter : " + perimeterOfWindow);	
	    System.out.println("Cost : " + cost);	

	}
}
