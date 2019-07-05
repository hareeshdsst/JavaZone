package com.javapractice.examples;

public class MoreBucketMoreFun {
	
	  public static void main(String[] args) {

	        // Declare ALL THE THINGS
	        // (Usually it's a good idea to declare them at the beginning of the program)
	        int butterflies, beetles, bugs;
	        String color, size, shape, thing;
	        double number;

	        // Now give a couple of them some values
	        butterflies = 2;
	        beetles = 4;
          //bugs = 6;
	        bugs = butterflies + beetles;
	        System.out.println("There are only " + butterflies + " butterflies,");
	        System.out.println("but " + bugs + " bugs total.");

	        System.out.println("Uh oh, my dog ate one.");
	        //butterflies = 1
	        butterflies--;
	        System.out.println("Now there are only " + butterflies + " butterflies left.");
	        //bugs = 6
	        System.out.println("But still " + bugs + " bugs left, wait a minute!!!");
	        System.out.println("Maybe I just counted wrong the first time...");
	        
	        // 3 - The number of bugs doesn't change because the + operator just does math on
	        // the values of butterflies, beetles and bugs. It doesn't establish a relationship.
	    }
}
