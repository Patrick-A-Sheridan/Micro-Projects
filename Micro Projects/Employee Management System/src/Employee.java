public class Employee {
    private String employeeName;
    private int employeeAge;
    private double employeeSalary;

    public Employee() {}
    
    public Employee(String name, int age, double salary) {
        setEmployeeName(name);
        setEmployeeAge(age);
        setEmployeeSalary(salary);
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public int getEmployeeAge() {
        return employeeAge;
    }
    public double getEmployeeSalary() {
        return employeeSalary;
    }
        
    public void setEmployeeName(String name) {
        this.employeeName = name;
    }
    public void setEmployeeAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        this.employeeAge = age;
    }
    public void setEmployeeSalary(double salary) {
                if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative!");
        }
        this.employeeSalary = salary;
    }
    
    public void printEmployeeInfo() {
        System.out.println(employeeName + " has an age of: " + employeeAge + " years old and a salary of $"
                + employeeSalary + " per hour.");

    }
    
}
