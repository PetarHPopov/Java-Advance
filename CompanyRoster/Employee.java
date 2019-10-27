package CompanyRoster;

public class Employee {
    private final static String UNDEFINED_VALUE_STRING = "n/a";
    private final static int UNDEFINED_VALUE_INT = -1;
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, Integer age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email != null ? email : UNDEFINED_VALUE_STRING;
        this.age = age != null ? age : UNDEFINED_VALUE_INT;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
