package com.example.demo.productercomsume;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JUC 生成这、消费者
 *
 * @author xuhb
 */
public class JucProducterComsume {
  public static void main(String[] args) {
    JucData data = new JucData();
    new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                try {
                  data.increment();
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
                  data.decrement();
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
                  data.increment();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            },
            "C")
        .start();
    new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                try {
                  data.decrement();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            },
            "D")
        .start();
  }
}

/** Juc 线程资源类 */
class JucData {
  private int number = 0;
  Lock lock = new ReentrantLock();
  Condition condition = lock.newCondition();
  /** 生产者方法 */
  public void increment() throws InterruptedException {
    lock.lock();
    try {
      while (number == 1) {
        condition.await();
      }
      number++;
      System.out.println(Thread.currentThread().getName() + "-->" + number);
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }

  /** 消费者 */
  public synchronized void decrement() throws InterruptedException {
    lock.lock();
    try {
      while (number == 0) {
        condition.await();
      }
      number--;
      System.out.println(Thread.currentThread().getName() + "-->" + number);
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }
}
