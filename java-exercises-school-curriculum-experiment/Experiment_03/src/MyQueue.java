/*
 * @FileName: null.java
 * @Description: null.java
 *
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Date: 2023-10-08 19:32
 */

public class MyQueue {
    private int[] data;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        data = new int[capacity];
        front = 0;
        rear = -1;
    }


    public boolean isEmpty() {
        return rear < front;
    }


    public int size() {
        return rear - front + 1;
    }


    public void enqueue(int value) {
        if (rear == data.length - 1) {
            throw new RuntimeException();
        }
        data[++rear] = value;
    }


    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return data[front++];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return data[front];
    }
}


class testMyQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.peek());
        System.out.println(queue.size());
        queue.dequeue();
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
