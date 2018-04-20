package com.igoroya.codingkatas.april2018.callcenter;

import java.util.Optional;
import java.util.Set;

public final class Staff {
  private final Set<Respondent> respondents;
  private final Set<Manager> managers;
  private final Director director;

  /**
   * Staff of a call center.
   * @param respondents set of respondents in the team.
   * @param managers set of managers in the team.
   * @param director the unique director in the team.
   */
  public Staff(Set<Respondent> respondents, Set<Manager> managers, Director director) {

    this.respondents = respondents;
    this.managers = managers;
    this.director = director;

  }

  void registerAllToCallCenter(CallCenter center) {

    for (Respondent r : respondents) {
      r.registerToCallCenter(center);
    }

    for (Manager m : managers) {
      m.registerToCallCenter(center);
    }
  }

  /**
   * Prints members of the staff in the console.
   */
  public void printStaff() {
    System.out.println("Director");
    System.out.println(director);
    System.out.println("==============");
    System.out.println("Managers");
    System.out.println(managers);
    System.out.println("==============");
    System.out.println("Respondents");
    System.out.println(respondents);
    System.out.println("==============");

  }

  Optional<Manager> getFreeManager() {
    for (Manager m : managers) {
      if (!m.isBusy()) {
        return Optional.of(m);
      }
    }
    return Optional.empty();
  }

  Optional<Respondent> getFreeRespondent() {
    for (Respondent r : respondents) {
      if (!r.isBusy()) {
        return Optional.of(r);
      }
    }
    return Optional.empty();
  }

  Director getDirector() {
    return this.director;
  }

}
