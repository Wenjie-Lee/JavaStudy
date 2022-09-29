/**
 * @author youzh
 * @version 1.5
 * @project JavaStudy
 * @description 实现一个单例，直接通过static关键字确保只创建一个实例，在调用Nested时实现按需创建
 * @date: 2022/9/29 15:03
 */
class Singleton5 {
    private Singleton5() {}
    public static Singleton5 getSingleton5() {
        return Nested.singleton5;
    }
    // Nested Class
    static class Nested {
        Nested() {}
        static final Singleton5 singleton5 = new Singleton5();
    }
}