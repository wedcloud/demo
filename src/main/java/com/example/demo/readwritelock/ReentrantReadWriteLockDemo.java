package com.example.demo.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author 许海斌
 *
 * @create 2020/4/1 0001 22:57
 *     <p>读写锁
 *     <p>独占锁（写锁） 共享锁（读锁）
 */
public class ReentrantReadWriteLockDemo {
  public static void main(String[] args) {
    Data data = new Data();
    // 写
    for (int i = 1; i <= 10; i++) {
      // 执行写操作
      final int temp = i;
      new Thread(
              () -> {
                data.write(temp + "", "");
              },
              String.valueOf(i))
          .start();
    }

    // 读
    for (int i = 1; i <= 10; i++) {
      // 执行写操作
      final int temp = i;
      new Thread(
              () -> {
                data.read(temp + "");
              },
              String.valueOf(i))
          .start();
    }
  }
}

/** 线程资源类 */
class Data {
  final Map<String, Object> map = new HashMap<>();
  ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

  public void read(String key) {
    readWriteLock.readLock().lock();
    try {
      System.out.println(Thread.currentThread().getName() + "开始读取");
      map.get(key);
      System.out.println(Thread.currentThread().getName() + "读取完成");
    } finally {
      readWriteLock.readLock().unlock();
    }
  }

  public void write(String key, Object value) {
    readWriteLock.writeLock().lock();
    try {
      System.out.println(Thread.currentThread().getName() + "写入开始");
      map.put(key, value);
      System.out.println(Thread.currentThread().getName() + "写入完成");
    } finally {
      readWriteLock.writeLock().unlock();
    }
  }
}
