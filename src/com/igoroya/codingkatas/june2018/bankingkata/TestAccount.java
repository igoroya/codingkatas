package com.igoroya.codingkatas.june2018.bankingkata;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
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
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    int transactionValue = 400;
    int balanceAtTransaction = 400;
    String nowDate = dateFormatter.format(new Date());
    TransactionEntry entry = new TransactionEntry(transactionValue, balanceAtTransaction);
   
    assertEquals(transactionValue, entry.transactionValue);
    assertEquals(balanceAtTransaction, entry.balanceAtTransaction);
    String myDate = dateFormatter.format(entry.date);
    System.out.println(myDate);
    assertEquals(nowDate, myDate);
    
    String expectedString = nowDate + "   +" + transactionValue +"      " + balanceAtTransaction;
    assertEquals(expectedString, entry.toString());
    
  }
  
  
  @Test
  void testPrintStatementTransaction() {
  
    // Forwards the output stream to "outContent"
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
   
    Account account = new Account();
    int valueToDeposit = 500;
    Date aboutToDepositDate = Date.from(Instant.now());
    account.deposit(valueToDeposit);
    account.printStatement();
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    String dateRep = dateFormatter.format(aboutToDepositDate);  
    
    String formattedTr1Output = String.format("%10s%+7d%9d", dateRep, valueToDeposit, valueToDeposit);
    String expectedOutputAtT1  = "Date        Amount  Balance\n" + 
        formattedTr1Output + "\n";
    
    assertEquals(expectedOutputAtT1, outContent.toString());
    
    //Second transaction
    outContent.reset();
    int valueToRetreive = 100;
    Date aboutToRetreiveDate = Date.from(Instant.now());
    account.withdraw(valueToRetreive);
    account.printStatement();
    
    String dateRetRep = dateFormatter.format(aboutToRetreiveDate); 
    String formattedTr2Output = String.format("%10s%+7d%9d", dateRetRep, 
        -valueToRetreive, 
        valueToDeposit - valueToRetreive);
    String expectedOutputAtT2 = expectedOutputAtT1 + formattedTr2Output + "\n";
    assertEquals(expectedOutputAtT2, outContent.toString());
  }
  
}
