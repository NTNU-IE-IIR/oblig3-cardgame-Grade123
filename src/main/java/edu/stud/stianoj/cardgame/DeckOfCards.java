package edu.stud.stianoj.cardgame;

import java.util.ArrayList;
import java.util.List;
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
    public List<PlayingCard> dealHand(int n) {
        if (n > cards.size() || n < 0) {
            throw new IllegalArgumentException("Parameter n must be between 0 and " + cards.size());
        } 

        Random random = new Random();

        List<PlayingCard> hand = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(cards.size());
            hand.add(cards.remove(index));
        }

        return hand;
    }
}
