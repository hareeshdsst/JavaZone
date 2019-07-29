package com.javapractice.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class StateCapitals {

	public static void main(String[] args) {
		HashMap<String, String> stateCapitals = new HashMap();
		stateCapitals.put("Alabama", "Montgomery");
		stateCapitals.put("Alaska", "Juneau");
		stateCapitals.put("Arizona", "Phoenix");
		stateCapitals.put("Arkansas", "Little Rock");
		
		Set<String> keys = stateCapitals.keySet();
		
		for(String k : keys){
			System.out.println(stateCapitals.get(k) + "is the capital of " + k);
		}
		
		Collection<String> values = stateCapitals.values();
		
		for(String value : values){
			System.out.println("State names are" + value);
		}
		
	
	}

}
