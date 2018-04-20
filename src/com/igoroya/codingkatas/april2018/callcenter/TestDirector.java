package com.igoroya.codingkatas.april2018.callcenter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDirector {
 
  Director director;
  CallCenter callCenter;
  
  @BeforeEach
  void setUp() throws Exception {
    callCenter = new StubCallCenter();
    Staff staff = MockStaff.getOneMemberEachStaff();
    director = staff.getDirector();
    callCenter.updateStaff(staff);
  }

  @Test
  void testGetName() {
    String directorName = "Igor";
    Director director = new Director(directorName);
    assertEquals(directorName, director.getName());
  }

  @Test
  void testGetEmployeeType() {
    String directorName = "Igor";
    Director director = new Director(directorName);
    assertEquals(EmployeeType.DIRECTOR, director.getEmployeeType());
  }
  
  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testProcessCall() {
      Issue spyIssue = new Issue(3, "Medium Priority Spy Issue");
      director.processCall(spyIssue);
      String expendedLogMessage = "Issue was succesfully fixed by director " + director.getName() + ". Closing.";
      assertTrue(spyIssue.getIssueText().contains(expendedLogMessage));
  }

}
