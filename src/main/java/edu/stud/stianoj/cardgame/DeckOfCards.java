package edu.stud.stianoj.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class DeckOfCards {
    private final char[] suits = {'S', 'H', 'D', 'C'};
    private final int CARDS_PER_SUIT = 13;

    private ArrayList<PlayingCard> cards;

    /**
     * Creates a new deck of 52 cards. A deck contains 4 suits, each with 13 cards.
     * 
     */
    public DeckOfCards() {
        cards = new ArrayList<>();

        for (char suit : suits) {
            for (int face = 1; face <= CARDS_PER_SUIT; face++) {
                cards.add(new PlayingCard(suit, face));
            }
        }
    }

    /**
     * Returns n number of playing cards
     * 
     * @param n number of cards to return
     * @throws IllegalArgumentException if n is greater than the number of cards in the deck or negative
     * @return n number of random playing cards
     */
    public Collection<PlayingCard> dealHand(int n) {
        if (n > cards.size() || n < 0) {
            throw new IllegalArgumentException("Parameter n must be between 0 and " + cards.size());
        } 

        Random random = new Random();

        HashSet<PlayingCard> cards = new HashSet<>();
        while (cards.size() < n){
            System.out.println("cards.size() = " + cards.size());
            int index = random.nextInt(this.cards.size());
            cards.add(this.cards.get(index)); 
        }

        return cards;
    }


    /**
     * Returns the number of cards in the deck
     * 
     * @return the number of cards in the deck
     */
    public int getNumberOfCards() {
        return this.cards.size();
    }
}
