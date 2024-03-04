package edu.stud.stianoj.cardgame.presentation;

import java.util.Collection;

import edu.stud.stianoj.cardgame.HandOfCards;
import edu.stud.stianoj.cardgame.PlayingCard;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HandDisplay extends Pane {
    
    private VBox vBox;

    public HandDisplay() {
        super();

        vBox = new VBox();
        this.getChildren().add(vBox);
    }

    /**
     * Display the hand of cards
     * @param hand to display
     */
    public void displayHand(HandOfCards hand) {

        vBox.getChildren().clear();

        Collection<PlayingCard> cards = hand.getCards();

        for (PlayingCard card : cards) {
            Label label = new Label(card.toString());
            vBox.getChildren().add(label);
        }
    }
}
