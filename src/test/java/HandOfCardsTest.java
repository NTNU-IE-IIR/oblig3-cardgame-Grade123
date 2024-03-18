import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.stud.stianoj.cardgame.HandOfCards;
import edu.stud.stianoj.cardgame.PlayingCard;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for HandOfCards.
 * 
 * <p>positive test cases:
 * - Can calculate the sum of the cards in the hand
 * - Can get all the cards of a suit in the hand
 * - Can check if a card is in the hand
 * - Can check if cards in hand are flush
 * 
 * <p>nagetive test cases:
 * - Cannot construct a HandOfCards with a null collection of cards
 * - Cannot get all the cards of an invalid suit
 * - Cannot check if a card is in the hand with an invalid input
 * - Check that flush doesn't get indicated on a non flush hand
 */
public class HandOfCardsTest {

  HandOfCards hand;

  /**
   * Set up the hand of cards for testing.
   */
  @BeforeEach
  public void setUp() {
    Collection<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('S', 1));
    cards.add(new PlayingCard('H', 2));
    cards.add(new PlayingCard('D', 3));
    cards.add(new PlayingCard('C', 4));

    hand = new HandOfCards(cards);
  }

  @Test
  public void testCannotConstructHandOfCardsWithNullCards() {
    assertThrows(IllegalArgumentException.class,
        () -> new HandOfCards(null));
  }

  @Test
  public void testCanCalculateSumOfCardsInHand() {
    int sum = this.hand.getSum();
    assertEquals(10, sum);
  }

  @Test
  public void testCanGetAllCardsOfSuitInHand() {
    Collection<PlayingCard> cardsOfSuit = hand.getSuit('S');
    assertEquals(1, cardsOfSuit.size());
  }

  @Test
  public void testCannotGetAllCardsOfInvalidSuitInHand() {
    assertThrows(IllegalArgumentException.class,
        () -> hand.getSuit('X'));
  }

  @Test
  public void testCanCheckIfCardIsInHand() {
    boolean contains = hand.containsCard('S', 1);
    assertEquals(true, contains);
  }

  @Test
  public void testCannotCheckIfCardIsInHandWithInvalidInput() {
    assertThrows(IllegalArgumentException.class, () -> hand.containsCard('X', 1));
    assertThrows(IllegalArgumentException.class, () -> hand.containsCard('S', 0));
  }

  @Test
  public void testCanCheckIfCardsInHandAreFlush() {
    Collection<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('S', 1));
    cards.add(new PlayingCard('S', 2));
    cards.add(new PlayingCard('S', 3));
    cards.add(new PlayingCard('S', 4));

    HandOfCards flushHand = new HandOfCards(cards);
    boolean isFlush = flushHand.isFlush();
    assertEquals(true, isFlush);
  }

  @Test
  public void testHandIsntFlush() {
    boolean isFlush = hand.isFlush();
    assertEquals(false, isFlush);
  }
}
