package Composite;

public class Employee implements IOrganizationUnit {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getTotalSalary() {
        return this.salary;
    }

    @Override
    public void buildXml(StringBuilder sb, String indent) {
        sb.append(indent)
            .append("<employee name=\"")
            .append(this.name)
            .append("\" salary=\"")
            .append(this.salary)
            .append("\"/>\n");
    }
}
