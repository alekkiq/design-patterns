package Builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        this.computer.setProcessor("Intel Core i5-11400");
    }

    @Override
    public void buildGraphicsCard() {
        this.computer.setGraphicsCard("Integrated Intel UHD Graphics 730");
    }

    @Override
    public void buildRAM() {
        this.computer.setRamSize(16);
    }

    @Override
    public void buildStorage() {
        this.computer.setStorage("512GB SATA SSD");
    }

    @Override
    public void buildOperatingSystem() {
        this.computer.setOperatingSystem("Windows 11 Enterprise");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
