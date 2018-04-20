package com.igoroya.codingkatas.april2018.callcenter;

import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CallCenter {

  private Staff staff;

  private BlockingQueue<Issue> queue;
  private static final int QUEUE_SIZE = 100;

  /**
   * A call center.
   */
  public CallCenter() {

    this.staff = null;
    queue = new ArrayBlockingQueue<>(QUEUE_SIZE);
  }

  public void updateStaff(Staff staff) {
    this.staff = staff;
    staff.registerAllToCallCenter(this);
  }

  /**
   * Dispatches an issue to a FIFO queue.
   * @param issue the issue inserted
   */
  public void dispatchCall(Issue issue) {
    System.out.println("Dispatching call");
    try {
      queue.put(issue);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    processNextIssue();
    System.out.println("Issue added");
  }

  /**
   * Reinserts an issue to the FIFO queue.
   * @param issue the issue inserted
   */
  public void reInsertIssue(Issue issue) {
    System.out.println("Reinserting Issue");
    try {
      queue.put(issue);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    processNextIssue();
    System.out.println("Issue inserted");
  }

  private void processNextIssue() {
    Optional<Respondent> respondent = staff.getFreeRespondent();

    if (respondent.isPresent() && !respondent.get().isBusy()) {
      new Thread(new CallDisplacher(respondent.get(), queue));
    } else {
      System.out.println("Respondents are busy.");
    }
  }

  BlockingQueue<Issue> getIssueQueue() {
    return queue;
  }

  public Staff getStaff() {
    return staff;
  }

}
