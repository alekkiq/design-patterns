package State;

public class NoviceLevel extends State {
    public NoviceLevel(Game game) {
        super(game);
    }

    public void action() {
        String[] options = {"Train to gain experience"};

        switch (this.getGame().getUserChoice(options)) {
            case 1:
                this.getGame().getCharacter().train();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        if (this.getGame().getCharacter().getLevel() >= 2) {
            System.out.println("You leveled up to Intermediate.");
            this.getGame().setState(new IntermediateLevel(this.getGame()));
        }
    }
}
