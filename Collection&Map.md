# Collection & Map

![Java Collection & Map 图解](https://img-blog.csdnimg.cn/aea318250cd14253ad071180a123544e.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YWx6aWu5LiA5p2v5peg,size_20,color_FFFFFF,t_70,g_se,x_16)


# Collection
> 注意`Collection`与`Collections`的区别
```java
import java.util.Collection;
import java.util.Collections;
```
> https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Collection.html

集合按照其存储结构可以分为两大类，分别是单列集合`java.util.Collection`和双列集合`java.util.Map`

### `java.util.Collection`接口
> Collection元素格式： [value1, value2, ...]

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
    - 冲突时，以链表存储所有冲突节点，长度>8时转换为红黑树
  - `TreeSet`，红黑树集合，数据类型有序、唯一储存，基于`TreeMap`实现
  - `LinkedHashSet`，通过双链表保存了数据的进入顺序，见`LinkedHashMap`
  - 等

## Map
```java
import java.util.Map;
```
> https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Map.html
> 
### `java.util.Map`接口
> Map元素格式： {key1=value1, key2=value2, ...}

- 相对于`Collection`只存储单列元素，`Map`是一种双列集合，每个元素包含两个数据；
- 每个元素的格式：Key=Value(键值对元素)；
- `Map`键无序、不重复、无索引、可为`null`
  - 不重复的实现是通过数据类型的`HashCode()`和`equals()`方法
### 遍历
- 通过键找值: 
  - `Set<T> keySet()`获取所有键的集合；`T get(Object key)`根据键获取值
- 转化为键值对`Set`集合:
  - `Set<Map.Entry<K,V> > entrySet()`转化为Set, `K getKey()`, `V getValue()`获取Entry键值对元素
- `Lambda`表达式:
  - `default void forEach(BiConsumer<? super K, ? super V> action)`
  - `BiConsumer`是接口
  - `myMap.forEach((k, v) -> code line here...)`

### `java.util.HashMap`
Map的哈希值实现
- 键无序、不重复、无索引、可为`null`
- 基于哈希表实现，增删查改的性能较好
  - `HashSet`基于此实现，只是不需要键，遍历时使用`internalMap.keySet().iterator()`
- 键的唯一依赖数据的`HashCode()`和`equals()`方法
- 键有冲突时，使用链表`Node`连接彼此；当链表节点数量超过`TREEIFY_THRESHOLD=8`时，`treeifyBin`转化为红黑树结构
### `java.util.LinkedHashMap extends HashMap`
记录节点进入顺序的HashMap
- 键**有序**、不重复、无索引、可为`null`
  - 此处的有序指的是保证键的存储和取出顺序一致,而不是对键排序
- 基于哈希表实现；通过一个双链表(doubly-linked)维护节点的进出顺序，最先进入的节点在表头
- LRUCache(Least recently used Cache, 最近最少使用缓存)用此实现
### `java.util.TreeMap extends AbstractMap`
这个才是对键进行排序的Map
- 键无序、不重复、无索引、可为`null`
- 默认按照键的数据的升序大小进行排序，也可自定排序规则，**仅对键数据排序**
  - `TreeMap(Comparator<? super K> comparator)`
- 

# 不可变集合
- 集合的数据项在创建时提供，之后的整个生命周期内，这个集合的所有数据项都不可更改
- 强行修改会抛出`java.lang.UnsupportedOperationException`

| 方法                                       | 说明              |
|------------------------------------------|-----------------|
| `static <E> List<E> of(..elements)`      | 创建一个具有指定数据的List |
| `static <E> Set<E> of(E..elements)`      | 创建一个具有指定数据的Set  |
| `static <K,V> Map<K， V> of(E..elements)` | 创建一个具有指定数据的Map  |
