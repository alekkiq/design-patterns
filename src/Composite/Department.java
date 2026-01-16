package Composite;
import java.util.ArrayList;

public class Department {
    private String name;

    private ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void getTotalSalary() {
        double totalSalary = 0;

        for (Employee employee : this.employees) {
            totalSalary += employee.getSalary();
        }

        for (Department department : this.departments) {
            department.getTotalSalary();
        }

        System.out.println("Total salary for department " + this.name + ": " + totalSalary);
    }

    private void buildXml(StringBuilder string, String indent) {
        string.append(indent).append("<department name=\"").append(this.name).append("\">\n");

        // print employees, if any
        if (!this.employees.isEmpty()) {
            string.append(indent).append(" <employees>\n");

            for (Employee employee : this.employees) {
                string.append(indent).append("  <employee name=\"").append(employee.getName())
                        .append("\" salary=\"").append(employee.getSalary()).append("\"/>\n");
            }

            string.append(indent).append(" </employees>\n");
        }

        // print child departments, if any
        if (!this.departments.isEmpty()) {
            string.append(indent).append(" <departments>\n");

            for (Department department : this.departments) {
                department.buildXml(string, indent + "  ");
            }

            string.append(indent).append(" </departments>\n");
        }

        string.append(indent).append("</department>\n");
    }

    public void printDepartmentInfo(String indent) {
        StringBuilder info = new StringBuilder();
        this.buildXml(info, indent);
        System.out.println(info);
    }
}
