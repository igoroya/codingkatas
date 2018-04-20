package com.igoroya.codingkatas.april2018.callcenter;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class to support some common unit test operations.
 * 
 * @author igoroya
 *
 */
public class MockStaff {

  /**
   * Creates a staff team composed on one mock member of each type.
   * 
   * @return
   */
  public static Staff getOneMemberEachStaff() {

    Staff staff = getBusyStaffTeams(false, false, false);

    return staff;
  }

  /**
   * Factory generating a staff team without any manager.
   * @return a staff without any manager.
   */
  public static Staff getLackingManagerStaff() {

    Director director = new MockDirector("Mr. A");

    // Intentionally empty
    Set<Manager> emptyManagers = new HashSet<>();

    Respondent respondent = new MockRespondent("Mr C");

    Staff staff = new Staff(Set.of(respondent), emptyManagers, director);

    return staff;
  }

  /**
   * A mock staff team with one member type each, potentially busy.
   * @param isRespondentBusy respondent is labeled as busy.
   * @param isManagerBusy manager is labeled as busy.
   * @param isDirectorBusy director is labeled as busy.
   * @return
   */
  public static Staff getBusyStaffTeams(
      boolean isRespondentBusy,
      boolean isManagerBusy,
      boolean isDirectorBusy) {

    Director director = new MockDirector("Mr. A");
    if (isDirectorBusy) {
      director.setBusy();
    }
    Manager manager = new MockManager("Mr B");
    if (isManagerBusy) {
      manager.setBusy();
    }
    Respondent respondent = new MockRespondent("Mr C");
    if (isRespondentBusy) {
      respondent.setBusy();
    }

    Staff staff = new Staff(Set.of(respondent), Set.of(manager), director);

    return staff;
  }

}
