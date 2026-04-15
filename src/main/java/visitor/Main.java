package visitor;

public class Main {
    public static void main(String[] args) {
        Directory dir = new Directory("directory");
        dir.addElement(new File("cv.pdf", 2));
        dir.addElement(new File("cat_video.mp4", 2048));
        Directory subDir = new Directory("secrets");
        subDir.addElement(new File("passwords.txt", 0.04));
        subDir.addElement(new File("perintäkirje.pdf", 1.5));
        dir.addElement(subDir);

        dir.printStructure("");

        // total size calc visitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        dir.accept(sizeVisitor);
        System.out.println("\nTotal size: " + sizeVisitor.getTotalSizeMb() + " mb");

        // search visitor for .pdf files
        SearchVisitor searchVisitor = new SearchVisitor(".pdf");
        dir.accept(searchVisitor);
        System.out.println("\nSearch results for '.pdf':\n" + searchVisitor.getResults());
    }
}
