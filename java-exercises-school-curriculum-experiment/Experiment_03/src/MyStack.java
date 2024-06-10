/*
 * @FileName: null.java
 * @Description: null.java
 *
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Date: 2023-10-08 19:28
 */

public class MyStack {
    private int[] data;
    private int size;

    public MyStack(int capacity) {
        data = new int[capacity];
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void push(int value) {
        if (size == data.length) {
            throw new RuntimeException();
        }
        data[size++] = value;
    }


    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return data[--size];
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return data[size - 1];
    }
}


class testMyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.size());

    }
}
