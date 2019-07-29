package com.javapractice.maps;

import java.util.HashMap;

public class StateCapitals2 {

	public static void main(String[] args) {
		
		HashMap<String, Capitals> stateCapitals = new HashMap<String, Capitals>();
		Capitals capitals = new Capitals();
		stateCapitals.put("Alabama", capitals);
		stateCapitals.put("Alaska", capitals);
		stateCapitals.put("Arizona", capitals);
		stateCapitals.put("Arkansas", capitals);
		
	}
}
