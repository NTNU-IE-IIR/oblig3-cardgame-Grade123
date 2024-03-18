package edu.stud.stianoj.cardgame;

import java.util.Collection;

/**
 * Class representing a hand of cards.
 *
 * <p>Implement various methods for checking the hand of cards.
 */
public class HandOfCards {
  private Collection<PlayingCard> cards;

  /**
   * Constructor for HandOfCards.
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
   * Returns the cards in the hand.
   *
   * @return the cards in the hand
   */
  public Collection<PlayingCard> getCards() {
    return this.cards;
  }

  /**
   * Calculates and returns the sum of the cards.
   *
   * @return sum of the card's faces
   */
  public int getSum() {
    return cards.stream().mapToInt(PlayingCard::getFace).sum();
  }

  /**
   * Returns all the cards of a suit in the hand.
   *
   * @return collection of cards of the suit
   * @throws IllegalArgumentException if the suit is invalid
   */
  public Collection<PlayingCard> getSuit(char suit) throws IllegalArgumentException {
    if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C') {
      throw new IllegalArgumentException("Suit must be one of S, H, D, or C");
    }

    return cards.stream().filter(card -> card.getSuit() == suit).toList();
  }

  /**
   * Checks if a card is in the hand.
   *
   * @param suit suit of the card to check for
   * @param face face of the card to check for
   * @return true if the card is in the hand, false otherwise
   * @throws IllegalArgumentException if the suit or face is invalid
   */
  public boolean containsCard(char suit, int face) throws IllegalArgumentException {
    if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C') {
      throw new IllegalArgumentException("Suit must be one of S, H, D, or C");
    }

    if (face < 1 || face > 13) {
      throw new IllegalArgumentException("Face must be between 1 and 13");
    }

    return cards.stream().anyMatch(
        card -> card.getSuit() == suit && card.getFace() == face);
  }

  /**
   * Check if the hand contains a flush.
   * 
   * <p>Internally checks the number of distinct stuis and if the number is 1
   * Then returns true, otherwise false
   *
   * @return true if the hand contains a flush, false otherwise
   */
  public boolean isFlush() {
    return cards.stream().map(PlayingCard::getSuit).distinct().count() == 1;
  }
}
