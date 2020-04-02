package com.example.demo.productercomsume;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JUC 顺序并发
 *
 * @author xuhb
 */
public class JucSequence {
  public static void main(String[] args) {
    Data3 data = new Data3();
    new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                try {
                  data.printA();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            },
            "A")
        .start();
    new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                try {
                  data.printB();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            },
            "B")
        .start();
    new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                try {
                  data.printC();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            },
            "C")
        .start();
  }
}

/** 线程资源类 */
class Data3 {
  private int number = 1;
  private Lock lock = new ReentrantLock();
  Condition condition1 = lock.newCondition();
  Condition condition2 = lock.newCondition();
  Condition condition3 = lock.newCondition();
  private static int first = 1;
  private static int second = 2;
  private static int third = 3;

  public void printA() throws InterruptedException {
    lock.lock();
    try {
      while (number != first) {
        condition1.await();
      }
      System.out.println(Thread.currentThread().getName() + "-->" + number);
      number = second;
      condition2.signal();
    } finally {
      lock.unlock();
    }
  }

  public void printB() throws InterruptedException {
    lock.lock();
    try {
      while (number != second) {
        condition2.await();
      }
      System.out.println(Thread.currentThread().getName() + "-->" + number);
      number = third;
      condition3.signal();
    } finally {
      lock.unlock();
    }
  }

  public void printC() throws InterruptedException {
    lock.lock();
    try {
      while (number != third) {
        condition3.await();
      }
      System.out.println(Thread.currentThread().getName() + "-->" + number);
      number = first;
      condition1.signal();
    } finally {
      lock.unlock();
    }
  }
}
