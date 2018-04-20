package com.igoroya.codingkatas.april2018.callcenter;

public class Director extends Employee {

  Director(String name) {
    super(name, EmployeeType.DIRECTOR);
    this.setIdle();
  }

  @Override
  public void processCall(Issue issue) {
    this.setBusy();
    solveIssue(issue);
    this.setIdle();
  }

  /**
   * Director is able to solve issues of any priority.
   */
  private void solveIssue(Issue issue) {
    workSolvingIssue();
    issue.appendIssueText("Issue was succesfully fixed by director " + this.getName() + ". Closing.");
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
