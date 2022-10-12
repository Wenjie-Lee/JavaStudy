# Stream
> https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/stream/Stream.html
```java
import java.util.stream.Stream;
```

在Java 8中，得益于Lambda所带来的函数式编程，引入了一个全新的Stream流概念，用于简化集合和数组的API

```java
// 利用集合
for (String s : nameList) {
    if (s.startsWith("小") && s.length() == 2) {
        System.out.println(s);
    }
}
// 利用Stream
nameList.stream().filter(o -> o.startsWith("小") && o.length() == 2).forEach(System.out::println);
```

## Stream流使用方法
创建一个流水线，在流水线上使用`filter()`等中间方法，使用终结方法终结流
```java
// 数组类型
String[] names = {"abc", "123", "张三"};
// 获取Stream流
Stream<String> nameStream1 = Arrays.stream(names);
Stream<String> nameStream2 = Stream.of(names);
```

## Stream 常用方法

| 方法名                                                                     | 说明                                 |
|-------------------------------------------------------------------------|------------------------------------|
| `Stream<T> filter(Predicate<? super T> predicate)`                      | 对数据进行过滤                            |
| `Stream<T> limit(long maxSize)`                                         | 对数据长度进行限制                          |
| `Stream<T> skip(long n)`                                                | 跳过n个数据                             |
| `Stream<T> map(Function<? super K, ? extends T> mapper)`                | 返回应用所提供的方法后的Stream流                |
| `Stream<T> distinct()`                                                  | 使得数据唯一，依赖`equals()` & `hashCode()` |
| `static Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)` | **合并**两个Stream流，a和b应为T的子类          |

- What is `Predicate` ?
```java
import java.util.function.Predicate;
// interface Predicate<T>
nameStream1.filter(new Predicate<String>() {
    @Override
    public boolean test(String s) {
        return s.startsWith("小");
    }
}).forEach(System.out::println);
```

| 终结方法(Terminal operation)              | 说明                    |
|---------------------------------------|-----------------------|
| `forEach(Consumer<? super T> action)` | 遍历处理Stream流中数据项       |
| `count()`                             | 返回Stream流中数据项的个数      |
| `collect()`                           | 收集Stream流到Collection里 |
* `collect()`方法重载详情看
```java
import java.util.stream.Stream;
```


