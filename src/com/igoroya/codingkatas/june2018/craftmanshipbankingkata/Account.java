package com.igoroya.codingkatas.june2018.craftmanshipbankingkata;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A bank account class
 * 
 * @author igoroya
 *
 *  A class Account that offers the following methods void deposit(int) void withdraw(int) String printStatement()
 *  An example statement would be:
 *  Date        Amount  Balance
 *  24.12.2015   +500      500
 *  23.8.2016    -100      400
 *
 */
public class Account {

  private int balance;
  private List<Transaction> transactions= new ArrayList<>(); 
  
  public Account() {
    // TODO Auto-generated constructor stub
  }
  public void deposit(int amount){
    balance+=amount;
    transactions.add(new Transaction(Date.from(Instant.now()), amount, balance));
  }

  public int getBalance() {
    return balance;
  }
  public List<Transaction> getTransactions() {
    // TODO Auto-generated method stub
    return transactions;
  }
  public void withdraw(int amount) {
    balance-=amount;
    transactions.add(new Transaction(Date.from(Instant.now()), -amount, balance));
  }
  
}
