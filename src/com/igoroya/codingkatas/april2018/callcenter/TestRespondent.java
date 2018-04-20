package com.igoroya.codingkatas.april2018.callcenter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRespondent {

  private Respondent respondent;
  private CallCenter callCenter;

  @BeforeEach
  void setUp() throws Exception {
    callCenter = new StubCallCenter();

    Staff staff = MockStaff.getOneMemberEachStaff();
    respondent = staff.getFreeRespondent().get();

    callCenter.updateStaff(staff);

  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testGetName() {
    String respondentName = "Igor";
    Respondent respondent = new Respondent(respondentName);
    assertEquals(respondentName, respondent.getName());
  }

  @Test
  void testGetEmployeeType() {
    String respondentName = "Igor";
    Respondent respondent = new Respondent(respondentName);
    assertEquals(EmployeeType.RESPONDENT, respondent.getEmployeeType());
  }

  @Test
  void testProcessCallLowPriority() {
    Issue lowPrioritySpyIssue = new Issue(10, "Low Priority Spy Issue");
    respondent.processCall(lowPrioritySpyIssue);
    String expendedLogMessage = "Issue was succesfully fixed by respondent"
        + respondent.getName() 
        + ". Closing";
    assertTrue(lowPrioritySpyIssue.getIssueText().contains(expendedLogMessage));
    assertTrue(lowPrioritySpyIssue.isFixed());
  }

  @Test
  void testProcessCallMediumPriorityManagerIdle() {
    Issue mediumrioritySpyIssue = new Issue(3, "Medium Priority Spy Issue");
    respondent.processCall(mediumrioritySpyIssue);
    String expendedLogMessage = "Issue was sent to Manager.";
    assertTrue(mediumrioritySpyIssue.getIssueText().contains(expendedLogMessage));
  }

  @Test
  void testProcessCallMediumPriorityNoExistingManager() {
    Staff staff = MockStaff.getLackingManagerStaff();
    callCenter.updateStaff(staff);
    respondent = staff.getFreeRespondent().get();

    Issue mediumPrioritySpyIssue = new Issue(3, "Medium Priority Spy Issue");
    respondent.processCall(mediumPrioritySpyIssue);
    String expendedLogMessage = "Managers are busy.";

    assertTrue(mediumPrioritySpyIssue.getIssueText().contains(expendedLogMessage));
  }

  @Test
  void testProcessCallMediumPriorityNoIdleManager() {

    Staff staff = MockStaff.getBusyStaffTeams(false, true, false);
    callCenter.updateStaff(staff);
    respondent = staff.getFreeRespondent().get();

    Issue mediumPrioritySpyIssue = new Issue(3, "Medium Priority Spy Issue");
    respondent.processCall(mediumPrioritySpyIssue);

    String expendedLogMessage = "Managers are busy.";

    assertTrue(mediumPrioritySpyIssue.getIssueText().contains(expendedLogMessage));
  }

  @Test
  void testProcessCallMediumPriorityNoIdleManagerNorDirector() {

    Staff staff = MockStaff.getBusyStaffTeams(false, true, true);
    callCenter.updateStaff(staff);
    respondent = staff.getFreeRespondent().get();

    Issue mediumPrioritySpyIssue = new Issue(3, "Medium Priority Spy Issue");
    respondent.processCall(mediumPrioritySpyIssue);

    String expendedLogMessage = "Director is busy. Putting back to queue";

    assertTrue(mediumPrioritySpyIssue.getIssueText().contains(expendedLogMessage));

  }

}
