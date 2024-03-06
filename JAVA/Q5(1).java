class Employee {
    private String name;
    private int empid;
    private double salary;
    public Employee() {
    }
    public Employee(String name, int empid, double salary) {
        this.name = name;
        this.empid = empid;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public double get_sal() {
        return salary;
    }
    public void set_sal(double salary) {
        this.salary = salary;
    }
    public void inc_sal(double percentage) {
        salary += salary * percentage / 100;
    }
}
class Manager extends Employee {
    private String dept;
    public Manager() {
    }
    public Manager(String name, int empid, double salary, String dept) {
        super(name, empid, salary);
        this.dept = dept;
    }
    public String getDepartment() {
        return dept;
    }
    public void setdept(String dept) {
        this.dept = dept;
    }
}
public class Q5 {
    public static void main(String[] args) {
        Employee employee = new Employee("A", 1001, 1000);
        Manager manager = new Manager("B", 1002, 1500, "Sales");
        System.out.println("Employee name: " + employee.getName());
        System.out.println("Employee salary: " + employee.get_sal());
        employee.inc_sal(10);
        System.out.println("Employee salary after increase: " + employee.get_sal());
        System.out.println("Manager name: " + manager.getName());
        System.out.println("Manager salary: " + manager.get_sal());
        System.out.println("Manager dept: " + manager.getDepartment());
    }
}


