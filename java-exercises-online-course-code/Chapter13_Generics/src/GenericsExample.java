import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee -> " +
                "name: '" + name + '\'' +
                ", age: " + age +
                ", birthday: " + birthday;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }

    @Override
    public int compareTo(MyDate o) {
        int yearInstance = this.getYear() - o.getYear();

        if (yearInstance != 0) {
            return yearInstance;
        }

        int monthInstance = this.getMonth() - o.getMonth();
        if (monthInstance != 0) {
            return monthInstance;
        }

        return this.getDay() - o.getDay();
    }
}

public class GenericsExample {
    @Test
    public void Test() {

        TreeSet<Employee> set = new TreeSet<>();

        Employee employee1 = new Employee("John", 20, new MyDate(2003, 10, 5));
        Employee employee2 = new Employee("Tom", 15, new MyDate(2009, 11, 25));
        Employee employee3 = new Employee("Alice", 14, new MyDate(2005, 9, 15));

        set.add(employee1);
        set.add(employee2);
        set.add(employee3);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            System.out.println(next.toString());
        }

    }


    @Test
    public void Test2() {
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
//                int yearInstance = o1.getBirthday().getYear() - o2.getBirthday().getYear();
//
//                if (yearInstance != 0) {
//                    return yearInstance;
//                }
//
//                int monthInstance = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
//                if (monthInstance != 0) {
//                    return monthInstance;
//                }
//
//                return o1.getBirthday().getDay() - o2.getBirthday().getDay();


                return o1.getBirthday().compareTo(o2.getBirthday());
            }

        };



        TreeSet<Employee> set = new TreeSet<>(comparator);

        Employee employee1 = new Employee("John", 20, new MyDate(2003, 12, 5));
        Employee employee2 = new Employee("Tom", 15, new MyDate(2003, 11, 5));
        Employee employee3 = new Employee("Alice", 14, new MyDate(2005, 9, 15));

        set.add(employee1);
        set.add(employee2);
        set.add(employee3);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            System.out.println(next.toString());
        }
    }

}