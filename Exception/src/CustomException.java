/*
 * @author youzh
 * @version 1.0
 * @project JavaStudy
 * @description
 * @date 2022/10/13 14:51:07
 */

import java.util.Scanner;

/**
 * <p>继承 {@link Exception}，是编译时异常，需要在编码过程中去解决，会在编译器中提示
 * <p>继承 {@link RuntimeException}，是运行异常，不会在编译器中提示，不推荐
 *
 * @author youzh
 * @see java.lang.Exception
 * @see java.lang.RuntimeException
* */
public class CustomException extends Exception {
    public CustomException() {}

    public CustomException(String message) {
        super(message);
    }
}

class Test {
    public static boolean checkAge(int age) throws CustomException {
        if (age < 0 || age > 200) {
            throw new CustomException(age + " is illegal");
        } else {
            System.out.println("age is legal, please continue...");
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("请输入年龄：");
                String inStr = scanner.nextLine();
                int age = Integer.parseInt(inStr);  // NumberFormatException
                if (checkAge(age))                  // CustomException
                    break;
            } catch (Exception e) {                 // 也可以细分
                System.out.println("输入非法");
            }
        }
    }
}
