public class Main {
    public static void main(String[] args) {
        Boxing box = new Boxing();

        System.out.println(box.getValue());
        box.setValue(0);
        box.setValue(1);
        System.out.println(box.getValue());
    }
}