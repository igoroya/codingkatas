package com.igoroya.codingkatas.june2018.bankingkata;

import static org.junit.jupiter.api.Assertions.*;

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

//  @Test
//  void testGetStatement() {
//    Account account = new Account();
//    
//    account.deposit(100);
//    List<String> statement = account.getStatement();
//    
//  }
  
  
}
