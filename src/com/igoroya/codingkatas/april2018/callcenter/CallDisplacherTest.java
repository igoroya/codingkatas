package com.igoroya.codingkatas.april2018.callcenter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ArrayBlockingQueue;

import org.junit.jupiter.api.Test;

class CallDisplacherTest {

  @Test
  void testRun() throws InterruptedException {
    ArrayBlockingQueue<Issue> queue = new ArrayBlockingQueue<>(10);
    Respondent respondent = new MockRespondent("Mr A.");
    CallDisplacher displatcher = new CallDisplacher(respondent, queue);
    
    int issueLevel = 5 ;
    Issue issue = new Issue(issueLevel, "My issue");
    queue.put(issue);
    displatcher.run();
    
    assertTrue(queue.isEmpty());
    
  }

}
