package com.example.demo.classes;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>获取注解信息
 *
 * @author : 许先生
 * @date : 2020-04-07 17:02
 */
public class Demo06 {
  public static void main(String[] args) throws Exception {
    Class<Dao> aClass = Dao.class;
    // 获取类上的所有注解
    Annotation[] annotations = aClass.getAnnotations();
    for (Annotation annotation : annotations) {
      System.out.println(annotation);
    }
    // 获取指定注解的值
    Table table = aClass.getDeclaredAnnotation(Table.class);
    System.out.println(table.value());
    // 获取字段上的注解
    java.lang.reflect.Field id = aClass.getDeclaredField("id");
    Annotation[] idAnnotations = id.getAnnotations();
    for (Annotation idAnnotation : idAnnotations) {
      System.out.println(idAnnotation);
    }
    // 获得指定字段的注解的值
    Field field = id.getAnnotation(Field.class);
    System.out.println(field.column());
    System.out.println(field.type());
    System.out.println("==================");

    // 获取静态方法
    Method[] methods = aClass.getDeclaredMethods();
    for (Method method : methods) {
      System.out.println(method);
    }
  }
}

@Table("db_dao")
class Dao {
  @Field(column = "学号", type = "int")
  private Integer id;

  @Field(column = "姓名", type = "varchar")
  private String name;

  @Override
  public String toString() {
    return "Dao{" + "id=" + id + ", name='" + name + '\'' + '}';
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

  public static void abc() {
    System.out.println("静态方法");
  }

  static {
    System.out.println("静态代码块");
  }
}

/** @author User */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
  String value();
}

/** @author User */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field {
  String column();

  String type();
}
