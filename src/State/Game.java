package State;

import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private State state;
    private Character character;

    public Game(String characterName) {
        this.character = new Character(characterName);
        this.state = new NoviceLevel(this);
    }

    public int getUserChoice(String[] options) {
        System.out.println("\nSelect an option:");

        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i - 1]);
        }

        return this.scanner.nextInt();
    }

    public void play() {
        while (true) {
            if (this.state == null) {
                System.out.println("massive bug occurred");
                return;
            }

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
