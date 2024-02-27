package edu.stud.stianoj.cardgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane myBorder = new BorderPane();

        Scene myScene = new Scene(myBorder, 800, 600, Color.ORANGE);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
