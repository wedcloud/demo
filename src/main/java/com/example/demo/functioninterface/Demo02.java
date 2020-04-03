package com.example.demo.functioninterface;

import java.util.function.Function;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>函数式接口
 *
 * @author : 许先生
 * @date : 2020-04-03 09:19
 */
public class Demo02 {
  public static void main(String[] args) {
    Function<String, Integer> toInteger = Integer::valueOf;
    Function<String, String> backToString = toInteger.andThen(String::valueOf);
  }
}
