package TemplateMethod;

public class HighCardGame extends Game {
    private Deck deck;
    private int[] scores;
    private int totalRounds;
    private int currentRound;
    private Card[] currentCards;
    private int numberOfPlayers;

    public HighCardGame(int totalRounds) {
        this.totalRounds = totalRounds;
    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.scores = new int[numberOfPlayers];
        this.currentCards = new Card[numberOfPlayers];
        this.currentRound = 0;
        this.deck = new Deck();
        System.out.println("Game started with " + this.numberOfPlayers + " players and " + this.totalRounds + " rounds.\n");
    }

    @Override
    public void playSingleTurn(int player) {
        if (this.deck.isEmpty()) this.deck = new Deck();

        // add a slight delay to simulate card drawing tensions
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        currentCards[player] = this.deck.drawCard();
        System.out.println("Player " + (player + 1) + " drew " + this.currentCards[player]);

        if (player == this.numberOfPlayers - 1) {
            this.resolveRound();
            this.currentRound++;
        }
    }

    private void resolveRound() {
        System.out.println("\nRound " + (this.currentRound + 1) + " results:");

        int highestValue = -1;
        int roundWinner = -1;
        boolean tie = false;

        for (int i = 0; i < this.numberOfPlayers; i++) {
            if (this.currentCards[i].getValue() > highestValue) {
                highestValue = this.currentCards[i].getValue();
                roundWinner = i;
                tie = false;
            } else if (this.currentCards[i].getValue() == highestValue) {
                tie = true;
            }
        }

        if (tie) {
            System.out.println("\nIt's a tie! No points awarded.\n");
        } else {
            this.scores[roundWinner]++;
            System.out.println("\nPlayer " + (roundWinner + 1) + " wins the round!\n");
        }
    }

    @Override
    public boolean endOfGame() {
        return this.currentRound >= totalRounds;
    }

    @Override
    public void displayWinner() {
        System.out.println("\nGame over! Final scores:\n");

        for (int i = 0; i < this.numberOfPlayers; i++) {
            System.out.println("Player " + (i + 1) + ": " + this.scores[i] + " points");
        }

        int gameWinner = getLeader();
        if (gameWinner != -1) {
            System.out.println("\nPlayer " + (gameWinner + 1) + " wins the game!\n");
            return;
        }

        // no ultimate ties allowed -> SUDDEN DEATH!
        System.out.println("\nIt's a tie! Sudden death!\n");
        while (gameWinner == -1) {
            System.out.println("Sudden Death Round");
            for (int i = 0; i < this.numberOfPlayers; i++) {
                playSingleTurn(i);
            }
            gameWinner = getLeader();
        }
        System.out.println("\nPlayer " + (gameWinner + 1) + " wins the game!\n");
    }

    private int getLeader() {
        int highestScore = -1;
        int leader = -1;
        boolean tie = false;

        for (int i = 0; i < this.numberOfPlayers; i++) {
            if (this.scores[i] > highestScore) {
                highestScore = this.scores[i];
                leader = i;
                tie = false;
            } else if (this.scores[i] == highestScore) {
                tie = true;
            }
        }

        return tie ? -1 : leader;
    }
}
