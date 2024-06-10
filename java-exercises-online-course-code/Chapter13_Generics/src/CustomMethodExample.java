import org.junit.Test;
class CustomMethod {
    public static <T> T genericMethod(T[] array) {
        if (array.length > 0) {
            return array[0];
        }

        return null;
    }
}


class GenericMethodDemo<T> {

    private T value;

    public  GenericMethodDemo(T value) {
        this.value = value;
    }

    public static <T> void staticMethod(T item) {
        System.out.println("Static Method: " + item.toString());
    }

    public void instanceMethod() {
        System.out.println("Instance Method: " + value.toString());
    }

    public static void main(String[] args) {
        GenericMethodDemo<String> demo1 = new GenericMethodDemo<>("Hello");
        GenericMethodDemo<Integer> demo2 = new GenericMethodDemo<>(123);

        staticMethod("Static"); // 静态方法使用 String 类型的参数
        staticMethod(456); // 静态方法使用 Integer 类型的参数

        demo1.instanceMethod(); // 实例方法使用 String 类型的成员变量
        demo2.instanceMethod(); // 实例方法使用 Integer 类型的成员变量
    }
}


public class CustomMethodExample {
    @Test
    public void Test() {
        Integer[] intArray = { 1, 2, 3, 4, 5 };

        Integer i = CustomMethod.genericMethod(intArray);

        System.out.println("First Integer: " + i);
    }
}
