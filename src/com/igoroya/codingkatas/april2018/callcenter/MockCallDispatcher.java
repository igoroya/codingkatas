package com.igoroya.codingkatas.april2018.callcenter;

import java.util.concurrent.BlockingQueue;

public class MockCallDispatcher extends CallDisplacher {

  MockCallDispatcher(Employee employee, BlockingQueue<Issue> queue) {
    super(employee, queue);
    // TODO Auto-generated constructor stub
  }

  @Override
  void dispatchCall() {
    ;//no-op
  }
  
}
