package com.java.training.exceptionhandling;

public class ThrowExample {
	public static void checkAge(int age) {
		if (age < 18) {
			throw new IllegalArgumentException("Age must be 18 or above."); // Throwing an exception
		}
		System.out.println("Access granted.");
	}

	public static void main(String[] args) {
		try {
			checkAge(15); // This will throw an exception
		} catch (IllegalArgumentException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
}
