public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 3, 9, 1};

        selectionSort(array);

        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    private static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
