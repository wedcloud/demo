package com.example.demo.cas;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author 许海斌
 *
 * @create 2020/4/3 0003 21:39
 */
public class CasDemo {
  public static void main(String[] args) {
    AtomicStampedReference<Integer> reference = new AtomicStampedReference(1, 1);
    ThreadPoolExecutor poolExecutor =
        new ThreadPoolExecutor(
            2,
            2,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3),
            new ThreadPoolExecutor.AbortPolicy());
    poolExecutor.execute(
        () -> {
          // 获得时间戳标志
          int tmp = reference.getStamp();
          System.out.println("A1 ->" + tmp);
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          // 执行cas操作
          System.out.println(
              "A2 ->"
                  + reference.compareAndSet(1, 2, reference.getStamp(), reference.getStamp() + 1));
          System.out.println("A2 ->" + reference.getStamp());

          System.out.println(
              "A3 ->"
                  + reference.compareAndSet(2, 1, reference.getStamp(), reference.getStamp() + 1));
          System.out.println("A3 ->" + reference.getStamp());
        });

    poolExecutor.execute(
        () -> {
          // 获得时间戳标志
          int tmp = reference.getStamp();
          System.out.println("B1 ->" + tmp);
          try {
            TimeUnit.SECONDS.sleep(2);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          // 执行cas操作
          System.out.println("B2 ->" + reference.compareAndSet(1, 2, tmp, tmp + 1));
          System.out.println("B2 ->" + reference.getStamp());
        });
  }
}
