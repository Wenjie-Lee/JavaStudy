/***
 * @author youzh
 * @version 1.1
 * @project JavaStudy
 * @description 实现一个单例，该方法在static代码块中一次创建一个对象，使用了悲观锁，getter效率不高，没有实现按需创建
 * @date: 2022/9/29 14:44
 */
class Singleton2 {
    private static Singleton2 singleton2 = null;
    private static final Object syncObj = new Object();
    private Singleton2() {}
    public static Singleton2 getSingleton() {
        synchronized(syncObj) {
            if (singleton2 == null) {
                singleton2 = new Singleton2();
            }
        }
        return singleton2;
    }
}
