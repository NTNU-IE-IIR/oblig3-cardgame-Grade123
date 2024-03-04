package edu.stud.stianoj.cardgame.presentation;

import java.io.InputStream;
import java.util.Collection;

import edu.stud.stianoj.cardgame.HandOfCards;
import edu.stud.stianoj.cardgame.PlayingCard;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

/**
 * Hand display class
 * used to display a handofcards as a graphical user interface
 */
public class HandDisplay extends FlowPane {

    /**
     * Constructor for HandDisplay
     */
    public HandDisplay() {
        super();

        this.setVgap(20);
        this.setHgap(20);
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
            try (InputStream is = this.getClass().getResourceAsStream("/" + card.getAsString() + ".png")){
                Image cardImage = new Image(is);
                ImageView cardImageView = new ImageView(cardImage);

                double aspect = cardImage.getWidth() / cardImage.getHeight();
                cardImageView.setFitHeight(200);
                cardImageView.setFitWidth(200 * aspect);
                this.getChildren().add(cardImageView);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
