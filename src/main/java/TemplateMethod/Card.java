package TemplateMethod;

public class Card {
    private final String suit;
    private final int value;

    private static final String[] SUITS = {"Hearts", "Clubs", "Diamonds", "Spades"};
    private static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return VALUES[this.value - 2] + " of " + this.suit;
    }
}
