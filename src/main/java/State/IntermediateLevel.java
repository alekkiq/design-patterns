package State;

public class IntermediateLevel extends State {
    public IntermediateLevel(Game game) { super(game); }

    public void action() {
        String[] options = {"Train to gain experience", "Meditate to gain more health"};

        switch (this.getGame().getUserChoice(options)) {
            case 1:
                this.getGame().getCharacter().train();
                break;
            case 2:
                this.getGame().getCharacter().meditate();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        if (this.getGame().getCharacter().getLevel() >= 3) {
            System.out.println("You leveled up to Expert!");
            this.getGame().setState(new ExpertLevel(this.getGame()));
        }
    }
}
