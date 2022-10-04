# Collection
```java
import java.util.Collection;
```
> https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Collection.html

集合按照其存储结构可以分为两大类，分别是单列集合`java.util.Collection`和双列集合`java.util.Map`

![Java Collection 图解](https://img-blog.csdnimg.cn/aea318250cd14253ad071180a123544e.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YWx6aWu5LiA5p2v5peg,size_20,color_FFFFFF,t_70,g_se,x_16)

### `java.util.Collection`

用于存储一系列符合某种规则的元素，它有两个重要的子接口：
- `java.util.List`，元素有序、元素可重复，元素有索引
  - `ArrayList`，元素以数组的形式在内存中连续储存，存在扩充数组操作，查询快，增删慢
  - `LinkedList`，元素以双链表形式在内存中分散存储，查询慢，增删首元素快
  - `thread-safe`:`ArrayList`对应`Vector`(legacy),`CopyOnWriteArrayList`(preferred)
    - `Vector`为了线程安全，读写操作都有`synchronized`关键字，性能较差；且扩容操作`grow()`默认容量翻倍
    - `CopyOnWriteArrayList`，读操作是不需要加锁的，写删时通过COW(CopyOnWrite)使得其他线程保存的缓存失效，实现线程安全；扩容操作`grow()`默认容量+1
    - > `volatile`关键字对比`synchronized` [Trivial.md](D:\JAVA\JavaStudy\Trivial.md) &&  https://www.cnblogs.com/zhongqifeng/p/14684028.html
  - 等
- `java.util.Set`，元素无序，而且不可重复，元素无索引
  - `HashSet`，哈希集合，无序、唯一储存，基于`HashTable`(`HashMap`)实现
  - `TreeSet`，红黑树集合，有序、唯一储存，基于`TreeMap`实现
  - 等