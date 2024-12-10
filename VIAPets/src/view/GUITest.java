package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUITest extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Load the FXML file
    Parent root = FXMLLoader.load(getClass().getResource("DefaultCustomerView.fxml"));

    // Set the scene
    Scene scene = new Scene(root);

    // Configure the stage
    primaryStage.setTitle("Customer Management System");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args); // Launch the JavaFX application
  }
}
