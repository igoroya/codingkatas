package com.igoroya.codingkatas.june2018.bankingkata;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;

public final class TransactionEntry {
  
  final Date date;
  final int balanceAtTransaction;
  final int transactionValue;
  
  public TransactionEntry(int transactionValue, int balanceAtTransaction) {
    this.transactionValue = transactionValue;
    this.balanceAtTransaction = balanceAtTransaction;
    this.date = Date.from(Instant.now());
  }
  
  @Override
  public String toString() {
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    String dateRep = dateFormatter.format(date);  
    String formattedOutput = String.format("%10s%+7d%9d", dateRep, transactionValue, balanceAtTransaction);
    return formattedOutput;
    
  }
   
}
