package Composite;
import java.util.ArrayList;

public class Department implements IOrganizationUnit {
    private String name;
    private final ArrayList<IOrganizationUnit> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addChild(IOrganizationUnit child) {
        this.children.add(child);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getTotalSalary() {
        double totalSalary = 0;
        for (IOrganizationUnit child : this.children) {
            totalSalary += child.getTotalSalary();
        }
        return totalSalary;
    }

    @Override
    public void buildXml(StringBuilder string, String indent) {
        string
            .append(indent)
            .append("<department name=\"")
            .append(this.name)
            .append("\" totalSalary=\"")
            .append(this.getTotalSalary())
            .append("\">\n");

        for (IOrganizationUnit child : this.children) {
            child.buildXml(string, indent + "  ");
        }
        string.append(indent).append("</department>\n");
    }

    public void printInfo(String indent) {
        StringBuilder sb = new StringBuilder();
        this.buildXml(sb, indent);
        System.out.print(sb);
    }
}
