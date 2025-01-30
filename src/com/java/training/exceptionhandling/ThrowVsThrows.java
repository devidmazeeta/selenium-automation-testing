package com.java.training.exceptionhandling;

public class ThrowVsThrows {
	public static void validateAge(int age) throws IllegalArgumentException {
		if (age < 18) {
			throw new IllegalArgumentException("Not eligible to vote.");
		}
	}

	public static void main(String[] args) {
		try {
			validateAge(16); // This will throw an exception
		} catch (IllegalArgumentException e) {
			System.out.println("Caught Exception: " + e.getMessage());
		}
	}
}
