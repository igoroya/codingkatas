package com.igoroya.codingkatas.june2018.craftmanshipbankingkata;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
  void testPrintStatementTransaction() {
    // Forwards the output stream to "outContent"
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    
    Account account = new Account();
    account.printStatement();
    
    String expectedOutputAtT1  = "Date        Amount  Balance\n";
    assertEquals(expectedOutputAtT1, outContent.toString());
  }

}
