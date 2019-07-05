package com.javapractice.examples;

public class InABucket {
	public static void main(String[] args) {
		  // You can declare all KINDS of variables.
        String walrus;
        double piesEaten;
        float weightOfTeacupPig;
        int grainsOfSand;

        // But declaring them just sets up the space for data
        // to use the variable, you have to put data IN it first! 
        walrus = "Sir Leroy Jenkins III";
        piesEaten = 42.1;
        weightOfTeacupPig = 5.0f;
        grainsOfSand = 34;

        System.out.println("Meet my pet Walrus, " + walrus);
        System.out.print("He was a bit hungry today, and ate this many pies : ");
        System.out.println("Weight of teacup pig: " + weightOfTeacupPig);
        System.out.println("Grains of sand: " + grainsOfSand);
        System.out.println(piesEaten);
	}
}
