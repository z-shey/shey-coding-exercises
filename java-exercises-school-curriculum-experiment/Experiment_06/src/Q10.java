
/**
 * @Project_Name: Java programming course in school
 * @Package_Name: PACKAGE_NAME
 * @File:
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Created: 2023-10-28 14:35
 * @Last_Modified: 2023-10-28 14:35
 * @Description: No Description.
 */

import java.util.*;
public class Q10 {
    public static void main(String[] args) {
        Map<String, String> personMap = new HashMap<>();

        personMap.put("id", "1");
        personMap.put("name", "张三");
        personMap.put("sex", "男");
        personMap.put("age", "25");
        personMap.put("love", "爱学Java");

        for (Map.Entry<String, String> element : personMap.entrySet()) {
            System.out.println("Key: " + element.getKey() + ", Value: " + element.getValue());
        }

        System.out.println("Size: " + personMap.size());
        System.out.println("Delete value: " + personMap.remove("age"));
        System.out.println("Size: " + personMap.size());
    }
}
