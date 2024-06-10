/*
 * @FileName: null.java
 * @Description: null.java
 *
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Date: 2023-10-08 20:09
 */

public class SortingAlgorithms {
    public void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        quickSortHelper(nums, 0, nums.length - 1);
    }

    private void quickSortHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(nums, start, end);

        quickSortHelper(nums, start, pivot - 1);
        quickSortHelper(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, end);

        return i + 1;
    }

    public void shellSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = nums[i];

                int j = i;

                while (j >= gap && nums[j - gap] > temp) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class SortTest {
    public static void main(String[] args) {
        int[] nums = {6, 5, 3, 8, 1, 9, 2, 4, 7};

        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

        // 快速排序
        sortingAlgorithms.quickSort(nums);
        System.out.println("快速排序结果：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 希尔排序
        int[] nums2 = {6, 5, 3, 8, 1, 9, 2, 4, 7};
        sortingAlgorithms.shellSort(nums2);
        System.out.println("希尔排序结果：");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
