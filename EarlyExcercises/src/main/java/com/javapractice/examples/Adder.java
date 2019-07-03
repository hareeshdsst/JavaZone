package com.javapractice.examples;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Adder{
	 public static void main( String[] args ){
	    	
		 int sum = 0;
		 int operand1 = 0;
		 int operand2 = 0;
		 //Reads the users input
		 Scanner sc = new Scanner(System.in);
		 
		 String stringOperand1 = "";
		 String stringOperand2 = "";
		 
		 System.out.println("Enter First number:");
		 stringOperand1 =  sc.nextLine();
		 
		 System.out.println("Enter Second number:");
		 stringOperand2 =  sc.nextLine();
		 //Convert string to Integer
		 operand1 = Integer.parseInt(stringOperand1);
		 operand2 = Integer.parseInt(stringOperand2);
		 
		 sum = operand1 + operand2; 
		 
		 System.out.println("Sum of two numbers is: " + sum);
	    }
}

