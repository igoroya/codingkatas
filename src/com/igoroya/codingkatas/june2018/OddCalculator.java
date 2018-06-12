package com.igoroya.codingkatas.june2018;

public class OddCalculator {

  static public boolean isOdd(int number) {
    if(number % 2 == 0) 
      return false;
    else
      return true;
  }
  
  public static void main(String[] args) {
    int odd = 3;
    System.out.println(isOdd(odd));
    int even = 12;
    System.out.println(isOdd(even));
    
  }

}
