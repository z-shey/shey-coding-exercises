import org.junit.Test;
import java.util.*;

class Teacher {
    private String name; // 教师姓名
    private double salary; // 教师薪水

    public Teacher() { // 无参构造方法
    }

    public Teacher(String name, double salary) { // 有参构造方法
        this.name = name;
        this.salary = salary;
    }

    public String getName() { // 获得教师姓名
        return name;
    }

    public void setName(String name) { // 设置教师姓名
        this.name = name;
    }

    public double getSalary() { // 获得教师薪水
        return salary;
    }

    public void setSalary(double salary) { // 设置薪水
        this.salary = salary;
    }

    @Override
    public String toString() { // 重写toString方法
        return "Teacher{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class MyComparer {
    public static int compareBySalary(Teacher t1, Teacher t2) { // 比较教师薪水
        return (int) (t1.getSalary() - t2.getSalary());
    }

    public int compareBySalaryDesc(Teacher t1, Teacher t2) { // 按照薪水降序排列
        return -(int) (t1.getSalary() - t2.getSalary());
    }
}

public class Q4 {
    @Test
    public void Q4Test() {
        List<Teacher> teacherList = new ArrayList<>(); // 创建教师列表
        teacherList.add(new Teacher("John", 3000)); // 添加教师对象
        teacherList.add(new Teacher("Tom", 3500));
        teacherList.add(new Teacher("Alice", 6000));
        teacherList.add(new Teacher("Lucy", 4000));

        Collections.sort(teacherList, new Comparator<Teacher>() { // 内部类 按照薪水升序排列
            @Override
            public int compare(Teacher t1, Teacher t2) {
                return MyComparer.compareBySalary(t1, t2);
            }
        });
        System.out.println("Ascending order"); // 打印升序排序的结果
        for (Teacher teacher : teacherList) { // 输出教师信息
            System.out.println(teacher);
        }

        Collections.sort(teacherList, new Comparator<Teacher>() { // 内部类 按照薪水降序排列
            @Override
            public int compare(Teacher t1, Teacher t2) {
                MyComparer myComparer = new MyComparer();
                return myComparer.compareBySalaryDesc(t1, t2);
            }
        });
        System.out.println("Descending order"); // 打印降序排序的结果
        for (Teacher teacher : teacherList) { // 输出教师信息
            System.out.println(teacher);
        }

        // Lambda expression
        Collections.sort(teacherList, (t1, t2) -> { // Lambda表达式 按照薪水升序排列
            return MyComparer.compareBySalary(t1, t2);
        });
        System.out.println("Ascending order");
        for (Teacher teacher : teacherList) { // 输出教师信息
            System.out.println(teacher);
        }

        Collections.sort(teacherList, (t1, t2) -> { // Lambda表达式 按照薪水降序排列
            MyComparer myComparer = new MyComparer();
            return myComparer.compareBySalaryDesc(t1, t2);
        });
        System.out.println("Descending order");
        for (Teacher teacher : teacherList) { // 输出教师信息
            System.out.println(teacher);
        }
    }
}
