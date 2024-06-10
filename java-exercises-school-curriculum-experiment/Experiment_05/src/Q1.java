import org.junit.Test;

abstract class Employee {
    private String name;
    private String type;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public abstract double earnings(); //抽象方法
}

class RegularEmployee extends Employee {
    private int month;
    private double baseSalary = 5000.0;

    public RegularEmployee(String name, int month) {
        super(name);
        this.month = month;
    }

    @Override
    public double earnings() {
        return baseSalary * month;
    }
}

class TemporaryEmployee extends Employee {
    int week;
    double baseSalary = 1500.0;

    public TemporaryEmployee(String name, int week) {
        super(name);
        this.week = week;
    }

    @Override
    public double earnings() {
        return baseSalary * week;
    }
}

class Company {
    private final Employee[] employees; //Employee作为成员

    public Company() {
        employees = new Employee[7];

        employees[0] = new RegularEmployee("John T", 12);
        employees[1] = new RegularEmployee("Kate W", 12);
        employees[2] = new RegularEmployee("Kitty", 12);
        employees[3] = new RegularEmployee("Alice", 12);

        employees[4] = new TemporaryEmployee("Mike", 52);
        employees[5] = new TemporaryEmployee("Lisa", 52);
        employees[6] = new TemporaryEmployee("David", 52);
    }

    public double getTotalSalary() {
        double totalSalary = 0.0;

        for (Employee employee : employees) {
            totalSalary += employee.earnings();
        }

        return totalSalary;
    }
}

public class Q1 {
    @Test
    public void Q1Test() {
        Company company = new Company();
        System.out.println("Total: " + company.getTotalSalary());
    }
}
