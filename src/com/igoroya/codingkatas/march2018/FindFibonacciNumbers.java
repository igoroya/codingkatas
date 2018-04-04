package com.igoroya.codingkatas.march2018;

import java.util.Scanner;


public class FindFibonacciNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert the numer of terms in the fibonacci sequence you want to calculate");
		long length = scanner.nextLong();
		scanner.close();
		
		calculateFibonacciSequence(length);		
	}

	private static void calculateFibonacciSequence(long length) {
		long previousFiboncciNum = 0;
		long currentFiboncciNum = 1;
		
		printNum(currentFiboncciNum);
		
		for (int  i = 1; i<length; i++) {
			long t = currentFiboncciNum;
			currentFiboncciNum = getNextFibonnaciNum(previousFiboncciNum, t);
			previousFiboncciNum = t;
			printNum(currentFiboncciNum);
		}
	}
	private static long getNextFibonnaciNum(long num1, long num2) {
		return num1+num2;
	}
	
	private static void printNum(long num) {
		System.out.print(" "+num);
	}
	
}
