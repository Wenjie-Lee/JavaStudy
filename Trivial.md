# Java 常量池

Java中存在常量池，其中保存一些常用的数据

### Class Pool
主要是.class文件中的 字面量 和 符号引用，每个.class都有一个
```java
// 字面量 Literal

// Byte,Short,Integer,Long,Character 是 primitive type 的封装类，用于实现对象操作
// 其中有一子类 <E>Cache 在常量池里维护了[-128, 127]的实例
// 所以对此范围的 <E> 创建都直接引用常量池中已存在的实例
Integer i1 = 10, i2 = 10, i3 = 200, i4 = 200;   
System.out.println(i1 == i2);   // true
System.out.println(i3 == i4);   // false

// 被声明为 final 的常量值
```
```java
// Symbolic references

// 类 和 接口 的完全限定名
// 字段名称和描述符（内存指针）
// 方法名称和描述符

```
### Runtime Pool
运行时常量池是方法区的一部分。jvm虚拟机在完成类装载操作后，将class文件中的常量池载入到内存中，
并保存在方法区中

![](https://img-blog.csdnimg.cn/6fecceb4f8f544d7ae587577132a0591.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASVRfX2xlYXJuaW5n,size_13,color_FFFFFF,t_70,g_se,x_16 "方法区")

### String Pool
JDK7 String常量池被单独移到 `堆` 中
```java
// String
String s1 = "aaa";
String s2 = "aaa";  // s1 == s2
// if 字符串常量池中存在"aaa"，则引用； else 在池中创建"aaa"对象，返回引用地址

String s3 = new String()"aaa";  // s3 != s1
// if 常量池中有"aaa"， 则直接在堆内存中复制一个对象，返回引用地址；否则先在池中创建，然后再在堆中复制创建一个

```

### String Operator +
> https://docs.oracle.com/javase/specs/jls/se19/html/jls-15.html#jls-15.18.1