import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        double[] array = {0.46, 0.12, 0.83, 0.56, 0.29, 0.52, 0.97};

        bucketSort(array);

        for (double value : array) {
            System.out.print(value + " ");
        }
    }

    private static void bucketSort(double[] array) {
        int n = array.length;
        ArrayList<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (double value : array) {
            int bucketIndex = (int) (n * value);
            buckets[bucketIndex].add(value);
        }

        for (ArrayList<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (ArrayList<Double> bucket : buckets) {
            for (double value : bucket) {
                array[index++] = value;
            }
        }
    }
}
