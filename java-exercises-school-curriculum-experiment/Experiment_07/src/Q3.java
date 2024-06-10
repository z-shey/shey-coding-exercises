/**
 * @Project_Name: java-school-curriculum-experiment
 * @Package_Name: PACKAGE_NAME
 * @File: Q3
 * @Version: 1.0.0
 * @Author: 榭壹Shey
 * @Created: 2023-11-26 17:45
 * @Last_Modified: 2023-11-26 17:45
 * @Description: No Description
 */


public class Q3 {
    public static void main(String[] args) {
        int[] array = new int[5];

        try {
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("请输入整数");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("请输入至少5个整数");
            return;
        }

        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
