package edu.stud.stianoj.cardgame;

import java.util.Collection;


/**
 * Class representing a hand of cards
 * 
 * <p> Implement various methods for checking the hand of cards
 */
public class HandOfCards {
    private Collection<PlayingCard> cards;

    /**
     * Constructor for HandOfCards
     * Takes in a collection of cards that will be used as the cards in the hand
     * 
     * @param cards the cards in the hand
     * @throws IllegalArgumentException if the cards collection is null
     */
    public HandOfCards(Collection<PlayingCard> cards) {
        if (cards == null) {
            throw new IllegalArgumentException("Cards cannot be null");
        }

        this.cards = cards;
    }

    /**
     * Returns the cards in the hand
     * 
     * @return the cards in the hand
     */
    public Collection<PlayingCard> getCards() {
        return this.cards;
    }
}
