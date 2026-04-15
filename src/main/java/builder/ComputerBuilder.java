package builder;

public interface ComputerBuilder {
    void buildProcessor();
    void buildGraphicsCard();
    void buildRAM();
    void buildStorage();
    void buildOperatingSystem();
    Computer getComputer();
}
