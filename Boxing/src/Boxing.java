public class Boxing {

    // 内部变量，外部不可访问
    private int value;
    public Boxing() {

    }

    // getter, setter 获取/修改value
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        if (value > 0) {
            this.value = value;
        }
        else {
            System.out.printf("value must > 0, but get %d\n", value);
        }
    }
}
