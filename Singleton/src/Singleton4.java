
/**
 * @author youzh
 * @version 1.4
 * @project JavaStudy
 * @description 实现一个单例，直接通过static关键字确保只创建一个实例，饿汉单例，没有实现按需创建
 * @date: 2022/9/29 15:01
 */
class Singleton4 {
    // 为演示，使用public关键字
    public static Singleton4 singleton4 = new Singleton4();
    private Singleton4() {}

    public static Singleton4 getSingleton4() {
        return singleton4;
    }

    public static void main(String[] args) {
        Singleton4 s41 = Singleton4.singleton4;
        Singleton4 s42 = Singleton4.getSingleton4();
        Singleton4 s43 = Singleton4.getSingleton4();
        System.out.println(s41);    // 类创建时就存在实例
        System.out.println(s42);    // 且只创建一个
        System.out.println(s43);    // 没有实现按需创建
        System.out.println(s41 == s42);
        System.out.println(s42 == s43);
    }
}