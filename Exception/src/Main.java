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



    public static void main(String[] args) {
        int[] a = new int[2];
        /* ArrayIndexOutOfBoundsException */
        try {
            a[3] = 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("get Exception: ArrayIndexOutOfBoundsException");
        }
        /* ArithmeticException */
        try {
            System.out.println(3/0);
        } catch (ArithmeticException e) {
            System.out.println("get Exception: ArithmeticException");
        }
    }
}
