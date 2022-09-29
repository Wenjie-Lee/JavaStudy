/**
 * @author ${USER}
 * @version 1.0
 * @project ${PROJECT_NAME}
 * @description ${description}
 * @date ${DATE} ${HOUR}:${MINUTE}:${SECOND}
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "programming";
        String s2 = new String("programming");
        String s3 = "program";
        String s4 = "ming";
        String s5 = "program" + "ming";
        String s6 = s3 + s4;
        String s7 = new StringBuilder(s3).append(s4).toString();

        System.out.println(s1 == s2);   // false
        System.out.println(s1 == s5);   // true
        System.out.println(s1 == s6);   // false
        System.out.println(s6 == s7);   // false
        System.out.println(s1 == s6.intern());  // true
        System.out.println(s2 == s2.intern());  // false
    }
}