package Composite;

public class Main {
    public static void main(String[] args) {
        Department organization = new Department("Organization");

        Department hrDepartment = new Department("Human resources");
        hrDepartment.addEmployee(new Employee("Aleksi", 69000));
        hrDepartment.addEmployee(new Employee("Iskela", 67676));

        Department itDepartment = new Department("Information tech");
        itDepartment.addEmployee(new Employee("John", 5000));
        itDepartment.addEmployee(new Employee("Jane", 5000));

        Department webDepartment = new Department("Web development");
        webDepartment.addEmployee(new Employee("Matti", 60000));
        webDepartment.addEmployee(new Employee("Ulla", 60000));

        itDepartment.addDepartment(webDepartment);
        organization.addDepartment(hrDepartment);
        organization.addDepartment(itDepartment);

        organization.printDepartmentInfo("");
    }
}
