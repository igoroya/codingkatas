package com.igoroya.codingkatas.april2018.callcenter;

public abstract class Employee {

  private String name;
  private EmployeeType type;
  private volatile boolean isBusy;

  Employee(String name, EmployeeType type) {
    this.name = name;
    this.type = type;
  }

  public abstract void processCall(Issue issue);

  synchronized void setBusy() {
    this.isBusy = true;
  }

  synchronized void setIdle() {
    this.isBusy = false;
  }

  public synchronized boolean isBusy() {
    return this.isBusy;
  }

  public String getName() {
    return name;
  }

  public EmployeeType getEmployeeType() {
    return type;
  }

}
