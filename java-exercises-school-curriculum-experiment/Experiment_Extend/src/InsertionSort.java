public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 9, 1};

        insertionSort(arr);

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
