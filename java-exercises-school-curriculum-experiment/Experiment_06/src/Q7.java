
/**
 * @Project_Name: Java programming course in school
 * @Package_Name: PACKAGE_NAME
 * @File:
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Created: 2023-10-28 13:12
 * @Last_Modified: 2023-10-28 13:12
 * @Description: No Description.
 */

import java.util.*;
public class Q7 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("马六");
        names.add("赵七");

        int index = 0;
        for (String element : names) {
            System.out.print("[" + index++ + "]"+ element + "\t");
        }
        System.out.println();
        System.out.println("Size: " + names.size());
        System.out.println("Remove: " + names.remove(2));
        System.out.println("Index 2: " + names.get(2));
        System.out.println("Size: " + names.size());
    }
}

