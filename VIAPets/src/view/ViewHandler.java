package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SortEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;

public class ViewHandler {
  //related to pets
  @FXML private MenuItem petsMenuItem;
  @FXML private MenuItem dogMenuItem;
  @FXML private MenuItem catMenuItem;
  @FXML private MenuItem birdMenuItem;
  @FXML private MenuItem rodentMenuItem;
  @FXML private MenuItem fishMenuItem;
  @FXML private MenuItem variousMenuItem;
  
  //customers
  @FXML private MenuItem customersMenuItem;
  @FXML private MenuItem addCustomerMenuItem;

  //bookings
  @FXML private MenuItem bookingsMenuItem;
  @FXML private MenuItem addBookingMenuItem;
  @FXML private MenuItem bookingsSettingsMenuItem;

  //sales
  @FXML private MenuItem salesMenuItem;
  @FXML private MenuItem addSaleMenuItem;


  private CustomerController customerController = new CustomerController();
  private Stage stage;  // Keep a reference to the primaryStage
  private Parent root;
  private String fxmlDefPath = "fxml/currentlyworking/DefaultView.fxml";

  @FXML public void switchScene(ActionEvent e) throws IOException {
    Object source = e.getSource();
    String fxmlPath;

    // Handle menu item click event to determine which scene to load
    if (source == petsMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultPetView.fxml";
    } else if (source == customersMenuItem) {
      fxmlPath = "fxml/Customers/DefaultCustomerView.fxml";
    } else if (source == bookingsSettingsMenuItem) {
      fxmlPath = "fxml/currentlyworking/BookingSettingsView.fxml";
    } else if (source == bookingsMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultBookingsView.fxml";
    } else if (source == salesMenuItem) {
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
    fxmlDefPath = fxmlPath;
    stage.show();
  }

  // Create a separate method for popup handling
  @FXML private void showPopup(ActionEvent e) throws IOException
  {
    Object source = e.getSource();
    // Create a new stage for the popup
    Stage popupStage = new Stage();

    String fxmlPath;
  if (source == dogMenuItem||source==catMenuItem) {
    fxmlPath = "fxml/pets/DogCatPetView.fxml";
    popupStage.setTitle("Add " + (source == dogMenuItem ? "Dog" : "Cat"));
  } else if (source == birdMenuItem) {
    fxmlPath = "fxml/pets/BirdPetView.fxml";
    popupStage.setTitle("Add Bird");
  } else if (source == fishMenuItem) {
    fxmlPath = "fxml/pets/FishPetView.fxml";
    popupStage.setTitle("Add Fish");
  } else if (source == rodentMenuItem || source == variousMenuItem) {
    fxmlPath = "fxml/pets/RodentVariousPetView.fxml";
    popupStage.setTitle("Add " + (source == rodentMenuItem ? "Rodent" : "Various"));

  } else if (source == addCustomerMenuItem) {
    fxmlPath = "fxml/Customers/AddCustomer.fxml";
    popupStage.setTitle("Add Customer");
  } else if (source == addBookingMenuItem) {
    fxmlPath = "fxml/bookings/AddBooking.fxml";
    popupStage.setTitle("Add Booking");
  } else if (source == addSaleMenuItem) {
    fxmlPath = "fxml/bookings/AddBooking.fxml";
    popupStage.setTitle("Add Sale");
  } else{
    fxmlPath = fxmlDefPath;
  }
    // Set the modality of the popup (optional)
    popupStage.initModality(Modality.APPLICATION_MODAL); // Makes the popup modal (blocks other windows)

    // Create the scene for the popup window
    Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
    Scene popupScene = new Scene(root);
    popupStage.setScene(popupScene);

    // Show the popup window
    popupStage.showAndWait();  // This will block the main window until the popup is closed
  }
  public void save(){
  }

//  public void addTest(ActionEvent e) {
//    customerController.addTest(e);
//  }

//  public void addPet(Object source) {
//    petController.addPet(source);
//  }

}
