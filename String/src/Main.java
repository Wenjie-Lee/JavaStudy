
import java.lang.String;
import java.util.Objects;

public class Main {

    /*
    * https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/String.html
    *
    * See Also:
    * Object.toString() StringBuffer StringBuilder Charset
    * */

    public static void StringInstantiate() {
        // variety of constructors
        String s = new String();            // "", new String() instantiating in stack
        String str = "a string";            // ""创建后在 堆内存->常量池 中，不可更改
        String sameStr = "a string";
        System.out.println(str == sameStr); // true

        char[] data = {'x', 'y', 'z'};
        String str1 = new String(data);     // from char[]

        byte[] bytes = {1,2,3,4,5};
        String str2 = new String(bytes);    // from byte[]
    }

    public static void StringReference() {
        String str = "a string";
        String strCopy = new String(str);   // a newly initialized copy of str
        System.out.println(str.equals(strCopy));    // value compare true
        System.out.println(str == strCopy);         // address compare false

        String newStr = new String("123");  // 2, "str" in const, newStr a copy in stack
        String quoStr = "123";                      // 0, quoStr a reference to const
        System.out.println(newStr == quoStr);   // false

        String s1 = "abc";
        String s2 = "ab";
        String s3 = s2 + "c";
        System.out.println(s1 == s3);   // false
        /* see in Main.class file
         String var11 = "abc";
         String var12 = "ab";           // var12 is a reference
         String var13 = var12 + "c";
         due to the reference relationship established at runtime
        */

        String s4 = "abc";
        String s5 = "a" + "b" + "c";
        System.out.println(s4 == s5);   // true
        /* see in Main.class file
         String var14 = "abc";
         String var15 = "abc"; // original is "a" + "b" + "c"
         due to java compile optimizer
        */
    }

    public static void StringEqual() {
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1.equals(s2));   // true
        String s3 = new String("ABC");
        System.out.println(s1.equalsIgnoreCase(s3));   // true
    }

    public static void StringAPI() {
        String s1 = "abc";
        int len = s1.length();
        char kth = s1.charAt(2);
        char[] charArray = s1.toCharArray();
        String subS1 = s1.substring(0, 1);
        String newS1 = s1.replace('a', 'A');    // a new String
        boolean contains = s1.contains("a");
        String[] splited = s1.split("b");
    }

    public static void main(String[] args) {

        StringInstantiate();

        StringReference();

        StringEqual();


    }
}