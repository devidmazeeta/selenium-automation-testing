package com.java.training.exceptionhandling;

public class ExceptionHandlingExample {

	// Method to divide two numbers
	public static int divide(int num1, int num2) {
		return num1 / num2; // Division by zero throws an exception
	}

	public static void main(String[] args) {

		try {
			int result = divide(10, 0); // This will throw ArithmeticException
			System.out.println("Result: " + result); // This line will not be executed
		} catch (ArithmeticException e) {
			System.out.println("Error: Cannot divide by zero.");
		} finally {
			System.out.println("This block runs regardless of an exception.");
		}

		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println("Element at index 5: " + numbers[5]); // ArrayIndexOutOfBoundsException
		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("Error: Index out of bounds.");
		}
	}
}
