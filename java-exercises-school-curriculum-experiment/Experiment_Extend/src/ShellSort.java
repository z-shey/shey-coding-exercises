public class ShellSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 3, 9, 1};

        shellSort(array);

        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    private static void shellSort(int[] array) {
        int n = array.length;
        for(int h = n / 2; h > 0; h /= 2) {
            for(int i = h; i < n; i++) {
                int temp = array[i];
                int j;
                for(j = i - h; j >= 0 && array[j] > temp; j -= h) {
                    array[j + h] = array[j];
                }
                array[j + h] = temp;
            }
        }
    }
}
