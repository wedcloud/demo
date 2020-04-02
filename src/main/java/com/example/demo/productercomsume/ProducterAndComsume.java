package com.example.demo.productercomsume;

/**
 * synchronized版本 生产者和消费者
 *
 * @author xuhb
 */
public class ProducterAndComsume {
  public static void main(String[] args) {
    Data data = new Data();
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

/** 线程资源类 */
class Data {
  private int number = 0;

  /**
   * 生成这方法
   *
   * @throws InterruptedException
   */
  public synchronized void increment() throws InterruptedException {
    while (number == 1) {
      this.wait();
    }
    number++;
    System.out.println(Thread.currentThread().getName() + "-->" + number);
    this.notifyAll();
  }

  /** @throws InterruptedException */
  public synchronized void decrement() throws InterruptedException {
    while (number == 0) {
      this.wait();
    }
    number--;
    System.out.println(Thread.currentThread().getName() + "-->" + number);
    this.notifyAll();
  }
}
