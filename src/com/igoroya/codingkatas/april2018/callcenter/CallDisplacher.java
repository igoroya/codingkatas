package com.igoroya.codingkatas.april2018.callcenter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Dispatch a call to the next available employee.
 * 
 * @author igoroya
 *
 */
public class CallDisplacher implements Runnable {

  private static final long MAX_WAIT_TIME_MIN = 1;
  private Employee employee;
  private BlockingQueue<Issue> queue;

  CallDisplacher(Employee employee, BlockingQueue<Issue> queue) {
    this.employee = employee;
    this.queue = queue;
  }

  @Override
  public void run() {
    dispatchCall();
  }

  void dispatchCall() {
    try {
      this.employee.processCall(queue.poll(MAX_WAIT_TIME_MIN, TimeUnit.MINUTES));
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
