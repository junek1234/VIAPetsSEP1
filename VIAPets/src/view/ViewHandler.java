package view;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
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
import model.*;


import javafx.scene.control.TableColumn;


import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ViewHandler {
  public static String lastPopupSource;
  //for PetViewController
  @FXML private TextField petNameTextField;
  @FXML private TextField petColorTextField;
  @FXML private TextField petAgeTextField;
  @FXML private TextField petPriceTextField;
  @FXML private TextField petBreedTextField;
  @FXML private TextField petBreederNameTextField;
  @FXML private TextArea petCommentTextField;
  @FXML private TextField petSpeciesTextField;
  @FXML private TextField petFoodTextField;

  @FXML private RadioButton petGenderMaleRadioButton;
  @FXML private RadioButton petGenderFemaleRadioButton;
  @FXML private RadioButton petLocationShopRadioButton;
  @FXML private RadioButton petLocationKennelRadioButton;
  @FXML private RadioButton petStatusSoldRadioButton;
  @FXML private RadioButton petStatusNotSoldRadioButton;
  @FXML private RadioButton petStatusNotFromViaRadioButton;
  @FXML private RadioButton petSaltWaterYesRadioButton;
  @FXML private RadioButton petSaltWaterNoRadioButton;
  @FXML private RadioButton petPredatorYesRadioButton;
  @FXML private RadioButton petPredatprNoRadioButton;

  @FXML private Button petSaveButton;
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

  @FXML private TableView<Customer> customerTable;
  @FXML private TableColumn<Customer, Number> customerIDView;
  @FXML private TableColumn<Customer, String> customerNameView;
  @FXML private TableColumn<Customer, Number> phoneNumberView;
  @FXML private TableColumn<Customer, String> emailView;

  @FXML private TableView<Booking> bookingTable;
  @FXML private TableColumn<Booking, Number> bookingIDView;
  @FXML private TableColumn<Booking, String> petNameBookingView;
  @FXML private TableColumn<Booking, String> customerNameBookingView;
  @FXML private TableColumn<Booking, String> startDateBookingView;
  @FXML private TableColumn<Booking, String> endDateBookingView;

  @FXML private TableView<Sale> saleTable;
  @FXML private TableColumn<Sale, Number> saleIDView;
  @FXML private TableColumn<Sale, String> petNameSaleView;
  @FXML private TableColumn<Sale, String> customerNameSaleView;
  @FXML private TableColumn<Sale, String> priceSaleView;


  private Stage stage;  // Keep a reference to the primaryStage
  private Parent root;
  private String fxmlDefPath = "fxml/currentlyworking/DefaultView.fxml";
  VIAPets viaPets = new VIAPets();
  MyModelManager myModelManager = new MyModelManager();

  @FXML
  public void switchScene(ActionEvent e) throws IOException {
    Object source = e.getSource();
    String fxmlPath;

    if (source == petsMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultPetView.fxml";
      initfknlist();
    } else if (source == customersMenuItem) {
      fxmlPath = "fxml/Customers/DefaultCustomerView.fxml";
      initCustomerList();
    } else if (source == bookingsSettingsMenuItem) {
      fxmlPath = "fxml/currentlyworking/BookingSettingsView.fxml";
    } else if (source == bookingsMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultBookingsView.fxml";
      initBookingList();
    } else if (source == salesMenuItem) {
      fxmlPath = "fxml/currentlyworking/DefaultSalesView.fxml";
      initSaleList();
    } else {
      fxmlPath = fxmlDefPath;
    }

    root = FXMLLoader.load(getClass().getResource(fxmlPath));
    MenuItem mirrorMenuItem = (MenuItem) source;
    stage = (Stage) mirrorMenuItem.getParentPopup().getOwnerWindow();
    VBox vbox = new VBox();
    vbox.getChildren().add(root);

    if (source == petsMenuItem) {
      vbox.getChildren().add(petTable);
    }

    else if (source == customersMenuItem) {
      vbox.getChildren().add(customerTable);
    }

    else if (source == bookingsMenuItem) {
      vbox.getChildren().add(bookingTable);
    }
    
    else if (source == salesMenuItem) {
      vbox.getChildren().add(saleTable);
    }

    Scene scene = new Scene(vbox);
    stage.setScene(scene);
    fxmlDefPath = fxmlPath;
    stage.show();
  }


  // Create a separate method for popup handling
  @FXML public void showPopup(ActionEvent e) throws IOException
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
  MenuItem sourceCasted = (MenuItem) source;
    lastPopupSource=sourceCasted.getId();
    // Set the modality of the popup (optional)
    popupStage.initModality(Modality.APPLICATION_MODAL); // Makes the popup modal (blocks other windows)

    // Create the scene for the popup window
    Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
    Scene popupScene = new Scene(root);
    popupStage.setScene(popupScene);

    // Show the popup window
    popupStage.showAndWait();// This will block the main window until the popup is closed



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

  public void initCustomerList() {
    ObservableList<Customer> customers = FXCollections.observableArrayList(
        new Customer(1, "manuel", 999, "@gmail"),
        new Customer(2, "gustavo", 99, "@gma")
    );

    customerTable = new TableView<>(customers);

    customerIDView = new TableColumn<>("Customer ID");
    customerIDView.setCellValueFactory(
        cellData -> new SimpleIntegerProperty(cellData.getValue().getCustomerID())
    );

    customerNameView = new TableColumn<>("Name");
    customerNameView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getName())
    );

    phoneNumberView = new TableColumn<>("Phone Number");
    phoneNumberView.setCellValueFactory(
        cellData -> new SimpleIntegerProperty(cellData.getValue().getPhoneNumber())
    );

    emailView = new TableColumn<>("Email");
    emailView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getEmail())
    );

    customerTable.getColumns().addAll(customerIDView, customerNameView, phoneNumberView, emailView);

    customerTable.refresh();
  }

  public void initBookingList() {
    ObservableList<Booking> bookings = FXCollections.observableArrayList(
        new Booking(
            1,
            new Dog(1, "Buddy", "Brown", 4, 'M', "New York", "Available", "idk",
                "idk", 150.0, "Friendly"),
            new Customer(1, "gustavo", 999, "@gmai"),
            new DateInterval(
                new Date(1, 5, 4, 1),
                new Date(2, 7, 4, 3)
            )
        ),
        new Booking(
            2,
            new Dog(1, "Buddy", "Brown", 4, 'M', "New York", "Available", "idk",
                "idk", 150.0, "Friendly"),
            new Customer(1, "manuel", 999, "@dd"),
            new DateInterval(
                new Date(1, 5, 4, 1),
                new Date(2, 7, 4, 3)
            )
        )
    );

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    bookingTable = new TableView<>(bookings);

    bookingIDView = new TableColumn<>("Booking ID");
    bookingIDView.setCellValueFactory(
        cellData -> new SimpleIntegerProperty(cellData.getValue().getBookingID())
    );

    petNameBookingView = new TableColumn<>("Pet Name");
    petNameBookingView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getPet().getName())
    );

    customerNameBookingView = new TableColumn<>("Customer Name");
    customerNameBookingView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getName())
    );

    startDateBookingView = new TableColumn<>("Start Date");
    startDateBookingView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getDateInterval().getStartDate().format(formatter))
    );

    endDateBookingView = new TableColumn<>("End Date");
    endDateBookingView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getDateInterval().getEndDate().format(formatter))
    );

    bookingTable.getColumns().addAll(bookingIDView, petNameBookingView, customerNameBookingView, startDateBookingView, endDateBookingView);

    bookingTable.refresh();
  }

  public void initSaleList() {
    ObservableList<Sale> sales = FXCollections.observableArrayList(
        new Sale(1, new Customer(1, "manuel", 999, "@dd"), new Dog(1, "Buddy", "Brown", 4, 'M', "New York", "Available", "idk",
            "idk", 150.0, "Friendly"), 5),
        new Sale(1, new Customer(1, "manuel", 999, "@dd"), new Dog(1, "Buddy", "Brown", 4, 'M', "New York", "Available", "idk",
            "idk", 150.0, "Friendly"), 5));


    saleTable = new TableView<>(sales);

    saleIDView = new TableColumn<>("Sale ID");
    saleIDView.setCellValueFactory(
        cellData -> new SimpleIntegerProperty(cellData.getValue().getSaleID())
    );

    petNameSaleView = new TableColumn<>("Pet Name");
    petNameSaleView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getPet().getName())
    );

    customerNameSaleView = new TableColumn<>("Customer Name");
    customerNameSaleView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getName())
    );

    priceSaleView = new TableColumn<>("Price");
    priceSaleView.setCellValueFactory(
        cellData -> new SimpleStringProperty(String.format("%.2f",cellData.getValue().getSalePrice())));

    saleTable.getColumns().addAll(saleIDView, petNameSaleView, customerNameSaleView, priceSaleView);

    saleTable.refresh();
  }


//  public void initBookingList() {
//    ObservableList<Booking> bookings = FXCollections.observableArrayList(
//        new Booking(
//            1,
//            new Dog(1, "goof", "hvid", "3", "M", "cph", "sold", "10", "ola"),
//            new Customer(1, "gustavo", 999, "@gmai"),
//            new DateInterval(
//                new Date(1, 5, 4, 1),
//                new Date(2, 7, 4, 3)
//            )
//        ),
//        new Booking(
//            2,
//            new Dog(1, "goof", "hvid", "3", "M", "cph", "sold", "10", "ola"),
//            new Customer(1, "manuel", 999, "@dd"),
//            new DateInterval(
//                new Date(1, 5, 4, 1),
//                new Date(2, 7, 4, 3)
//            )
//        )
//    );
//
//    bookingTable = new TableView<>(bookings);
//
//    bookingIDView = new TableColumn<>("Booking ID");
//    bookingIDView.setCellValueFactory(
//        cellData -> new SimpleIntegerProperty(cellData.getValue().getBookingID())
//    );
//
//    petNameBookingView = new TableColumn<>("Pet Name");
//    petNameBookingView.setCellValueFactory(
//        cellData -> new SimpleStringProperty(cellData.getValue().getPet().getName())
//    );
//
//    customerNameBookingView = new TableColumn<>("Customer Name");
//    customerNameBookingView.setCellValueFactory(
//        cellData -> new SimpleIntegerProperty(cellData.getValue().getCustomer().getName())
//    );
//
//    startDateBookingView = new TableColumn<>("Start Date");
//    startDateBookingView.setCellValueFactory(
//        cellData -> new SimpleStringProperty(cellData.getValue().getDateInterval().getStartDate())
//    );
//
//    endDateBookingView = new TableColumn<>("End Date");
//    endDateBookingView.setCellValueFactory(
//        cellData -> new SimpleStringProperty(cellData.getValue().getDateInterval().getEndDate())
//    );
//
//    bookingTable.getColumns().addAll(bookingIDView, petNameBookingView, customerNameBookingView, startDateBookingView, endDateBookingView);
//
//    bookingTable.refresh();
//  }
//
//  public void initSaleList() {
//    ObservableList<Sale> sales = FXCollections.observableArrayList(
//        new Sale(1, new Customer(1, "manuel", 999, "@dd"), new Dog(1, "goof", "hvid","3","M","cph","sold","10","ola"), 5),
//        new Sale(1, new Customer(1, "manuel", 999, "@dd"), new Dog(1, "goof", "hvid","3","M","cph","sold","10","ola"), 5));
//
//
//    saleTable = new TableView<>(sales);
//
//    saleIDView = new TableColumn<>("Sale ID");
//    saleIDView.setCellValueFactory(
//        cellData -> new SimpleIntegerProperty(cellData.getValue().getSaleID())
//    );
//
//    petNameSaleView = new TableColumn<>("Pet Name");
//    petNameSaleView.setCellValueFactory(
//        cellData -> new SimpleIntegerProperty(cellData.getValue().getPet().getName())
//    );
//
//    customerNameSaleView = new TableColumn<>("Customer Name");
//    customerNameSaleView.setCellValueFactory(
//        cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getName())
//    );
//
//    priceSaleView = new TableColumn<>("Price");
//    priceSaleView.setCellValueFactory(
//        cellData -> new SimpleStringProperty(cellData.getValue().getSalePrice())
//    );
//
//    saleTable.getColumns().addAll(saleIDView, petNameSaleView, customerNameSaleView, priceSaleView);
//
//    saleTable.refresh();
//  }

}

