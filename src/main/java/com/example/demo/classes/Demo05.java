package com.example.demo.classes;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 *
 * <h3>demo</h3>
 *
 * <p>反射获取参数泛型
 *
 * @author : 许先生
 * @date : 2020-04-07 16:37
 */
public class Demo05 {
  public void fun(Map<String, User> map, List<Integer> list) {
    System.out.println("fun2");
  }

  public Set<Object> fun() {
    System.out.println("fun2");
    return null;
  }

  public static void main(String[] args) throws Exception {
    Class<Demo05> aClass = Demo05.class;
    Method fun = aClass.getDeclaredMethod("fun", Map.class, List.class);
    Type[] genericParameterTypes = fun.getGenericParameterTypes();
    for (Type genericParameterType : genericParameterTypes) {
      System.out.println("=================");
      System.out.println(genericParameterType);
      if (genericParameterType instanceof ParameterizedType) {
        ParameterizedType parameterType = (ParameterizedType) genericParameterType;
        Type[] types = parameterType.getActualTypeArguments();
        for (Type type : types) {
          System.out.println(type);
        }
      }
    }
  }
}
