/**
 * @author youzh
 * @version 1.3
 * @project JavaStudy
 * @description 实现一个单例，该方法在static代码块中一次创建一个对象，在判断没有实例时才加锁创建，没有实现按需创建
 * @date: 2022/9/29 14:53
 */
class Singleton3 {
    private static Singleton3 singleton3 = null;
    private static final Object syncObj = new Object();
    private Singleton3() {}

    public static Singleton3 getSingleton3() {
        if (singleton3 == null) {
            synchronized(syncObj) {
                if (singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}