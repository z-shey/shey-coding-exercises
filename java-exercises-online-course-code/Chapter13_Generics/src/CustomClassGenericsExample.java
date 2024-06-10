import org.junit.Test;

class Order<T> {
    T t;
    int orderId;

    public Order() {
    }

    public Order(T t, int orderId) {
        this.t = t;
        this.orderId = orderId;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}

class subOrder1<T> extends Order<T> {

}

public class CustomClassGenericsExample {
    @Test
    public void Test() {
        Order order1 = new Order();
        Object object = order1.getT();

        Order<Integer> order2 = new Order<>();
        Integer t = order2.getT();
    }

    @Test
    public void Test3() {

    }
}
