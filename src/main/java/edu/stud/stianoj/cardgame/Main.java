package edu.stud.stianoj.cardgame;

import edu.stud.stianoj.cardgame.presentation.CardGameApplication;

public class Main{
    public static void main(String[] args) {
        try {
            CardGameApplication.appMain(args);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
