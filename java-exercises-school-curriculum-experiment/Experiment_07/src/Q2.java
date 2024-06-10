/**
 * @Project_Name: java-school-curriculum-experiment
 * @Package_Name: PACKAGE_NAME
 * @File: Q2
 * @Version: 1.0.0
 * @Author: 榭壹Shey
 * @Created: 2023-11-26 17:43
 * @Last_Modified: 2023-11-26 17:43
 * @Description: No Description
 */

import java.util.Random;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");

        try {
            int index = scanner.nextInt();

            if (index < 0 || index >= array.length) {
                throw new ArrayIndexOutOfBoundsException("out of bounds!");
            }

            System.out.println("Index data: " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
