package State;

import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private State state;
    private Character character;

    public Game() {
        this.character = new Character();
        this.state = new NoviceLevel(this);
    }

    public int getUserChoice(String[] options) {
        System.out.println("\nSelect an option:");

        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i - 1]);
        }

        return scanner.nextInt();
    }

    public void play() {
        System.out.println("Enter your character's name:");
        String characterName = scanner.nextLine();
        this.character.setName(characterName);
        System.out.println("\n");

        while (true) {
            if (this.state == null) {
                System.out.println("massive bug occurred");
                return;
            }
            System.out.println("\n");
            System.out.println(this.character.toString());
            this.state.action();
        }
    }

    public State getState() {
        return this.state;
    }

    public void setState(State s) {
        this.state = s;
    }

    public Character getCharacter() {
        return this.character;
    }

    public void setCharacter(Character c) {
        this.character = c;
    }

}
