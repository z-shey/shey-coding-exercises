public class CountingSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 3, 9, 1};

        countingSort(array);

        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    private static void countingSort(int[] array) {
        int max = getMaxValue(array);
        int[] countArray = new int[max + 1];

        for (int value : array) {
            countArray[value]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countArray[i] > 0) {
                array[index++] = i;
                countArray[i]--;
            }
        }
    }

    private static int getMaxValue(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
