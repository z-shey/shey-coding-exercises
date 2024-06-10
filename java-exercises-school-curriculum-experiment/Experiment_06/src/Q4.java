import java.util.*;

class CircularQueue<T> {
    public static final int DEFAULT_CAPACITY = 1024; // 默认环形队列的容量，默认1024个元素
    private int head; // 队头
    private int tail; // 队尾
    private final int capacity; // 队列容量
    private final List<T> elements; // 队列元素列表

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularQueue(int capacity) {
        head = 0;
        tail = 0;
        this.capacity = capacity;
        elements = new ArrayList<>(capacity);
    }

    private boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    // 入队
    public void enqueue(T data) {
        if (isFull()) {
            return;
        }
        elements.add(tail, data);

        tail = (tail + 1) % capacity;
    }

    // 出队
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T data = elements.get(head);

        elements.set(head, null);

        head = (head + 1) % capacity;

        return data;
    }

    public T getHead() {
        if (isEmpty()) {
            return null;
        }

        return elements.get(head);
    }

    public int getSize() {
        return (tail - head + capacity) % capacity;
    }
}

public class Q4 {
    public static void main(String[] args) {
        CircularQueue<String> strQueue = new CircularQueue<>();

        for (String data : new String[]{"Alice", "Tom", "Jim", "John"}) {
            strQueue.enqueue(data);
        }

        System.out.println("Size:" + strQueue.getSize());
        System.out.println("Get head: " + strQueue.getHead());

        System.out.println("Dequeue: " + strQueue.dequeue());
        System.out.println("Size:" + strQueue.getSize());
        System.out.println("Get head after dequeue: " + strQueue.getHead());

        System.out.println("isEmpty: " + strQueue.isEmpty());
    }
}
