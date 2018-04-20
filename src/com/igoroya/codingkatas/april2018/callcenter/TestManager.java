package com.igoroya.codingkatas.april2018.callcenter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestManager {

  Manager manager;
  CallCenter callCenter;
  
  @BeforeEach
  void setUp() throws Exception {
    callCenter = new StubCallCenter();

    Staff staff = MockStaff.getOneMemberEachStaff();
    manager = staff.getFreeManager().get();

    callCenter.updateStaff(staff);
  
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testGetName() {
    String managerName = "Igor";
    Manager manager = new Manager(managerName);
    assertEquals(managerName, manager.getName());
  }

  @Test
  void testGetEmployeeType() {
    String managerName = "Igor";
    Manager manager = new Manager(managerName);
    assertEquals(EmployeeType.MANAGER, manager.getEmployeeType());
  }
  
  @Test
  void testProcessCallMediumPriority() {
    Issue mediumPrioritySpyIssue = new Issue(3, "Medium Priority Spy Issue");
    manager.processCall(mediumPrioritySpyIssue);
    String expendedLogMessage = "Issue was succesfully fixed by manager " + manager.getName() + ". Closing.";
    assertTrue(mediumPrioritySpyIssue.getIssueText().contains(expendedLogMessage));
  }
  
  @Test
  void testProcessCallHighestPriorityIdleDirector() {
    Issue higherstPrioritySpyIssue = new Issue(1, "Highest Priority Spy Issue");
    manager.processCall(higherstPrioritySpyIssue);
    String expendedLogMessage = "Sent to director.";
    assertTrue(higherstPrioritySpyIssue.getIssueText().contains(expendedLogMessage));
  }

  @Test
  void testProcessCallHighestPriorityBusyDirector() {
    
    Staff staff = MockStaff.getBusyStaffTeams(false, false, true);
    callCenter.updateStaff(staff);
    manager = staff.getFreeManager().get();
    
    Issue higherstPrioritySpyIssue = new Issue(1, "Highest Priority Spy Issue");
    manager.processCall(higherstPrioritySpyIssue);
    String expendedLogMessage = "Director also busy. Putting back to queu";
    assertTrue(higherstPrioritySpyIssue.getIssueText().contains(expendedLogMessage));
  }
  
}
