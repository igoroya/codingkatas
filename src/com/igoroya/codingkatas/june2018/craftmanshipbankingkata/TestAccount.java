package com.igoroya.codingkatas.june2018.craftmanshipbankingkata;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  void testNewAccountHasBalanceOfZero() {
    assertEquals(0, new Account().getBalance());
  }

  @Test
  void testDeposit() {
    Account account = new Account();
    account.deposit(100);
    assertEquals(100, account.getBalance());
      
  }
  
  @Test
  void testWithdraw() {
    Account account = new Account();
    account.withdraw(100);
    assertEquals(-100, account.getBalance());
      
  }

  @Test
  void testNewAccountHasNoTransactions() {
    Account account = new Account();
    
    assertEquals(0, account.getTransactions().size());
      
  }

  @Test
  void testAccountHasTransactionsAfterDeposit() {
    Account account = new Account();
    account.deposit(100);
    
    assertEquals(1, account.getTransactions().size());
   }

  
}
