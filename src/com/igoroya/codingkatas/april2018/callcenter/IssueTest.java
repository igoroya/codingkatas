package com.igoroya.codingkatas.april2018.callcenter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class IssueTest {

  //Issue issue;
  //String issueText;
  
  @BeforeEach
  void setUp() throws Exception {
     ;
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testIssueLevel() {
    int issueLevel = 3 ;
    Issue issue = new Issue(issueLevel, "");
    assertEquals(issueLevel, issue.getIssueLevel());
 
    int newIssueLevel = 4;
    issue.setIssueLevel(newIssueLevel);       
    assertEquals(newIssueLevel, issue.getIssueLevel());
  }
  
  @Test
  void testSetWrongIssueLevel() {
    int issueLevel = 3 ;
    Issue issue = new Issue(issueLevel, "");
  
    int tooLowIssueLevel = 0 ;
    Executable executable = () -> issue.setIssueLevel(tooLowIssueLevel);
    assertThrows(IllegalArgumentException.class, executable,
        "Invalid issue level, provided: " + tooLowIssueLevel);

    int tooHighIssueLevel = 11 ;
    executable = () -> issue.setIssueLevel(tooHighIssueLevel);  
    assertThrows(IllegalArgumentException.class, executable,
        "Invalid issue level, provided: " + tooLowIssueLevel);

  }

  @Test
  void testFixIssue() {
    int issueLevel = 3 ;
    Issue issue = new Issue(issueLevel, "");
    assertFalse(issue.isFixed());
    issue.fixIssue();
    assertTrue(issue.isFixed());
  }


  @Test
  void testAppendIssueText() {
    int issueLevel = 3 ;
    String issueText = "First Entry";
    Issue issue = new Issue(issueLevel, issueText);
    
    String issueSencondText = "Second Entry";
    issue.appendIssueText(issueSencondText);
    
    assertEquals(issueText, 
        issue.getIssueText().get(
            issue.getIssueText().size() - 2)
        );

    assertEquals(issueSencondText, 
        issue.getIssueText().get(
            issue.getIssueText().size() - 1)
        );

    
  }

}
