/**
 * @Project_Name: Java programming course in school
 * @Package_Name: PACKAGE_NAME
 * @File:
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Created: 2023-11-04 23:50
 * @Last_Modified: 2023-11-04 23:50
 * @Description: No Description.
 */

class DNode<T> {
    public T data;
    public DNode<T> prev;
    public DNode<T> next;

    public DNode(T data) {
        this.data = data;
    }
}

class DoubleLinkedList<T> {
    private int size;
    private DNode<T> head;
    private DNode<T> tail;

    public void insert(T value) {
        DNode<T> newNode = new DNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public T delete(T value) {
        DNode<T> current = head; // 从头结点开始遍历链表

        while (current != null) { // 当链表不为空时，继续遍历

            if (current.data.equals(value)) { // 如果当前结点包含要删除的值

                if (current == head) { // 如果当前结点是头结点
                    head = current.next; // 更新头结点为下一个结点

                    if (head != null) {
                        head.prev = null; // 如果新的头结点不为空，将其前驱置为null
                    } else {
                        tail = null; // 如果链表中只有一个结点，是要删除的结点，更新尾结点为null
                    }

                } else { // 如果当前结点不是头结点
                    current.prev.next = current.next; // 将当前结点前驱的next指向当前结点的后继

                    if (current != tail) { // 如果当前结点不是尾结点
                        current.next.prev = current.prev; // 将当前结点后继的prev指向当前结点的前驱
                    } else {
                        tail = current.prev; // 如果当前结点是尾结点，更新尾结点为当前结点的前驱
                    }
                }

                size--;
                return current.data;
            }

            current = current.next; // 继续遍历下一个结点
        }

        return null;
    }


    public boolean search(T value) {
        DNode<T> current = head;

        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void alter(int position, T value) {
        if (position < 0 || position > size) {
            throw new RuntimeException("Index out of range");
        }

        DNode<T> current = head;
        int count = 0;

        while (count < position - 1) {
            current = current.next;
            count++;
        }

        current.data = value;
    }

    public void print() {
        DNode<T> current = head;

        while (current != null) {
            System.out.print(" -> " + current.data);
            current = current.next;
        }

        System.out.println();
    }
}


public class Q2 {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.insert(5);
        doubleLinkedList.insert(6);
        doubleLinkedList.insert(58);
        doubleLinkedList.insert(30);
        doubleLinkedList.insert(7);
        System.out.println("DoubleLinkedList: ");
        doubleLinkedList.print();

        System.out.println("Delete: " + doubleLinkedList.delete(58));
        doubleLinkedList.print();

        System.out.println("Search 30: " + doubleLinkedList.search(30));

        System.out.println("Alter DoubleLinkedList: ");
        doubleLinkedList.alter(1, 9999);
        doubleLinkedList.print();
    }
}
