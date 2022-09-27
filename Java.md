# Java Execute Principle

## 计算机能执行什么样的指令

- 二进制机器指令

## 高级编程语言？

- 使用人类自己的语言书写

## Java语言如何执行

- 编译器 javac -> 执行器 java

# JDK、JRE、Cross-Plaform

- JDK(Java Development Kit) 开发环境 
- JRE(Java Runtime Environment) 运行环境 | 核心类库 | JVM虚拟机 (Java Virtual Machine)
- JDK(javac编译.java -> java运行.class) -> JVM下运行 -> 调用Java库
- 不同系统下的不同的JVM虚拟机都可以运行.class

# Java Project Architecture

- project contains different modules
  - module contains different packages
    - package contains different class
      - class

# JavaBean
Java实体类，其对象可以在程序中封装实体数据

- 成员必须要使用 ```private``` 修饰
- 每个成员需有各自的 ```getter, setter```对应
- 必须提供一个无参```构造器```
```java
class MyClass {
    private int value;  // 私有成员变量
    
    public MyClass() {} // 必有无参构造器
    
    public int getValue() {             // getter
        return this.value;
    }
    public void setValue(int value) {   // setter
        this.value = value;
    }
}
```

# Java OOP 
Object Oriented Programming

- static 静态关键字
- singleton 单例，确保一个类只能存在一个实例对象
- inheritance 继承，Java支持多继承

## static
静态关键字，属于类，表示此成员内存中只有一份，在类加载的同时加载一次至**堆内存**，
所有此类任意实例都共享访问/修改
- 修饰变量，表示公用变量 `ClassName.staticVar`
- 修饰方法，表示通用工具方法  `ClassName.staticFunc()`

## Tool Class

```java
public class ToolClass {
    // 所有成员都为 static
    private ToolClass() {}  // 私有构造函数，使外部不能创建工具类实例对象
  
    /***
     * @Description: a static toString() method for int array 
     * @param array: input int[] array 
     * @Return: String
     * @Author: youzh
     * @Date: 2022/9/27 22:38
    */
    public static String toString(int[] array) {
        if (array == null) return "null";
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i == array.length - 1) {
              builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
```

