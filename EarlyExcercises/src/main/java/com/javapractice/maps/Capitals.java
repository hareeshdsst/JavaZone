package com.javapractice.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Capitals {
	String name;
	int population;
	int squareMileage;
	private Scanner userInput = new Scanner(System.in);

	/**
	 * Initialize properties using constructor.
	 * 
	 * @param name
	 * @param population
	 * @param squareMileage
	 */
	public Capitals(String name, int population, int squareMileage) {
		this.name = name;
		this.population = population;
		this.squareMileage = squareMileage;
	}

	public Capitals() {
		// Default constructor.
	}

	public static void main(String[] args) {
		Capitals capitals = new Capitals();
		HashMap<String, Capitals> stateCapitals = new HashMap<String, Capitals>();
		int populationMin;
		stateCapitals.put("Alabama", new Capitals("Montgomery,", 205764, 155));
		stateCapitals.put("Alaska", new Capitals("Juneau,", 31000, 3255));
		stateCapitals.put("Arizona", new Capitals("Phoenix,", 1445000, 517));
		stateCapitals.put("Arkansas", new Capitals("Little Rock,", 193000, 116));

		System.out.println("STATE | CAPITAL PAIRS");
		System.out.println("====================");

		Map<String, Capitals> map = new TreeMap<String, Capitals>(stateCapitals); // to sort hashmap alphabetically

		Set keys = map.entrySet();// Iterate over key-value set instead of iterating over key and grabbing value.

		Iterator iterator = keys.iterator();// iterator for treemap
		while (iterator.hasNext()) {
			// create instance of map.entry class
			Map.Entry capital = (Map.Entry) iterator.next();
			System.out.print(capital.getKey() + " - ");
			System.out.println(
					map.get(capital.getKey()).getName() + " | Pop: " + map.get(capital.getKey()).getPopulation()
							+ " | Area: " + map.get(capital.getKey()).getSquareMileage() + " sq mi");
		}

		// get user input
		System.out.println();
		populationMin = capitals.readInt("Please enter a minimum limit for population: ");

		System.out.println();
		System.out.println("CAPITALS WITH POPULATIONS GREATER THAN " + populationMin);

		for (String key : map.keySet()) {
			if (populationMin < map.get(key).getPopulation()) {
				System.out.println(key + " - " + map.get(key).getName() + " | Pop: " + map.get(key).getPopulation()
						+ " | Area: " + map.get(key).getSquareMileage() + " sq mi");
			}
		}
	}

	private int readInt(String prompt) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		int numInput = Integer.parseInt(input);
		return numInput;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getSquareMileage() {
		return squareMileage;
	}

	public void setSquareMileage(int squareMileage) {
		this.squareMileage = squareMileage;
	}
}
