package Composite;

public class Main {
    public static void main(String[] args) {
        Department organization = new Department("Organization");

        Department hrDepartment = new Department("Human resources");
        hrDepartment.addChild(new Employee("Aleksi", 69000));
        hrDepartment.addChild(new Employee("Iskela", 67676));

        Department itDepartment = new Department("Information tech");
        itDepartment.addChild(new Employee("John", 5000));
        itDepartment.addChild(new Employee("Jane", 5000));

        Department webDepartment = new Department("Web development");
        webDepartment.addChild(new Employee("Matti", 60000));
        webDepartment.addChild(new Employee("Ulla", 60000));

        itDepartment.addChild(webDepartment);
        organization.addChild(hrDepartment);
        organization.addChild(itDepartment);

        organization.printInfo("");
    }
}
