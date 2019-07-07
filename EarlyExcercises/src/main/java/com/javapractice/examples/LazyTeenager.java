package com.javapractice.examples;

import java.util.Random;

public class LazyTeenager {
	  public static void main(String[] args) {
	        int attempts = 0;
	        double chance = 0.05;
	        double check;
	        Random rng = new Random();
	        
	        do {
	            attempts++;
	            System.out.println("Clean your room!! (x" + attempts + ")");
	          
	            check = rng.nextDouble();
	            System.out.println(check);
	            if (check < chance) {
	                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
	                break;
	            }
	            
	            if (attempts == 15) {
	                System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
	            }
	        } while(attempts <= 14);
	    }
	}