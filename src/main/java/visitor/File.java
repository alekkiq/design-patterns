package visitor;

public class File implements FileSystemElement {
    private String name;
    private double sizeMb;

    public File(String name, double sizeMb) {
        this.name = name;
        this.sizeMb = sizeMb;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSizeMb() {
        return this.sizeMb;
    }

    public void setSizeMb(int sizeMb) {
        this.sizeMb = sizeMb;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
