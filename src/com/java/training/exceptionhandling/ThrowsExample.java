package com.java.training.exceptionhandling;

import java.io.*;

public class ThrowsExample {
	public static void readFile() throws IOException {
		FileReader file = new FileReader("nonexistent.txt"); // This file does not exist
		BufferedReader br = new BufferedReader(file);
		System.out.println(br.readLine());
	}

	public static void main(String[] args) {
		try {
			readFile(); // May throw IOException
		} catch (IOException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
}
