package com.igoroya.codingkatas.april2018.callcenter;

import java.util.LinkedList;
import java.util.List;

public final class Issue {

  /*
   * Issue level goes from 1 (top priority) to 10 (Minimum)
   */
  private int issueLevel;
  private List<String> issueText;
  private boolean isFixed;

  /**
   * Issue to be managed by a call center employee.
   * @param issueLevel priority from 1 (top priority) to 10 (Minimum).
   * @param originalIssueText text describing the issue.
   */
  public Issue(int issueLevel, String originalIssueText) {
    validateAndsetIssueLevel(issueLevel);
    issueText = new LinkedList<String>();
    issueText.add(originalIssueText);
    isFixed = false;
  }

  public int getIssueLevel() {
    return issueLevel;
  }

  public void fixIssue() {
    isFixed = true;
  }

  public boolean isFixed() {
    return isFixed;
  }

  public List<String> getIssueText() {
    return issueText;
  }

  public void appendIssueText(String issueTextUpdate) {
    issueText.add(issueTextUpdate);
  }

  /**
   * Sets the issue level.
   * 
   * <p>Issue level goes from 1 (top priority) to 10 (Minimum) Issues from 10 to 4
   * are handled by Respondent Issues from 2 to 3 can be handled by Manager Issues
   * of level 1 can onbly be handles by Director
   */
  public void setIssueLevel(int issueLevel) {
    validateAndsetIssueLevel(issueLevel);
  }

  private void validateAndsetIssueLevel(int issueLevel) {
    if (issueLevel < 1 || issueLevel > 10) {
      throw new IllegalArgumentException("Invalid issue level, provided: " + issueLevel);
    }
    this.issueLevel = issueLevel;
  }

}
