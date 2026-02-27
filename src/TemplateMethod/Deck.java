package TemplateMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};

        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) {
                this.cards.add(new Card(suit, value));
            }
        }

        Collections.shuffle(this.cards);
    }

    public Card drawCard() {
        if (this.cards.isEmpty()) return null;
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }
}
