package edu.stud.stianoj.cardgame;

import edu.stud.stianoj.cardgame.presentation.CardGameApplication;

/**
 * Main class.
 * 
 * <p>Entry point of the application
 * 
 * <p>Starts the application
 * 
 * <p>Catches any exceptions and prints them to the console
 *
 * @author stianoj
 * @since 18/03/2024
 */
public class Main {

  /**
   * Main method.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      CardGameApplication.appMain(args);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
