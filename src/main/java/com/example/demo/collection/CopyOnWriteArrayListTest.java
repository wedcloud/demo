package com.example.demo.collection;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList 线程不安全
 *
 * @author xuhb
 */
public class CopyOnWriteArrayListTest {
  public static void main(String[] args) {
    /**
     * 1. List<String> list = new ArrayList<>() 多线程并发时，出现异常
     * java.util.ConcurrentModificationException
     *
     * <p>解决
     *
     * <p>1. 使用线程安全集合 Vector ,List<String> list = new Vector<>();
     *
     * <p>2. 使用集合工具，将 ArrayList 变成线程安全的 Collections.synchronizedList(new ArrayList<>())
     *
     * <p>3. 使用 CopyOnWriteArrayList ,写入时复制
     */
    List<String> list = new CopyOnWriteArrayList<>();
    for (int i = 0; i < 10; i++) {
      new Thread(
              () -> {
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
              },
              String.valueOf(i))
          .start();
    }
  }
}
