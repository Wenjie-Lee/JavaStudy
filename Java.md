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
- inheritance 继承，Java不支持多继承

## static
静态关键字，属于类，表示此成员内存中只有一份，在类加载的同时加载一次至**堆内存**，
所有此类任意实例都共享访问/修改
- 修饰变量，表示所有此类的公用变量 `ClassName.staticVar`
- 修饰方法，表示通用工具方法  `ClassName.staticFunc()`
- 修饰类，表示静态类，在程序加载时加载一次，常用于创建工具类

### static 代码块
```java
class TestClass {
  public static String staticStr;

  static {
    System.out.println("static 代码块在类加载是加载一次");
    System.out.println("用于在程序加载时，初始化一些静态数据");
    staticStr = "初始化后";
  }

  {
    System.out.println("无static关键字，则表示构造代码块");
    System.out.println("在类实例对象加载时加载一次");
    System.out.println("且在构造器之前执行");
  }

  public static void main(String[] args) {
    System.out.println("在static 代码块后加载");
    System.out.println(staticStr);        // 输出：初始化后
  }
}
```

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

## final
`final` 关键字，表示最终，不可修改
- 修饰变量
  - 修饰实例变量，表示赋值后不再可更改，用的比较少
  - 修饰静态变量，表示一些类内共享的不可修改的常用常量值， 如 `final double pai = 3.14`
  - 修饰基本类型变量，表示赋值后不再可更改，如 `final int a = 1`
  - 修饰引用类型变量，表示指向的地址不可再修改，但地址指向的对象的值可以修改
  - String天生带有`final`，你认为的赋值、修改某个字符其实都创建了新的String
- 修饰方法，表示方法不可被重写 `override`
  - 修饰形参，表示形参不可在方法内被修改
- 修饰类，表示该类是最终类，不可被别的类继承 `extends`

## abstract
`abstract` 关键字，表示抽象。 与 `final` 关键字 互斥
- 修饰类，类只能被继承，本身不能实现
- 修饰方法，只有方法签名，不具体实现方法体
- 抽象类可以没有抽象方法，但子类继承抽象类后一定要重写所有抽象方法

## final & abstract
`final`， `abstract`共同用于构造抽象类，并为要继承抽象类的子类们提供一些方法，
- 有些方法用`abstract`修饰，表示该方法的具体实现由各个子类自己决定，
- 有些方法用`final`修饰，并给出方法体，表示这应该是子类们都要遵循的模板方法，且不能由子类随便修改
