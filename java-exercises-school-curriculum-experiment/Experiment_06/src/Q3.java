/**
 * @Project_Name: Java programming course in school
 * @Package_Name: PACKAGE_NAME
 * @File:
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Created: 2023-10-31 21:39
 * @Last_Modified: 2023-10-31 21:39
 * @Description: No Description.
 */

import java.util.*;

class SNode<T> {
    public T data;
    public SNode<T> next;

    public SNode(T data) {
        this.data = data;
    }
}

class GenericStack<T> {
    private SNode<T> top;

    public GenericStack() {
    }

    public void push(T data) {
        SNode<T> newNode = new SNode<>(data);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T getTop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}


public class Q3 {
    public static void main(String[] args) {
        GenericStack<Integer> sgenericStack = new GenericStack<>();

        sgenericStack.push(12);
        sgenericStack.push(55);
        sgenericStack.push(45);
        sgenericStack.push(65);
        System.out.println("Pop: " + sgenericStack.pop());
        System.out.println("Get top: " + sgenericStack.getTop());
        System.out.println("isEmpty: " + sgenericStack.isEmpty());
    }
}
