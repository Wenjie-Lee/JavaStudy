/**
 * @author youzh
 * @version 1.0
 * @project JavaStudy
 * @description a main class
 * @date 2022/10/11 23:11:25
 */
import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @author: youzh
 * @Date: 2022/10/11 23:11
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("小明");
        nameList.add("小红红");
        nameList.add("大黑");
        // 利用集合
        System.out.println("传统Collection方法");
        for (String s : nameList) {
            if (s.startsWith("小") && s.length() == 2) {
                System.out.println(s);
            }
        }
        System.out.println();

        // 利用Stream
        System.out.println("利用Stream流");
        nameList.stream().filter(o -> o.startsWith("小") && o.length() == 2).forEach(System.out::println);
        System.out.println();

        String[] names = {"abc", "abcd","123", "张三"};
        Stream<String> nameStream1 = Arrays.stream(names);
        // Stream<String> nameStream2 = Stream.of(names);
        nameStream1.filter(s -> s.startsWith("a")).forEach(System.out::println);
        System.out.println("此时nameStream1生命周期已经结束，后续不能再用。再用只能再创建一个");
        System.out.println();

        // Stream map()
        List<Character> list = new ArrayList<>();
        list.add('d');
        list.add('c');
        list.add('a');
        list.add('b');
        list.add('a');
        list.forEach(o -> System.out.printf("%s, %s\n", o, o.getClass().getTypeName()));
        list.stream().map(String::valueOf).forEach(o -> System.out.printf("%s, %s\n", o, o.getClass().getTypeName()));

        // Stream 收集
        Map<Character, List<Character>> groupMap = list.stream().collect(Collectors.groupingBy(Character::charValue));
        System.out.println("collect after grouping in Map<Character, List<Character>>");
        groupMap.forEach((o1, o2) -> System.out.printf("\t%c: %s[%s]\n", o1, o2.toString(), o2.getClass().getTypeName()));

        System.out.println("to List:");
        List<String> collected = list.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.print("\t");
        collected.add("++此方法可以添加元素");
        collected.forEach(System.out::print);

        List<String> collect2 = list.stream().map(String::valueOf).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.print("\n\t");
        collect2.add("++此方法也可以添加元素");
        collect2.forEach(System.out::print);

        List<String> collect3 = list.stream().map(String::valueOf).toList(); // return a UnmodifiableList
        System.out.print("\t");
        collect3.forEach(o -> System.out.printf("%s", o));
        System.out.println("\n\tstream().toList()返回的是一个 'UnmodifiableList' 不可更改");

        Stream<String> s2 = list.stream().map(String::valueOf);
        System.out.println("to Set:");
        Set<String> collectToSet = s2.collect(Collectors.toSet());
        collectToSet.forEach(o -> System.out.printf("\t%s", 0));

        Stream<String> s3 = list.stream().map(String::valueOf);
        System.out.println("to String:");
        String collectToString = s3.collect(
                StringBuilder::new, StringBuilder::append, StringBuilder::append
        ).toString();
        System.out.println("\t" + collectToString);

        // toArray
        // String[] strings = stringStream.toArray(new IntFunction<String[]>() {
        //     @Override
        //     public String[] apply(int value) {
        //         return new String[value];
        //     }
        // });
        // String[] strings = stringStream.toArray(value -> new String[value]);
        Stream<String> s4 = list.stream().map(String::valueOf);
        String[] strings = s4.toArray(String[]::new);
        System.out.println("to String[]:");
        System.out.println("\t" + Arrays.toString(strings));

    }
}
