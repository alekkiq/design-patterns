package memento;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private long createdAt;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.createdAt = System.currentTimeMillis();
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return this.options.clone();
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    @Override
    public String toString() {
        return String.format("%tT | [%d,%d,%d] | selected=%s",
            this.createdAt,
            this.options[0],
            this.options[1],
            this.options[2],
            this.isSelected
        );
    }
}
