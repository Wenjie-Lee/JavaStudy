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