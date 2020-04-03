package com.example.demo.queue;

import org.springframework.lang.NonNull;

import java.util.concurrent.BlockingQueue;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>阻塞队列demo
 *
 * @author : 许先生
 * @date : 2020-04-02 10:42
 *     <p>一个抛出异常
 *     <p>第二个返回一个特殊值（ null或false ，具体取决于操作）
 *     <p>第三个程序将无限期地阻止当前线程，直到操作成功为止
 *     <p>第四个程序块在放弃之前只有给定的最大时限
 */
public class BlockingQueueDemo {
  public static void main(String[] args) throws InterruptedException {
    // 获取CPU核数量
    System.out.println(Runtime.getRuntime().availableProcessors());
    //    BlockingQueue queue = new ArrayBlockingQueue(3);
    //    queue3(queue);
  }

  /**
   * 抛出异常
   *
   * @param queue
   */
  private static void queue1(@NonNull BlockingQueue queue) {
    /** 在插入此队列的尾部，如果有可能立即这样做不超过该队列的容量，返回指定的元素 true成功时与抛出 IllegalStateException如果此队列已满 */
    System.out.println(queue.add("a"));
    System.out.println(queue.add("b"));
    System.out.println(queue.add("c"));
    /** System.out.println(queue.add("d")); */

    // 会抛异常的取值
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    /** System.out.println(queue.remove()); */
  }

  /**
   * 特殊值（ null或false ，具体取决于操作）
   *
   * @param queue
   */
  private static void queue2(@NonNull BlockingQueue queue) {
    /**
     * 存值
     *
     * <p>将指定的元素插入到此队列中，如果可以立即执行此操作，而不会违反容量限制， true在成功时 false如果当前没有可用空间，则返回false
     */
    System.out.println(queue.offer("a"));
    System.out.println(queue.offer("b"));
    System.out.println(queue.offer("c"));
    System.out.println(queue.offer("d"));

    /**
     * 取值
     *
     * <p>poll（） 检索并删除此队列的头，如果此队列为空，则返回 null
     */
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
  }

  /**
   * 阻塞，等待
   *
   * @param queue
   */
  private static void queue3(@NonNull BlockingQueue queue) throws InterruptedException {
    /**
     * 存值 put
     *
     * <p>在该队列的尾部插入指定的元素，如果队列已满，则等待空间变为可用
     */
    queue.put("a");
    queue.put("b");
    queue.put("c");

    /**
     * 取值 take
     *
     * <p>检索并删除此队列的头，如有必要，等待元素可用
     */
    System.out.println(queue.take());
    System.out.println(queue.take());
    System.out.println(queue.take());
  }
}
