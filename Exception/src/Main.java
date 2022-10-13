/**
 * @author youzh
 * @version 1.0
 * @project JavaStudy
 * @description a main class
 * @date 2022/10/12 22:35:49
 */

/*
 * @author: youzh
 * @Date: 2022/10/12 22:35
 * @Version: 1.0
 */
public class Main {

    public static void throwException(String s) throws Exception {
        System.out.println("输出给定String的长度:");
        System.out.println(s.length());
    }

    public static void main(String[] args) {
        int[] a = new int[2];
        /* ArrayIndexOutOfBoundsException */
        try {
            a[3] = 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("get Exception: ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }
        /* ArithmeticException */
        try {
            System.out.println(3/0);
        } catch (ArithmeticException e) {
            System.out.println("get Exception: ArithmeticException");
            e.printStackTrace();
        }
        // 一般不需要指定异常类型
        try {
            System.out.println(3/0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // throws + try/catch
        String s = null;
        try {
            throwException(s);
        } catch (Exception e) {
            System.out.println("get Exception:");
            e.printStackTrace();
        } finally {
            System.out.println("若程序没有因Exception导致JVM退出，则能看到这一条");
        }
    }
}
