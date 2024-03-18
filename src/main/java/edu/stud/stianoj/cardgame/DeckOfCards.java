package edu.stud.stianoj.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/**
 * Deck of cards class.
 * Represents a deck of 52 playing cards.
 *
 * @author stianoj
 * @since 18/03/2024
 */
public class DeckOfCards {
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private static final int CARDS_PER_SUIT = 13;

  private ArrayList<PlayingCard> cards;

  /**
   * Creates a new deck of 52 cards. A deck contains 4 suits, each with 13 cards.
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
   * Returns n number of playing cards.
   * 
   * <p>Uses a hashset to ensure that the cards are unique
   *
   * @param n number of cards to return
   * @return Collection n number of random playing cards
   * @throws IllegalArgumentException if n is greater than cards in the deck or negative
   */
  public Collection<PlayingCard> dealHand(int n) throws IllegalArgumentException {
    if (n > cards.size() || n < 0) {
      throw new IllegalArgumentException("Parameter n must be between 0 and " + cards.size());
    }

    Random random = new Random();

    HashSet<PlayingCard> cards = new HashSet<>();
    while (cards.size() < n) {
      int index = random.nextInt(this.cards.size());
      cards.add(this.cards.get(index));
    }

    return cards;
  }

  /**
   * Returns the number of cards in the deck.
   *
   * @return the number of cards in the deck
   */
  public int getNumberOfCards() {
    return this.cards.size();
  }
}
