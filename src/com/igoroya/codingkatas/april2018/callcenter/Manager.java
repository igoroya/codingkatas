package com.igoroya.codingkatas.april2018.callcenter;

public class Manager extends Employee {

  private CallCenter center;

  /**
   * A manager of the call center able to process higher priority issues.
   * @param name the name of the manager.
   */
  public Manager(String name) {
    super(name, EmployeeType.MANAGER);
    this.setIdle();

  }

  void registerToCallCenter(CallCenter center) {
    this.center = center;
  }

  /**
   * Manager is able to solve any issue except of priority 1.
   */
  @Override
  public void processCall(Issue issue) {
    this.setBusy();
    if (issue.getIssueLevel() > 1) {
      solveIssue(issue);
    } else {
      forwardToDirector(issue);
    }

    this.setIdle();

  }

  private void forwardToDirector(Issue issue) {

    Staff staff = center.getStaff();

    if (!staff.getDirector().isBusy()) {
      issue.appendIssueText("Sent to director.");
      staff.getDirector().processCall(issue);
    } else {
      issue.appendIssueText("Director also busy. Putting back to queu");
      center.dispatchCall(issue);
    }
  }

  private void solveIssue(Issue issue) {
    workSolvingIssue();
    issue.appendIssueText("Issue was succesfully fixed by manager " + this.getName() + ". Closing.");
    issue.fixIssue();
  }

  void workSolvingIssue() {
    try {
      Thread.sleep(2000);// 2 Second per issue
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
