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

## interface
接口默认`public`，用于规范实现类，必须重写接口中声明的方法
- 同`abstract`一样不能创建实例对象
- JDK8之前，只能声明常量、抽象类
- JDK9，允许在接口中声明带方法体的方法
```java
public interface ImyInterface {
    // public static final 可省略，编译器会自动补上
    public static final double pai = 3.14;
    // public abstract 可省略
    public abstract int myFunc(int param);
    // default 
    default void defaultFunc(int param) {
        System.out.println("默认方法");
        privateFunc(3);
    }
    // public static 在子类中只能通过`ImyInterface.staticFunc`调用
    static void staticFunc(int param) {
      System.out.println("静态方法");
    }
    // private 只能在本接口内被其他默认方法、私有方法调用
    private void privateFunc(int param) {
      System.out.println("默认方法");
    }
}
```
接口是用来被实现的`implements`，实现类可理解为子类
- 一个类可以实现多个接口，多个接口冲突的方法可以直接被实现类重写
- 接口之间可以多继承，实现规范合并。多个接口存在规范冲突则不能被同时继承

## polymorphic
多态，指执行一个对象的方法，会有不同的表现
- 对于变量，统一指向父类中的同名变量，编译看声明，运行也与声明统一
- 对于方法，调用子类的不同实现，运行看实例对象
```java
abstract class Animal {         // 抽象父类
    String category = "animal";
    abstract void run();
}
class Dog extends Animal {
    String category = "dog";
    @Override
    public void run() {
      System.out.println(category + " run.");
    }
    public void bark() {
      System.out.println(category + " bark.");
    }
}
class Cat extends Animal {
    String category = "cat";
    @Override
    public void run() {
      System.out.println(category + " run.");
    }
    public void meow() {
      System.out.println(category + " meow.");
    }
}
class Test {
    public static void main(String[] args) {
        Animal a = new Dog();               // polymorphic state an Animal, but give a Dog
        System.out.println(a.category);     // animal
        a.run();                            // dog run.
        Anima b = new Cat();
        System.out.println(a.category);     // animal
        b.run();                            // cat run.

    }
}
```
多态实现中，只能调用父类的方法，不能调用子类独有的方法
```java
class Test {
    public static void main(String[] args) {
        Animal a = new Dog();  // auto type conversion
        Animal b = new Cat();
        // a.bark();     can`t work
        // b.meow();     can`t work
        Dog dog = (Dog)a;   // forced type conversion
        dog.bark();     // can work
        Cat cat = (Cat)b;
        cat.meow();     // can work
        // Dog catDog = (Dog) cat; cause ClassCastException 
    }
}
```

## anonymous class
匿名内部类
```java
class AnonymousClass {
    // Comparator<T> 在 = 右边创建了一个匿名类，我们不知道它的类签名是什么
    // 这个匿名类，是Comparator<T> 接口的实现类
    // 虽然没有名字，但在编译后会产生一个 AnonymousClass$1.class 的文件，1表示它是第一个匿名类
    // 这里实现了 Comparator<T> 的比较函数
    Comparator<T> comparator = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i).compareTo(o2.get(i)) > 0)
                    return 1;
                else if (o1.get(i).compareTo(o2.get(i)) < 0)
                    return -1;
            }
            return 0;
        }
    };
}
```

## lambda 表达式
lambda 表达式只能简化**函数式接口**的匿名内部类的写法
- 函数式接口，是一种仅有一个抽象方法的接口
- 对函数式接口，我们加上一个`@FunctionalInterface`注解，标记该接口必须满足函数式接口定义

```java
class LambdaExpression {
    public static void main(String[] args) {
        MyInterface i1 = new MyInterface() {    // notified as can be replaced by lambda
            @Override
            public void run() {
                System.out.println("a override interface run method");
            }
        };
        MyInterface i2 = () -> 
            System.out.println("a override interface run method using lambda");
    }
}
@FunctionalInterface
interface MyInterface { // a functional interface
    void run() {
        System.out.println("interface run method");
    }
}
```

## Regex
正则表达式
> https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/regex/Pattern.html
