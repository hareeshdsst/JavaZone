
package com.sg.model;

/**
 * @author hareeshdevarasetty
 *
 */
public class Change {
	private int numPennies=0;
	private int numDimes=0;
	private int numNickles=0;
	private int numQuaters=0;
	
	public Change(int numPennies) {
		if(numPennies >= 25) {
			this.numQuaters = numPennies / 25;//$5 quaters 
			numPennies -= this.numQuaters * 25;//55 - 50 = 5 pennies
		}
		
		if(numPennies >= 10) {
			this.numDimes = numPennies / 10;
			numPennies -= this.numDimes * 10;
		}
		if(numPennies >= 5) {
			this.numNickles = numPennies / 10;
			numPennies -= this.numNickles * 5;
		}
		if(numPennies < 5) {
			this.numPennies = numPennies;
		}
	}

	public int getNumPennies() {
		return numPennies;
	}

	public int getNumDimes() {
		return numDimes;
	}

	public int getNumNickles() {
		return numNickles;
	}

	public int getNumQuaters() {
		return numQuaters;
	}
}
