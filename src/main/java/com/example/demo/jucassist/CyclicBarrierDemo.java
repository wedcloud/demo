package com.example.demo.jucassist;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author 许海斌
 *
 * @create 2020/4/1 0001 22:10
 *     <p>多线程 集齐7颗龙珠，召唤神龙
 */
public class CyclicBarrierDemo {
  public static void main(String[] args) {
    // 召唤神龙的线程
    CyclicBarrier barrier =
        new CyclicBarrier(
            7,
            () -> {
              System.out.println("召唤神龙 ！！！");
            });

    // 收集龙珠
    for (int i = 1; i < 8; i++) {
      final int temp = i;
      new Thread(
              () -> {
                System.out.println("收集到第" + temp + "颗龙珠");
                try {
                  // 等到，计数器+1
                  barrier.await();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                } catch (BrokenBarrierException e) {
                  e.printStackTrace();
                }
              })
          .start();
    }
  }
}
