package builder;

public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructComputer() {
        this.builder.buildProcessor();
        this.builder.buildGraphicsCard();
        this.builder.buildRAM();
        this.builder.buildStorage();
        this.builder.buildOperatingSystem();
    }
}
