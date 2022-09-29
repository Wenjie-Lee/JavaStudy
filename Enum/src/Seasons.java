/**
 * @author youzh
 * @version 1.0
 * @project JavaStudy
 * @description Enum
 * @date 2022/9/29 19:21:19
 */

public enum Seasons {
    SPRING, SUMMER, AUTUMN, WINTER;
}

// Enum 类型 继承至 java.lang.Enum<Seasons>
// Enum 是 final 的，不可被继承，且构造器是私有的，声明后就不可再更改
// Enum 下 有声明个数的 Seasons 类，都含有 static, final 不可更改对象
// Singleton是单例，Enum可以说是多例，

/*
Compiled from "Seasons.java"
public final class Seasons extends java.lang.Enum<Seasons> {
  public static final Seasons SPRING;
  public static final Seasons SUMMER;
  public static final Seasons AUTUMN;
  public static final Seasons WINTER;
  public static Seasons[] values();
  public static Seasons valueOf(java.lang.String);
  static {};
}
* */

//public class EnumTest {
//    public static void main(String[] args) {
//        enum a
//    }
//}
