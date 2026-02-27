package State;

public class ExpertLevel extends State {
    public ExpertLevel(Game game) { super(game); }

    public void action() {
        String[] options = {"Train to gain experience", "Meditate to gain more health", "Fight an enemy"};

        switch (this.getGame().getUserChoice(options)) {
            case 1:
                this.getGame().getCharacter().train();
                break;
            case 2:
                this.getGame().getCharacter().meditate();
                break;
            case 3:
                this.getGame().getCharacter().fight();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        if (this.getGame().getCharacter().getLevel() >= 4) {
            System.out.println("You leveled up to Master!");
            this.getGame().setState(new MasterLevel(this.getGame()));
        }
    }
}
