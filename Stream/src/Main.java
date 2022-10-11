/**
 * @author youzh
 * @version 1.0
 * @project JavaStudy
 * @description a main class
 * @date 2022/10/11 23:11:25
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
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
        for (String s : nameList) {
            if (s.startsWith("小") && s.length() == 2) {
                System.out.println(s);
            }
        }
        // 利用Stream
        nameList.stream().filter(o -> o.startsWith("小") && o.length() == 2).forEach(System.out::println);

        String[] names = {"abc", "123", "张三"};
        Stream<String> nameStream1 = Arrays.stream(names);
        Stream<String> nameStream2 = Stream.of(names);
        nameStream1.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("小");
            }
        }).forEach(System.out::println);

        int[] a1 = new int[]{1};
        int[] a2 = new int[]{1};
        System.out.println(Arrays.equals(a1, a2));
    }
}
