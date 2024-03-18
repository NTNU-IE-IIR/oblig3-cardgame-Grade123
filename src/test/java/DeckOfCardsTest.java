import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.stud.stianoj.cardgame.DeckOfCards;
import org.junit.jupiter.api.Test;

/**
 * Test class for DeckOfCards
 * 
 * <p>positive test cases:
 * - test that you can construct a deck of cards with 52 cards
 * - test that you can get n random cards from the deck
 *
 * <p>negative test cases:
 * - test that you cannot get more cards than the deck contains.
 */
public class DeckOfCardsTest {
  @Test
  public void testDeckOfCards() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.getNumberOfCards());
  }

  @Test
  public void testDealHand() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(5, deck.dealHand(5).size());
  }

  @Test
  public void testDealHandNegative() {
    assertThrows(IllegalArgumentException.class, () -> {
      DeckOfCards deck = new DeckOfCards();
      deck.dealHand(53);
    });
  }
}
