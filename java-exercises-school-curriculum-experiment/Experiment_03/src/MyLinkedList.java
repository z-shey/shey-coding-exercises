/*
 * @FileName: null.java
 * @Description: null.java
 *
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Date: 2023-10-08 18:30
 */

public class MyLinkedList {
    private Node head;
    private int size;

    private class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
        } else {
            Node newNode = new Node(data);
            Node curr = getNode(index - 1);
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = getNode(index - 1);
            prev.next = prev.next.next;
        }
        size--;
    }


    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }
}

class testMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insert(0, 10); // [10]
        list.insert(1, 20); // [10, 20]
        list.insert(0, 15); // [10, 15, 20]

        list.remove(1); // [10, 20]
    }
}