package TemplateMethod;

public class Main {
    public static void main(String[] args) {
        int totalRounds = 5;
        int numberOfPlayers = 4;

        Game game = new HighCardGame(totalRounds);
        game.play(numberOfPlayers);
    }
}
