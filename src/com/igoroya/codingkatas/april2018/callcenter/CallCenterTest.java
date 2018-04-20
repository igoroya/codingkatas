package com.igoroya.codingkatas.april2018.callcenter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CallCenterTest {

  @BeforeEach
  void setUp() throws Exception {
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testUpdateStaff() {
    
    Staff staff = MockStaff.getOneMemberEachStaff();
    
    CallCenter callCenter = new CallCenter();
    callCenter.updateStaff(staff);
    assertEquals(staff, callCenter.getStaff());
    
    Staff otherStaff = MockStaff.getLackingManagerStaff();
    callCenter.updateStaff(staff);
    assertEquals(otherStaff, callCenter.getStaff());
    }

  @Test
  void testDispatchCall() {
    fail("Not yet implemented");
  }

  @Test
  void testReInsertIssue() {
    fail("Not yet implemented");
  }

  @Test
  void testGetIssueQueue() {
    fail("Not yet implemented");
  }

}
