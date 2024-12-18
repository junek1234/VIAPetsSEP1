package main;

import javafx.application.Application;
import view.StartGUI;

/**
 * The RunVIAPetsApplication class is the entry point for launching the application.
 * It initializes the JavaFX application by launching the StartGUI class, which is responsible for
 * the graphical user interface (GUI) of the application.
 *
 * @version 1.0
 */
public class RunVIAPetsApplication
{
  /**
   * The main method serves as the entry point for the application. It launches the JavaFX application
   * by calling the launch method on the StartGUI class.
   *
   * @param args Command-line arguments passed to the application.
   */
  public static void main(String[] args)
  {
    Application.launch(StartGUI.class);
  }
}
