/**
 * @Project_Name: Default (Template) Project
 * @Package_Name:
 * @File: ${NAME}
 * @Version: 1.0.0
 * @Author: 榭壹Shey
 * @Created: 2023-11-26 17:39
 * @Last_Modified: 2023-11-26 17:39
 * @Description: No Description
 */


import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input numbers: ");

        try {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            if (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100) {
                throw new OutOfRangeException("Not in range!");
            }

            int sum = num1 + num2;
            System.out.println("Sum: " + sum);
        } catch (OutOfRangeException e) {
            e.printStackTrace();
        }
    }
}

class OutOfRangeException extends Exception {
    public OutOfRangeException(String message) {
        super(message);
    }
}
