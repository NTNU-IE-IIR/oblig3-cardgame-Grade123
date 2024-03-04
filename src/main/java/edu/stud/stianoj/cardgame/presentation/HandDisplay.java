package edu.stud.stianoj.cardgame.presentation;

import java.util.Collection;

import edu.stud.stianoj.cardgame.HandOfCards;
import edu.stud.stianoj.cardgame.PlayingCard;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HandDisplay extends HBox {

    public HandDisplay() {
        super();

        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Display the hand of cards
     * @param hand to display
     */
    public void displayHand(HandOfCards hand) {

        this.getChildren().clear();

        Collection<PlayingCard> cards = hand.getCards();

        for (PlayingCard card : cards) {
            Label label = new Label(card.getAsString());
            this.getChildren().add(label);
        }
    }
}
