/**
 * @Project_Name: java-school-curriculum-experiment
 * @Package_Name: PACKAGE_NAME
 * @File: Q4
 * @Version: 1.0.0
 * @Author: 榭壹Shey
 * @Created: 2023-11-26 17:49
 * @Last_Modified: 2023-11-26 17:49
 * @Description: No Description
 */


public class Q4 {
    public static void main(String[] args) {
        try {
            switch (args.length) {
                case 1 -> {
                    double side = Double.parseDouble(args[0]);
                    System.out.println("Area:" + side * side);
                }
                case 2 -> {
                    double length = Double.parseDouble(args[0]);
                    double width = Double.parseDouble(args[1]);
                    System.out.println("Area:" + length * width);
                }
                case 3 -> {
                    double a = Double.parseDouble(args[0]);
                    double b = Double.parseDouble(args[1]);
                    double c = Double.parseDouble(args[2]);
                    double s = (a + b + c) / 2.0;
                    double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                    System.out.println("Area:" + area);
                }
                default -> throw new IllegalArgumentException("Error!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please input");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
