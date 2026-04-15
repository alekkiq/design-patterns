package visitor;

import java.util.List;
import java.util.ArrayList;

public class Directory implements FileSystemElement {
    private String name;
    private final List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<FileSystemElement> getElements() {
        return this.elements;
    }

    public void addElement(FileSystemElement element) {
        this.elements.add(element);
    }

    public void printStructure(String indent) {
        System.out.println(indent + "Directory: " + this.name);
        for (FileSystemElement element : this.elements) {
            if (element instanceof Directory d) {
                d.printStructure(indent + "  ");
            } else if (element instanceof File f) {
                System.out.println(indent + "  File: " + f.getName() + " (" + f.getSizeMb() + " MB)");
            }
        }
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
