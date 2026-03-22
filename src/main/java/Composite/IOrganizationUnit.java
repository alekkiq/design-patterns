package Composite;

public interface IOrganizationUnit {
    double getTotalSalary();
    void buildXml(StringBuilder sb, String indent);
    String getName();
}
