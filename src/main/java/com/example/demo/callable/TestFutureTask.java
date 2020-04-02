package com.example.demo.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author 许海斌
 *
 * @create 2020/4/1 0001 21:42
 *     <p>FutureTask 细节
 *     <p>1. 在线程将结果给出来之前 get()会阻塞
 *     <p>2. 结果会被缓存，提高效率
 */
public class TestFutureTask {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    //
    FutureTask task = new FutureTask(new MyThread());
    new Thread(task).start();
    System.out.println(task.get().toString());
  }
}

class MyThread implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    System.out.println(Thread.currentThread().getName());
    return 12;
  }
}
