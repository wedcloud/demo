package com.example.demo.classes;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>分析类的初始化
 *
 * @author : 许先生
 * @date : 2020-04-07 14:10
 */
public class Demo02 {
  public static void main(String[] args) throws ClassNotFoundException {

    /**
     * 类的主动引用，一定会引发类的初始化；根据java虚拟机规范，所有java虚拟机实现必须在每个类或接口被java程序首次主动使用时才初始化
     *
     * <p>1、实例化（类的主动引用）， 类会初始化 : Son son = new Son();
     *
     * <p>2、访问某个类或者接口的静态变量，或者对该静态变量赋值（final修饰的常量不会导致类的初始化）： System.out.println(Son.M);
     *
     * <p>3、调用类的静态方法或静态成员 ： System.out.println(Son.m);
     *
     * <p>4、反射（Class.forName(xxx.xxx.xxx)）
     *
     * <p>5、初始化一个类的子类（相当于对父类的主动使用）
     *
     * <p>6、Java虚拟机被标明为启动类的类（包含main方法的）
     *
     * <p>
     */
    Class aClass = Class.forName("com.example.demo.classes.Son");

    /**
     * 类的被动引用不会引发类的初始化
     *
     * <p>1、通过数组定义类引用，不会触发类初始化 ： Son[] arr = new Son[2];
     *
     * <p>2、引用final常量，不会引发类的初始化
     *
     * <p>3、直接通过子类引用父类元素，不会引起子类的初始化 ： System.out.println(Son.b);
     *
     * <p>4、使用 类.class,创建Class对象的应用时，不会自动初始化该Class对象 ： Class aclass = Son.class
     */
    Son[] arr = new Son[2];
  }

  static {
    System.out.println("Main 加载");
  }
}

class Father {
  static int b = 1;

  static {
    System.out.println("Father 加载");
  }
}

class Son extends Father {
  static int m = 2;

  static {
    System.out.println("Son 加载");
  }

  static final int M = 3;
}
