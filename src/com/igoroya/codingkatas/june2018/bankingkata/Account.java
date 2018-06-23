package com.igoroya.codingkatas.june2018.bankingkata;

/**
 * Represent an account in a bank
 * 
 * @author igoroya
 *
 */
public class Account {
  
  private int balance = 0;
  
  public void withdraw(int amount) throws IllegalArgumentException {
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds");
    }
    balance-=amount;
  }
 
  public void deposit(int amount) {
    balance+=amount;
  }
  
  int getBalance() {
    return balance;
  }
  
}
