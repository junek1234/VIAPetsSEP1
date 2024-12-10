package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  @FXML
  private MenuItem petsMenuItem;
  @FXML
  private MenuItem customersMenuItem;
  @FXML
  private MenuItem bookingsSettingsMenuItem;
  @FXML
  private MenuItem bookingsListMenuItem;
  @FXML
  private MenuItem salesMenuItem;

  private Stage stage;

  @FXML
  public void switchScene(ActionEvent e) throws IOException {
    Object source = e.getSource();
    String fxmlPath;

    // Determine which scene to load based on the source
    if (source == petsMenuItem) {
      fxmlPath = "fxml/BirdPetView.fxml";
    } else if (source == customersMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultCustomerView.fxml";
    } else if (source == bookingsSettingsMenuItem) {
      fxmlPath = "fxml/currentlyworking/BookingSettingsView.fxml";
    } else if (source == bookingsListMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultBookingsView.fxml";
    } else if (source == salesMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultSalesView.fxml";
    } else {
      fxmlPath = "fxml/currentlyworking/DefaultView.fxml"; // Default fallback scene
    }

    // Load the FXML and switch the scene
    Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
    MenuItem mirrorMenuItem = (MenuItem) source;
    stage = (Stage) mirrorMenuItem.getParentPopup().getOwnerWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}