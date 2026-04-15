package builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder builder = new OfficeComputerBuilder();
        ComputerDirector director = new ComputerDirector(builder);

        director.constructComputer();
        Computer computer = builder.getComputer();

        System.out.println(computer);
    }
}
