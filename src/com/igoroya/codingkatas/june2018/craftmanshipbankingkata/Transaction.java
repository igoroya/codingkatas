package com.igoroya.codingkatas.june2018.craftmanshipbankingkata;

import java.util.Date;

public class Transaction {
  
  public final Date date;
  public final int value;
  public final int newBalance;

  public Transaction(Date date, int value, int newBalance) {
    this.date = date;
    this.value = value;
    this.newBalance = newBalance;
  }
  
  
}
