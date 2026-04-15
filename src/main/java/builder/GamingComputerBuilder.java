package builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        this.computer.setProcessor("Ryzen 9 5900X");
    }

    @Override
    public void buildGraphicsCard() {
        this.computer.setGraphicsCard("NVIDIA GeForce RTX 4090");
    }

    @Override
    public void buildRAM() {
        this.computer.setRamSize(64);
    }

    @Override
    public void buildStorage() {
        this.computer.setStorage("2TB NVMe SSD");
    }

    @Override
    public void buildOperatingSystem() {
        this.computer.setOperatingSystem("Windows 11 Pro");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
