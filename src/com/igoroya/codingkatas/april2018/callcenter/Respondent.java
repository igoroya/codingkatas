package com.igoroya.codingkatas.april2018.callcenter;

import java.util.Optional;

public class Respondent extends Employee {

  private CallCenter center;

  public Respondent(String name) {
    super(name, EmployeeType.RESPONDENT);
    this.setIdle();
  }

  void registerToCallCenter(CallCenter center) {
    this.center = center;
  }

  /**
   * Respondent is able to solve issues priority > 5.
   */
  @Override
  public void processCall(Issue issue) {
    this.setBusy();

    if (issue.getIssueLevel() > 4) {
      solveIssue(issue);
    } else {
      forwardToManager(issue);
    }
    this.setIdle();
  }

  private void forwardToManager(Issue issue) {
    Staff staff = center.getStaff();

    Optional<Manager> manager = staff.getFreeManager();

    if (manager.isPresent() && !manager.get().isBusy()) {
      issue.appendIssueText("Issue was sent to Manager.");
      manager.get().processCall(issue);
    } else {
      issue.appendIssueText("Managers are busy.");
      if (!staff.getDirector().isBusy()) {
        issue.appendIssueText("Sent to director.");
      } else {
        issue.appendIssueText("Director is busy. Putting back to queue");
        center.dispatchCall(issue);
      }
    }
  }

  private void solveIssue(Issue issue) {

    workSolvingIssue();

    issue.appendIssueText("Issue was succesfully fixed by respondent"
            + this.getName()
            + ". Closing");
    issue.fixIssue();
  }

  void workSolvingIssue() {
    try {
      Thread.sleep(1000);// 1 Second per call
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
