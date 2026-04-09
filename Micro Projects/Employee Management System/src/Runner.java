public class Runner {
    public static void main(String[] args) throws Exception {
        Employee employee1 = new Employee("Timmy", 17, 22);
        Employee employee2 = new Employee("Amanda", 32, 45);
        Employee employee3 = new Employee();

        employee3.setEmployeeName("Bob");
        employee3.setEmployeeAge(24);
        employee3.setEmployeeSalary(25);

        employee1.printEmployeeInfo();
        employee2.printEmployeeInfo();
        employee3.printEmployeeInfo();
    }

}
