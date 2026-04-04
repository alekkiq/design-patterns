package Builder;

public class Computer {
    private String processor;
    private String graphicsCard;
    private int ramSize;
    private String storage;
    private String operatingSystem;

    public Computer() {}

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computer Specifications:\n");
        sb.append("Processor: ").append(this.processor).append("\n");
        sb.append("Graphics Card: ").append(this.graphicsCard).append("\n");
        sb.append("RAM Size: ").append(this.ramSize).append(" GB\n");
        sb.append("Storage: ").append(this.storage).append("\n");
        sb.append("Operating System: ").append(this.operatingSystem).append("\n");
        return sb.toString();
    }
}
