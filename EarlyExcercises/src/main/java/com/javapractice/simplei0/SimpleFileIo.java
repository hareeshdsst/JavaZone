package com.javapractice.simplei0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleFileIo {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("outFile.txt"));
		out.println("Hi Im Hareesh");
		out.println("Currently working as a software Engineer");
		out.println("Some Text");
		out.flush();
		out.close();

		Scanner sc = new Scanner(new BufferedReader(new FileReader("outFile.txt")));
		while (sc.hasNextLine()) {
			String currentLine = sc.nextLine();
			System.out.println(currentLine);
		}
		System.out.println("Thats all content in the file.");
	}
}
