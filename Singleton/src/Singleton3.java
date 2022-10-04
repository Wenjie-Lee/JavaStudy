/**
 * @author youzh
 * @version 1.3
 * @project JavaStudy
 * @description 实现一个单例，该方法在static代码块中一次创建一个对象，在判断没有实例时才加锁创建，没有实现按需创建
 * @date: 2022/9/29 14:53
 */
class Singleton3 {
    private static volatile Singleton3 instance = null;
    private Singleton3() {}

    public static Singleton3 getInstance() {
        // DCL ,Double-Checked Locking
        if (instance == null) {
            synchronized (Singleton3.class) {
                // cus do not guarantee atomic
                // and 'singleton3 = new Singleton3();' is not a atomic operation, no data-dependency exists
                // instance should be volatile to prohibit the 'Instruction rearrangement'
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}