package com.igoroya.codingkatas.may2018;

import java.util.Scanner;

public class PrimeCalculator {

  private static boolean isPrime(int number) {
    
    if (number < 2) {
      return false;
    }
    
    if (number == 2) {
      return true;
    }
    
    if (number % 2 == 0) {
      return false;
    }
    
    for (int checkerCount = 3;  checkerCount < Math.sqrt(number); checkerCount += 2) {   
      if (number % checkerCount == 0) {
        return false;
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Type a number");
    int number = scanner.nextInt();
    scanner.close();
    
    boolean isPrime = isPrime(number);
    String textPrime = isPrime == true ? "yes" : "no";
    System.out.println("" + number + " prime?: " + textPrime);
    

  }

}

