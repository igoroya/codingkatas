package com.igoroya.codingkatas.june2018.bankingkata;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAccount {

  @BeforeEach
  void setUp() throws Exception {
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testWithdraw() {
    Account account = new Account();
     
    assertThrows(IllegalArgumentException.class,
        ()->{
          account.withdraw(1);
        },
        "Insufficient funds");
    
  
  }
  
 
  @Test
  void testDeposit() {
    Account account = new Account();
    
    account.deposit(100);
    assertEquals(100, account.getBalance());
    
    account.withdraw(100);
    assertEquals(0, account.getBalance());
    
  }

  @Test
  void testGetStatement() {
    Account account = new Account();
    
    int valueToDeposit = 100;
    
    Date aboutToDepositDate = Date.from(Instant.now());
    account.deposit(valueToDeposit);
    List<TransactionEntry> statement = account.getStatement();
    int addedAmount = statement.get(statement.size() - 1).transactionValue;
    assertEquals(valueToDeposit, addedAmount);
    
    //Date transactionDate = statement.get(statement.size() - 1).date;
    //assertTrue(transactionDate.after(aboutToDepositDate));
    
    int valueToWithdraw = 50;
    int expectedBalance = 50;
    account.withdraw(valueToWithdraw);
    statement = account.getStatement();
    int balance = statement.get(statement.size() - 1).balanceAtTransaction;
    assertEquals(expectedBalance, balance);
    
    int previousBalance = statement.get(statement.size() - 2).balanceAtTransaction;
    assertEquals(100, previousBalance);
    
    int previousTransaction = statement.get(statement.size() - 2).transactionValue;
    assertEquals(valueToDeposit, previousTransaction);
 
  }

  @Test
  void testTransactionEntry( ) {
    int transactionValue = 500;
    int balanceAtTransaction = 500;
    TransactionEntry entry = new TransactionEntry(transactionValue, balanceAtTransaction);
    assertEquals(transactionValue, entry.transactionValue);
    assertEquals(balanceAtTransaction, entry.balanceAtTransaction);
    
  }
  
  
  @Test
  void testPrintStatement( ) {
  
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
   
    Account account = new Account();
    int valueToDeposit = 500;
    //Date aboutToDepositDate = Date.from(Instant.now());
    account.deposit(valueToDeposit);
    
    account.printStatement();
    
    String expectedOutput  = "Date        Amount  Balance\n" + 
                             "24.12.2015   +500      500";
    
    //assertEquals(expectedOutput, outContent.toString());
    
  }
  
}
