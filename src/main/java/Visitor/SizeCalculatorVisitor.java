package Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSizeMb;

    public SizeCalculatorVisitor() {
        this.totalSizeMb = 0;
    }

    public double getTotalSizeMb() {
        return this.totalSizeMb;
    }

    @Override
    public void visit(File file) {
        this.totalSizeMb += file.getSizeMb();
    }

    @Override
    public void visit(Directory directory) {
        // The size of a directory is the sum of the sizes of its elements
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }
}
