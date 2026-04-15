package visitor;

public class SearchVisitor implements FileSystemVisitor {
    private String searchTerm;
    private StringBuilder results;

    public SearchVisitor(String searchTerm) {
        this.searchTerm = searchTerm;
        this.results = new StringBuilder();
    }

    public String getResults() {
        return this.results.toString();
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(this.searchTerm)) {
            this.results.append("Found file: ").append(file.getName()).append("\n");
        }
    }

    @Override
    public void visit(Directory directory) {
        if (directory.getName().contains(this.searchTerm)) {
            this.results.append("Found directory: ").append(directory.getName()).append("\n");
        }
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }
}
