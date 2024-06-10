/*
 * @FileName: null.java
 * @Description: null.java
 *
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Date: 2023-10-08 18:27
 */

public class MyArrayList {
    private final int[] arr;  // 内部使用数组存储数据
    private int size;   // 数组当前元素个数

    public MyArrayList() {
        arr = new int[10];
        size = 0;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = value;
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int removedValue = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = 0;
        size--;
        return removedValue;
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        myArrayList.insert(0, 5);
        myArrayList.insert(1, 6);

        myArrayList.remove(1);
    }
}

