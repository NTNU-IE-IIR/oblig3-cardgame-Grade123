package edu.stud.stianoj.cardgame;

import java.util.Collection;

public class HandOfCards {
    private Collection<PlayingCard> cards;

    public HandOfCards(Collection<PlayingCard> cards) {
        if (cards == null) {
            throw new IllegalArgumentException("Cards cannot be null");
        }

        this.cards = cards;
    }

    public Collection<PlayingCard> getCards() {
        return this.cards;
    }
}
