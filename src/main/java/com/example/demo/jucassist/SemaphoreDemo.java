package com.example.demo.jucassist;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author 许海斌
 *
 * @create 2020/4/1 0001 22:31
 *     <p>抢车位 限流
 */
public class SemaphoreDemo {
  public static void main(String[] args) {
    // 总车位
    Semaphore semaphore = new Semaphore(3);

    // 好多汽车
    for (int i = 0; i < 10; i++) {
      //
      new Thread(
              () -> {
                try {
                  // 从该信号量获取许可证，阻止直到可用
                  semaphore.acquire();
                  System.out.println(Thread.currentThread().getName() + "抢到车位");
                  TimeUnit.SECONDS.sleep(Math.round(5));
                  System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                  e.printStackTrace();
                } finally {
                  // 释放许可证，将其返回到信号量
                  semaphore.release();
                }
              },
              String.valueOf(i))
          .start();
    }
  }
}
