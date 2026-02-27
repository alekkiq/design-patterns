package State;

public class MasterLevel extends State {
    private boolean victoryAnnounced = false;

    public MasterLevel(Game game) {
        super(game);
    }

    @Override
    void action() {
        if (!this.victoryAnnounced) {
            System.out.println("You have reached the pinnacle level!");
            this.victoryAnnounced = true;
        }

        String[] options = {"Train to gain experience", "Meditate to gain more health", "Fight an enemy", "Exit game"};

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
            case 4:
                System.out.println("Exiting game. Thanks for playing!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
