/**
 * @Project_Name: Java programming course in school
 * @Package_Name: PACKAGE_NAME
 * @File: Q1.java
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Created: 2023-10-26 19:44
 * @Last_Modified: 2023-10-27 20:34
 * @Description: The sixth experiment at school. This is a circular linked list class.
 */

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }

        tail.next = newNode;
        tail = newNode;

        tail.next = head;
    }

    public void delete(T data) {
        if (head == null) {
            return;
        }

        Node<T> curr = head;
        Node<T> prev = null;

        while (!curr.data.equals(data)) {
            if (curr.next == head) {
                throw new RuntimeException("Not Found!");
            }

            prev = curr;
            curr = curr.next;
        }

        if (curr == head) {
            head = head.next;
            tail.next = head;
        }

        if (curr == tail) {
            prev.next = head;
            tail = prev;
        }

        prev.next = curr.next;

        System.out.println("Deleted node data: " + data);
    }

    public void alter(int pos, T newData) {
        if (head == null) {
            throw new RuntimeException("Empty");
        }

        Node<T> curr = head;
        int count = 1;

        do {
            if (count == pos) {
                curr.data = newData;
                System.out.println("Pos " + pos + " update to " + newData);
                return;
            }
            curr = curr.next;
            count++;
        } while (curr != head);

        throw new RuntimeException("Not Found!");
    }


    public boolean search(T data) {
        if (head == null) {
            return false;
        }

        Node<T> curr = head;

        do {
            if (curr.data.equals(data)) {
                return true;
            }
            curr = curr.next;
        } while (curr != head);

        return false;
    }

    public void print() {
        if (head == null) {
            throw new RuntimeException("Linked List Empty!");
        }

        Node<T> curr = head;

        do {
            System.out.print(" -> " + curr.data);
            curr = curr.next;
        } while (curr != head);

        System.out.println();
    }
}

public class Q1 {
    public static void main(String[] args) {
        CircularLinkedList<Integer> circularList = new CircularLinkedList<>();

        circularList.insert(55);
        circularList.insert(66);
        circularList.insert(77);
        circularList.insert(88);
        circularList.print();

        circularList.delete(66);
        circularList.print();

        circularList.alter(2, 99);
        circularList.print();

        System.out.println("Search data 55: " + circularList.search(55));
        System.out.println("Search data 66: " + circularList.search(66));
    }
}
