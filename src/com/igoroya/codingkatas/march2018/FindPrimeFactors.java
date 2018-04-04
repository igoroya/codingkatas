package com.igoroya.codingkatas.march2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FindPrimeFactors {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Finding the prime factor. Please insert number");
		long num = scanner.nextLong();
		scanner.close();
		List<Long> factors = getPrimeFactors(num);
		System.out.println(factors);
	}

	private static List<Long> getPrimeFactors(long num) {
		List<Long> factors = new ArrayList<>();
		Optional<Long> result = findDivisor(num);
		while (result.isPresent()) {	
			factors.add(result.get());
			num = num /= result.get() ; 
			result = findDivisor(num);
		}		
		if (num > 1)
			factors.add(num);
		return factors;
	}
	
	private static Optional<Long> findDivisor(Long num) {
		if (num == 1) {
			return Optional.empty();
		}
		
		for (long i=2; i<num; i++)
			if (num % i == 0) {
				return Optional.of(i);
			}
		
		return Optional.empty();
	}
	
}
