package com.example.demo.functioninterface;

import java.util.function.Function;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>四大原生函数式接口 Demo
 *
 * @author : 许先生
 * @date : 2020-04-02 16:08
 */
public class FunctionInterfaceDemo {
  public static void main(String[] args) {
    System.out.println(function.apply("sss"));
  }

  static Function<String, String> function =
      (o) -> {
        return o;
      };
}
