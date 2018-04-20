package com.igoroya.codingkatas.april2018.callcenter;

/**
 * Mocks the behavior of respondent by reducing to zero the work time.
 * 
 * @author igoroya
 *
 */
public class MockRespondent extends Respondent {

  public MockRespondent(String name) {
    super(name);
  }

  @Override
  void workSolvingIssue() {
    ;// no-op
  }

}
