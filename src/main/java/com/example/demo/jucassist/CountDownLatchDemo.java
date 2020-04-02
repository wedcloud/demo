package com.example.demo.jucassist;

import java.util.concurrent.CountDownLatch;

/**
 * @Author 许海斌
 *
 * @create 2020/4/1 0001 22:03
 *     <p>CountDownLatch 减法计数器
 */
public class CountDownLatchDemo {
  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(6);
    for (int i = 0; i < 6; i++) {
      new Thread(
              () -> {
                System.out.println(Thread.currentThread().getName());
                // 计数器减一
                countDownLatch.countDown();
              },
              String.valueOf(i))
          .start();
    }
    // 等待计数器归零，然后再向下执行
    countDownLatch.await();
    System.out.println("close door");
  }
}
