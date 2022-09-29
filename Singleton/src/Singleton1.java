/**
 * @author youzh
 * @version 1.0
 * @project JavaStudy
 * @description 实现一个单例，实现按需创建，但不满足线程安全
 * @date 2022/9/29 14:38:03
 */
class Singleton1 {
    // 一个 static 单例声明
    // 为演示，使用public关键字
    public static Singleton1 singleton = null;
    // 私有构造函数
    private Singleton1() {}
    // getter setter
    public static Singleton1 getSingleton() {
        if (singleton == null) singleton = new Singleton1();
        return singleton;
    }
    public static void main(String[] args) {
        Singleton1 s11 = Singleton1.singleton;
        Singleton1 s12 = Singleton1.getSingleton();
        Singleton1 s13 = Singleton1.getSingleton();
        System.out.println(s11);    // 没有调用getSingleton时，没有创建实例
        System.out.println(s12);    // 需要实例时，按需创建实例
        System.out.println(s13);    // 且只创建一个实例
        System.out.println(s12 == s13);
    }
}
