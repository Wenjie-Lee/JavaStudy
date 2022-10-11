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

## 日期相关
| 类名                 | 描述         |
|--------------------|------------|
| `Date`             | 日期时间       |
| `SimpleDateFormat` | 格式化工具      |
| `Calendar`         | 日历         |
| **JDK8新增**         | ---        |
| `LocalTime`        | 只包含时间      |
| `LocalDate`        | 只包含日期      |
| `LocalDateTime`    | 包含时间和日期    |
| `Instant`          | 时间戳        |
| `DateTimeFormat`   | 日期格式化工具    |
| `Duration`         | 计算两个“时间”间隔 |
| `Period`           | 计算两个“日期”间隔 |

## 关键字 `volatile` vs `Synchronized` vs 'static'
有关线程安全的几个特性：原子性、可见性、有序性

| 关键字            | 原子性 | 可见性 | 有序性 | 修饰变量 | 修饰方法 | 修饰类 |
|----------------|-----|-----|-----|------|------|-----|
 | `volatile`     | ×   | √   | √   | √    | ×    | ×   |
| `Synchronized` | √   | √   | √   | ×    | √    | √   |
| `static`       | ×   | ×   | √   | √    | √    | √   |

1. 可见性
   - 不可见通常是由于各进程读取资源后都放入各自的cache中，之后的读写都是对cache的操作，而cache对其他进程是不可见的
   - `Synchronized`，操作前后有加锁、释放锁，一个进程释放锁前会将资源的修改**写入内存**
   - `volatile`，强制各个进程从**内存中读**、**向内存中写**，跳过CPU cache，不会导致不可见
   - `static`，各个进程在处理此关键字修饰的变量时，都各自复制到进程内存里，各自的修改对其余进程不具有可见性
2. 原子性
   - `Synchronized`，在操作时必须获取资源的锁，直到执行完成才释放锁，保证了原子性
   - `volatile`，多线程时，只是保证写操作加锁，但每个线程都可能获取相同的值，造成写丢失值
   - `static`，无原子性
3. 有序性
   - 都保证有序性。由于数据依赖关系，即不能被编译器、处理器进行指令重排优化