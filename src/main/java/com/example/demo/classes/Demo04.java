package com.example.demo.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>使用反射机制
 *
 * @author : 许先生
 * @date : 2020-04-07 15:59
 */
public class Demo04 {
  public static void main(String[] args) throws Exception {
    // 获取class对象
    Class<User> userClass = User.class;
    // 通过反射，获取构造器，创建对象实例
    Constructor<User> constructors = userClass.getConstructor(Integer.class, String.class);
    User user = constructors.newInstance(1, "haha");
    System.out.println(user);
    // 通过反射获取方法,
    Method setId = userClass.getDeclaredMethod("setId", Integer.class);
    setId.invoke(user, 11);
    System.out.println(user);
    // 通过反射获取field,并设置新值
    Field field = userClass.getDeclaredField("name");
    // 不能直接操作私有属性，需要操作时需要强制关闭Java权限检查，true 抑制Java语言访问检查,false 反之；
    field.setAccessible(true);
    field.set(user, "许先生");
    System.out.println(user);
  }
}

class User {
  private Integer id;
  private String name;

  public User(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
