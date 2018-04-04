package com.igoroya.codingkatas.march2018;

public class FindPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nPrimes = 10;
		
		determinePrimes(nPrimes);
	}

	private static void determinePrimes(int numPrimes) {
		
		if (numPrimes < 1) 
			System.out.println(numPrimes +" numer of primes requested, nothing to do"); 
	
		
		System.out.println("Printing first " + numPrimes + " primes");
		
		int foundPrimes = 0;
		int currentCandidate = 1;
		
		while (foundPrimes < numPrimes) {
			if (isPrime(currentCandidate)) {
				printPrime(currentCandidate);
				foundPrimes++;
			}
			currentCandidate++;
		}
		
		System.out.println("Done printing primes");
		
	}

	private static boolean isPrime(int candidate) {
		if (candidate < 1)
			return false;
		
		if (candidate == 1) { 
			return true;
		}
			
		if (candidate == 2) { 
			return true;
		}

		if (candidate % 2 == 0) { 
			return false;
		}
		
		for (int i = 3; i*i <=candidate; i+=2) {
			if ((candidate % i) == 0) {
				return false;	
			}
		}	
		return true;
		
	}
	
	private static void printPrime(int prime) {
		System.out.println("Found Prime: " + prime);
	}
}
