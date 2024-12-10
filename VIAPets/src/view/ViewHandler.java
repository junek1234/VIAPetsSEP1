package view;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Customer;
import model.Dog;
import model.Pet;

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
  
  //customer
  @FXML private MenuItem customersMenuItem;
  @FXML private MenuItem addCustomerMenuItem;

  // default customer view
  @FXML Button addCustomerButton;
  @FXML Button editCustomerButton;
  @FXML Button deleteCustomerButton;
  @FXML Button searchCustomerButton;
  @FXML TextField searchBarCustomerTextField;

  // add customer view
  @FXML TextField customerIDTextField;
  @FXML TextField nameTextField;
  @FXML TextField phoneNumberTextField;
  @FXML TextField emailTextField;
  @FXML Button saveButton;


  //bookings
  @FXML private MenuItem bookingsMenuItem;
  @FXML private MenuItem addBookingMenuItem;
  @FXML private MenuItem bookingsSettingsMenuItem;

  // default booking view
  @FXML Button addBookingButton;
  @FXML Button editBookingButton;
  @FXML Button deleteBookingButton;
  @FXML Button searchBookingButton;
  @FXML TextField searchBarBookingTextField;

  //sales
  @FXML private MenuItem salesMenuItem;
  @FXML private MenuItem addSaleMenuItem;
  @FXML private TableView<Pet> petTable;
  @FXML private TableColumn<Pet, Number> petIDPetView;
  @FXML private TableColumn<Pet, String> petNamePetView;
  @FXML private TableColumn<Pet, String> petColorPetView;
  @FXML private TableColumn<Pet, String> petGenderPetView;

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
    VBox vbox = new VBox();


    initfknlist();
    vbox.getChildren().add(root);
    vbox.getChildren().add(petTable);
    Scene scene = new Scene(vbox);





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
  if (source == dogMenuItem || source==catMenuItem) {
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

  } else if (source == addCustomerMenuItem || source == addCustomerButton) {
    fxmlPath = "fxml/Customers/AddCustomer.fxml";
    popupStage.setTitle("Add Customer");
  } else if (source == addBookingMenuItem || source == addBookingButton) {
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
  public void initfknlist()
  {
    ObservableList<Pet> pets = FXCollections.observableArrayList(
        new Dog(1, "Buddy", "Brown", 4, 'M', "New York", "Available", "idk",
            "idk", 150.0, "Friendly"),
        new Dog(2, "Luna", "Black", 2, 'F', "Boston", "Adopted", "idk", "idk",
            100.0, "Playful"));

    // Create TableView
    petTable = new TableView<>(pets);
//    petTable.setItems(pets);

    // Create columns for each field in the Pet class
    petIDPetView = new TableColumn<>("Pet ID");
    petIDPetView.setCellValueFactory(
        cellData -> new SimpleIntegerProperty(cellData.getValue().getPetID()));

    petNamePetView = new TableColumn<>("Name");
    petNamePetView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getName()));

    petColorPetView = new TableColumn<>("Color");
    petColorPetView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getColor()));

    petGenderPetView = new TableColumn<>("Gender");
    petGenderPetView.setCellValueFactory(cellData -> new SimpleStringProperty(
        String.valueOf(cellData.getValue().getGender())));


    // Add columns to the table
    petTable.getColumns()
        .addAll(petIDPetView, petNamePetView, petColorPetView, petGenderPetView);
    petTable.refresh();
    System.out.println(petTable.getColumns().toString());
//    System.out.println(petTable.getColumns().get(1).getText());
    for (Pet pet : petTable.getItems()) {
      // Assuming your second column is for "Pet Name"
      System.out.println("Pet Name from table: " + petTable.getColumns().get(1).getCellData(pet));
    }  }
}
