package com.example.demo.classes;

import java.lang.annotation.ElementType;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>获取Class对象
 *
 * @author : 许先生
 * @date : 2020-04-07 11:19
 */
public class Demo01 {
  public static void main(String[] args) {
    // 类名.class
    Class c1 = Object.class;
    // 通过实例获取Class
    Class c2 = new Object().getClass();
    // 一维数组的Class
    Class c3 = String[].class;
    // 二维数组的Class
    Class c4 = String[][].class;
    // 枚举 Class
    Class c5 = ElementType.class;
    // void Class
    Class c6 = void.class;
    // 基本数据类型 Class
    Class c7 = Integer.class;
    // 注解 Class
    Class c8 = Override.class;
    // 接口 Class
    Class c9 = Runnable.class;

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
    System.out.println(c5);
    System.out.println(c6);
    System.out.println(c7);
    System.out.println(c8);
    System.out.println(c9);
  }
}
