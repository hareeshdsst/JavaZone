package com.javapractice.userIoLab;

public class App {

	public static void main(String[] args) {
		runApp();
	}

	private static void runApp() {
		String operator;
		double operand1, operand2;
		UserIoImpl io = new UserIoImpl();

		io.printLn("Hello lets do some Math.");

		while (true) {
			operator = io.readString("Choose an operator (+,-,*,/, anything else to exit): ");

			if (!(operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*"))) {
				io.print("Thanks for calculating with us:");
				break;
			}
			operand1 = io.readDouble("X: ");
			operand2 = io.readDouble("Y: ");

			switch (operator) {
			case "+":
				io.printLn(operand1 + " + " + operand2 + " = " + SimpleCalculator.add(operand1, operand2));
				break;
			case "-":
				io.printLn(operand1 + " + " + operand2 + " = " + SimpleCalculator.subtract(operand1, operand2));
				break;
			case "*":
				io.printLn(operand1 + " + " + operand2 + " = " + SimpleCalculator.multiply(operand1, operand2));
				break;
			case "/":
				io.printLn(operand1 + " + " + operand2 + " = " + SimpleCalculator.divide(operand1, operand2));
				break;
			default:
				break;
			}
		}
	}
}
