package com.example.demo.classes;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>加载器
 *
 * @author : 许先生
 * @date : 2020-04-07 14:58
 */
public class Demo03 {
  public static void main(String[] args) {
    // 系统类加载器
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    // 扩展加载器
    ClassLoader parent = classLoader.getParent();
    // 根加载器 由 C/C++ 编写，加载java核心类库（rt.jat）,无法直接获取
    ClassLoader parent1 = parent.getParent();
    System.out.println(classLoader);
    System.out.println(parent);
    System.out.println(parent1);

    // 测试自己编写的类由那个加载器加载
    ClassLoader classLoader1 = Demo03.class.getClassLoader();
    System.out.println(classLoader1);
    // 测试JDK中的类由那个加载器加载
    ClassLoader classLoader2 = Object.class.getClassLoader();
    System.out.println(classLoader2);

    // 获得系统类加载器的加载路径有哪些
    System.out.println(System.getProperty("java.class.path"));
  }
}
