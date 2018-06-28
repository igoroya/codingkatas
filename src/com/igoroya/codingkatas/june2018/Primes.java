package com.igoroya.codingkatas.june2018;

public class Primes {

  public static boolean isPrime(int number) {  
    
    if (number == 2) {
      return true;
    }
    
    if (number % 2 == 0) {
      return false;
    }
        
    
    for (int i = 3; i < Math.sqrt(number); i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    int number = 2;
    
    for (int i = 2; i < 100; i++) {
      number = i;
      boolean isPrime = Primes.isPrime(number);
      System.out.println(String.format("%s %d %s", "Is prime", number, isPrime));
    }
   
  }

}
