package com.example.demo.functioninterface;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>测试题
 *
 * @author : 许先生
 * @date : 2020-04-02 16:47
 */
public class Demo01 {
  public static void main(String[] args) {
    /**
     * 满足下列规则，并只能用一行代码实现
     *
     * <p>1.用户ID是偶数
     *
     * <p>2.年龄大于23
     *
     * <p>3.用户名大写
     *
     * <p>4.倒序
     *
     * <p>5.只输出一个
     */
    User u1 = new User(1, 20, "aaa");
    User u2 = new User(2, 21, "bbb");
    User u3 = new User(3, 23, "ccc");
    User u4 = new User(4, 24, "ddd");
    User u5 = new User(6, 25, "eee");
    List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
    list.stream()
        .filter(u -> u.getId() % 2 == 0)
        .filter(u -> u.getAge() > 23)
        .map(u -> u.getName().toUpperCase())
        .sorted((uu1, uu2) -> uu1.compareTo(uu2))
        .limit(1)
        .forEach(System.out::println);
  }
}

class User {
  private Integer id;
  private Integer age;
  private String name;

  public User() {}

  public User(Integer id, Integer age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
