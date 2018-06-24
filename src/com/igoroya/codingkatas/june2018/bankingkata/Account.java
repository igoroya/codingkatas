package com.igoroya.codingkatas.june2018.bankingkata;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represent an account in a bank
 * 
 * @author igoroya
 *
 */
public class Account {
  
  private int balance = 0;
  private List<TransactionEntry> transactions = new LinkedList<>();
  
  public void withdraw(int amount) throws IllegalArgumentException {
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds");
    }
    balance-=amount;
    transactions.add(new TransactionEntry(-amount, this.balance));
  }
 
  public void deposit(int amount) {
    balance+=amount;
    transactions.add(new TransactionEntry(amount, this.balance));
  }
  
  int getBalance() {
    return balance;
  }
  
  List<TransactionEntry> getStatement() {
    return Collections.unmodifiableList(transactions);
  }
  
  public void printStatement() {
    String header =  String.format("%s%14s%9s", "Date", "Amount", "Balance");
    
    System.out.println(header);
    
    for (TransactionEntry entry : transactions ) {
      System.out.println(entry);
    }
  }
  
}
