package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import model.Customer;

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
  @FXML
  private MenuItem dogMenuItem;
  @FXML
  private MenuItem catMenuItem;
  @FXML
  private MenuItem birdMenuItem;
  @FXML
  private MenuItem rodentMenuItem;
  @FXML
  private MenuItem variousMenuItem;

//  private CustomerController customerController= new CustomerController();
  private Stage stage;  // Keep a reference to the primaryStage
  private Parent root;
  private String fxmlDefPath="fxml/currentlyworking/DefaultView.fxml";

  @FXML
  public void switchScene(ActionEvent e) throws IOException {
    Object source = e.getSource();
    String fxmlPath;

    // Handle menu item click event to determine which scene to load
    if (source == petsMenuItem) {
      fxmlPath = "fxml/BirdPetView.fxml";
      System.out.println(fxmlPath);
    } else if (source == customersMenuItem) {
      fxmlPath = "fxml/Customers/DefaultCustomerView.fxml";
    } else if (source == bookingsSettingsMenuItem) {
      fxmlPath = "fxml/currentlyworking/BookingSettingsView.fxml";
    } else if (source == bookingsListMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultBookingsView.fxml";
    } else if (source == dogMenuItem||source==catMenuItem) {
      fxmlPath = "fxml/pets/DogCatPetView.fxml";
    } else if (source == birdMenuItem) {
      fxmlPath = "fxml/pets/BirdPetView.fxml";
    } else if (source == rodentMenuItem || source == variousMenuItem) {
      fxmlPath = "fxml/pets/RodentVariousPetView.fxml";
    }  else if (source == salesMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultSalesView.fxml";
    } else {
      fxmlPath = fxmlDefPath;  // Default fallback scene
    }
    // Switch to the selected scene
    root = FXMLLoader.load(getClass().getResource(fxmlPath));
    MenuItem mirrorMenuItem = (MenuItem) source;
    stage = (Stage) mirrorMenuItem.getParentPopup().getOwnerWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    fxmlDefPath=fxmlPath;
    stage.show();
  }

//  public void addTest(ActionEvent e)
//  {
//    customerController.addTest(e);
//  }



}