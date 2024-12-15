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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.*;


import javafx.scene.control.TableColumn;

import java.awt.print.Book;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ViewHandler
{
  public static String lastPopupSource;
//  for PetViewController
    @FXML private TextField petNameTextField;
    @FXML private TextField petColorTextField;
    @FXML private TextField petAgeTextField;
    @FXML private TextField petPriceTextField;

    @FXML private TextArea petCommentTextField;

    @FXML private RadioButton petGenderMaleRadioButton;
    @FXML private RadioButton petGenderFemaleRadioButton;
    @FXML private RadioButton petLocationShopRadioButton;
    @FXML private RadioButton petLocationKennelRadioButton;
    @FXML private RadioButton petStatusSoldRadioButton;
    @FXML private RadioButton petStatusNotSoldRadioButton;
    @FXML private RadioButton petStatusNotFromViaRadioButton;

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

  //search bar
  @FXML private TextField existingSearchField;
  @FXML private Button existingSearchButton;
  //tables
   private TableView<Pet> petTable;
   private TableColumn<Pet, Number> petIDPetView;
   private TableColumn<Pet, String> petTypePetView;
   private TableColumn<Pet, String> petLocationPetView;
   private TableColumn<Pet, String> petStatusPetView;
   private TableColumn<Pet, String> petNamePetView;
   private TableColumn<Pet, String> petColorPetView;
   private TableColumn<Pet, String> petGenderPetView;
   private TableColumn<Pet, String> petCommentPetView;
   private TableColumn<Pet, Void> actionsPetView;
   private TableColumn<Pet, String> petPricePetView;


   private TableView<Customer> customerTable;
   private TableColumn<Customer, Number> customerIDView;
   private TableColumn<Customer, String> customerNameView;
   private TableColumn<Customer, Number> phoneNumberView;
   private TableColumn<Customer, String> emailView;
   private TableColumn<Customer, Void> actionsCustomerView;

   private TableView<Booking> bookingTable;
   private TableColumn<Booking, Number> bookingIDView;
   private TableColumn<Booking, String> petNameBookingView;
   private TableColumn<Booking, String> customerNameBookingView;
   private TableColumn<Booking, String> startDateBookingView;
   private TableColumn<Booking, String> endDateBookingView;
   private TableColumn<Booking, String> startHourBookingView;
   private TableColumn<Booking, String> endHourBookingView;
   private TableColumn<Booking, Void> actionsBookingView;

   private TableView<Sale> saleTable;
   private TableColumn<Sale, Number> saleIDView;
   private TableColumn<Sale, String> petNameSaleView;
   private TableColumn<Sale, String> customerNameSaleView;
   private TableColumn<Sale, String> priceSaleView;
   private TableColumn<Sale, Void> actionsSaleView;

  private Stage stage;  // Keep a reference to the primaryStage
  private Parent root;
  private String fxmlDefPath = "fxml/currentlyworking/DefaultView.fxml";
  private static String fxmlPrevPath="";
  MyModelManager myModelManager = new MyModelManager();
  VIAPets viaPets = new VIAPets();

  BirdViewController birdViewController = new BirdViewController();

  @FXML public void switchScene(ActionEvent e) throws IOException
  {
    Object source = e.getSource();
    String fxmlPath = "";

    if (source == petsMenuItem)
    {
      fxmlPath = "fxml/currentlyworking/DefaultPetView.fxml";
      initPetlist();
    }
    else if (source == customersMenuItem)
    {
      fxmlPath = "fxml/Customers/DefaultCustomerView.fxml";
      initCustomerList();
    }
    // bookings settings changed to popup
//    else if (source == bookingsSettingsMenuItem)
//    {
//      fxmlPath = "fxml/currentlyworking/BookingSettingsView.fxml";
//    }
    else if (source == bookingsMenuItem)
    {
      fxmlPath = "fxml/currentlyworking/DefaultBookingsView.fxml";
      initBookingList();
    }
    else if (source == salesMenuItem)
    {
      fxmlPath = "fxml/currentlyworking/DefaultSalesView.fxml";
      initSaleList();
    }
    else
    {
//      fxmlPath=fxmlPrevPath;
//      System.out.println(fxmlPrevPath);
//      System.out.println(fxmlPath);
//      initCustomerList();
//      source=(Object)customersMenuItem;
    }
    fxmlPrevPath=fxmlPath;




    root = FXMLLoader.load(getClass().getResource(fxmlPath));
    MenuItem mirrorMenuItem = (MenuItem) source;
    stage = (Stage) mirrorMenuItem.getParentPopup().getOwnerWindow();
    VBox vbox = new VBox();

    TextField searchField = new TextField();
    searchField.setPromptText("Search...");
    Button searchButton = new Button("Search");

    HBox searchBox = new HBox(searchField, searchButton);
    HBox.setHgrow(searchField, Priority.ALWAYS);
    searchBox.setPadding(new Insets(0,0,50,0));
    vbox.getChildren().add(root);
    vbox.getChildren().add(searchBox);




    if (source == petsMenuItem)
    {
      vbox.getChildren().add(petTable);
      searchButton.setOnAction(event -> filterTablePet(petTable, searchField.getText())); // (m)
    }

    else if (source == customersMenuItem)
    {
      vbox.getChildren().add(customerTable);
      searchButton.setOnAction(event -> filterTableCustomer(customerTable, searchField.getText())); // (m)
    }

    else if (source == bookingsMenuItem)
    {
      vbox.getChildren().add(bookingTable);
      searchButton.setOnAction(event -> filterTableBooking(bookingTable, searchField.getText())); // (m)
    }

    else if (source == salesMenuItem)
    {
      vbox.getChildren().add(saleTable);
      searchButton.setOnAction(event -> filterTableSale(saleTable, searchField.getText())); // (m)
    }

    Scene scene = new Scene(vbox);
    stage.setScene(scene);
    fxmlDefPath = fxmlPath;
    stage.show();

  }

  //Search method
  private void filterTableCustomer(TableView<Customer> table, String query) {
    MyModelManager manager = new MyModelManager();
    ObservableList<Customer> customerList = FXCollections.observableArrayList(
        manager.getAllCustomers().getCustomers());
    ObservableList<Customer> filteredList = FXCollections.observableArrayList();
    for (Customer customer : customerList) {
      if (customer.getName().toLowerCase().contains(query.toLowerCase()) ||
          customer.getName().toUpperCase().contains(query.toUpperCase()) ||
          String.valueOf(customer.getCustomerID()).contains(query) ||
          customer.getEmail().toLowerCase().contains(query.toLowerCase())) {
        filteredList.add(customer);
      }
    }
    table.setItems(filteredList);

  }

  private void filterTablePet(TableView<Pet> table, String query) {
    MyModelManager manager = new MyModelManager();
    ObservableList<Pet> petList = FXCollections.observableArrayList(
        manager.getAllPets().getPets());
    ObservableList<Pet> filteredList = FXCollections.observableArrayList();
    for (Pet pet : petList) {
      if (pet.getName().toLowerCase().contains(query.toLowerCase()) ||
          pet.getName().toUpperCase().contains(query.toUpperCase())
         || String.valueOf(pet.getPetID()).contains(query) ) {
        filteredList.add(pet);
      }
    }
    table.setItems(filteredList);
  }

  private void filterTableSale(TableView<Sale> table, String query) {
    MyModelManager manager = new MyModelManager();
    ObservableList<Sale> saleList = FXCollections.observableArrayList(
        manager.getAllSales().getSaleList());
    ObservableList<Sale> filteredList = FXCollections.observableArrayList();
    for (Sale sale : saleList) {
      if (String.valueOf(sale.getSaleID()).contains(query) ||
          String.valueOf(sale.getSalePrice()).contains(query)) {
        // search by pet name etc... has to be added in the Sale class (get SalePet method)
        filteredList.add(sale);
      }
    }
    table.setItems(filteredList);
  }

  private void filterTableBooking(TableView<Booking> table, String query) {
    MyModelManager manager = new MyModelManager();
    ObservableList<Booking> bookingList = FXCollections.observableArrayList(
        manager.getAllBookings().getBookings());
    ObservableList<Booking> filteredList = FXCollections.observableArrayList();
    for (Booking booking : bookingList) {
      if (booking.getCustomer().getName().toLowerCase().contains(query.toLowerCase()) ||
          booking.getCustomer().getName().toUpperCase().contains(query.toUpperCase()) ||
          String.valueOf(booking.getBookingID()).contains(query)) {
        filteredList.add(booking);
      }

    }

    table.setItems(filteredList);
  }
  // Create a separate method for popup handling
  @FXML public void showPopup(ActionEvent e) throws IOException
  {

    Object source = e.getSource();
    // Create a new stage for the popup
    Stage popupStage = new Stage();

    String fxmlPath;
    if (source == dogMenuItem || source == catMenuItem)
    {
      fxmlPath = "fxml/pets/AddDogCatPetView.fxml";
      popupStage.setTitle("Add " + (source == dogMenuItem ? "Dog" : "Cat"));
    }
    else if (source == birdMenuItem)
    {
      fxmlPath = "fxml/pets/BirdPetView.fxml";
      popupStage.setTitle("Add Bird");
    }
    else if (source == fishMenuItem)
    {
      fxmlPath = "fxml/pets/FishPetView.fxml";
      popupStage.setTitle("Add Fish");
    }
    else if (source == rodentMenuItem || source == variousMenuItem)
    {
      fxmlPath = "fxml/pets/RodentVariousPetView.fxml";
      popupStage.setTitle(
          "Add " + (source == rodentMenuItem ? "Rodent" : "Various"));

    }
    else if (source == addCustomerMenuItem || source == addCustomerButton)
    {
      fxmlPath = "fxml/Customers/AddCustomer.fxml";
      popupStage.setTitle("Add Customer");
    }
    else if (source == addBookingMenuItem || source == addBookingButton)
    {
      fxmlPath = "fxml/bookings/AddBooking.fxml";
      popupStage.setTitle("Add Booking");
    }
    else if (source == addSaleMenuItem)
    {
      fxmlPath = "fxml/sales/AddSale.fxml";
      popupStage.setTitle("Add Sale");
    }
    else if (source == bookingsSettingsMenuItem)
    {
      fxmlPath = "fxml/currentlyworking/BookingSettingsView.fxml";
      popupStage.setTitle("Settings");
    }
    else
    {
      fxmlPath = fxmlDefPath;
    }
    if (source instanceof MenuItem menuItem)
    {
      lastPopupSource = menuItem.getId();
    }
    else if (source instanceof Button button)
    {
      lastPopupSource = button.getId();
    }
    // Set the modality of the popup (optional)
    popupStage.initModality(
        Modality.APPLICATION_MODAL); // Makes the popup modal (blocks other windows)

    // Create the scene for the popup window
    try
    {
      root = FXMLLoader.load(getClass().getResource(fxmlPath));
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
      System.out.println("Failed to load resource: " + fxmlPath);
    }

    Scene popupScene = new Scene(root);
    popupStage.setScene(popupScene);

    // Show the popup window
    popupStage.showAndWait();// This will block the main window until the popup is closed
//    switchScene(e);

  }
  
  public void initPetlist()
  {
    MyModelManager manager = new MyModelManager();

    ObservableList<Pet> pets = FXCollections.observableArrayList(
        manager.getAllPets().getPets());

    // Create TableView
    petTable = new TableView<>(pets);
    //    petTable.setItems(pets);

    // Create columns for each field in the Pet class
    petIDPetView = new TableColumn<>("Pet ID");
    petIDPetView.setCellValueFactory(
        cellData -> new SimpleIntegerProperty(cellData.getValue().getPetID()));
    petIDPetView.setStyle("-fx-alignment: CENTER;");

    petTypePetView = new TableColumn<>("Type of animal");
    petTypePetView.setCellValueFactory(cellData -> new SimpleStringProperty(
        cellData.getValue().getClass().getSimpleName()));
    petTypePetView.setStyle("-fx-alignment: CENTER;");

    petLocationPetView = new TableColumn<>("Location");
    petLocationPetView.setCellValueFactory(cellData -> new SimpleStringProperty(
        cellData.getValue().getLocation()));
    petLocationPetView.setStyle("-fx-alignment: CENTER;");

    petStatusPetView = new TableColumn<>("Status");
    petStatusPetView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));
    petStatusPetView.setStyle("-fx-alignment: CENTER;");

    petNamePetView = new TableColumn<>("Name");
    petNamePetView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getName()));
    petNamePetView.setStyle("-fx-alignment: CENTER;");

    petColorPetView = new TableColumn<>("Color");
    petColorPetView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
    petColorPetView.setStyle("-fx-alignment: CENTER;");

    petGenderPetView = new TableColumn<>("Gender");
    petGenderPetView.setCellValueFactory(cellData -> new SimpleStringProperty(
        String.valueOf(cellData.getValue().getGender())));
    petGenderPetView.setStyle("-fx-alignment: CENTER;");

    petCommentPetView = new TableColumn<>("Comment");
    petCommentPetView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getComment()));
    petCommentPetView.setStyle("-fx-alignment: CENTER;");

    petPricePetView = new TableColumn<>("Price");
    petPricePetView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getPrice() + " kr."));
    petPricePetView.setStyle("-fx-alignment: CENTER;");

    // Add columns to the table
    petTable.getColumns()
        .addAll(petIDPetView, petTypePetView, petLocationPetView,
            petStatusPetView, petNamePetView, petColorPetView, petGenderPetView,
            petCommentPetView, petPricePetView);
    petTable.refresh();

    addActionsPetTable();

  }

  public void initCustomerList()
  {
    MyModelManager manager = new MyModelManager();

    ObservableList<Customer> customers = FXCollections.observableArrayList(
        manager.getAllCustomers().getCustomers());

    customerTable = new TableView<>(customers);

    customerIDView = new TableColumn<>("Customer ID");
    customerIDView.setCellValueFactory(cellData -> new SimpleIntegerProperty(
        cellData.getValue().getCustomerID()));
    customerIDView.setStyle("-fx-alignment: CENTER;");

    customerNameView = new TableColumn<>("Name");
    customerNameView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getName()));
    customerNameView.setStyle("-fx-alignment: CENTER;");

    phoneNumberView = new TableColumn<>("Phone Number");
    phoneNumberView.setCellValueFactory(cellData -> new SimpleIntegerProperty(
        cellData.getValue().getPhoneNumber()));
    phoneNumberView.setStyle("-fx-alignment: CENTER;");

    emailView = new TableColumn<>("Email");
    emailView.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
    emailView.setStyle("-fx-alignment: CENTER;");

    customerTable.getColumns()
        .addAll(customerIDView, customerNameView, phoneNumberView, emailView);

    customerTable.refresh();

    addActionsCustomerTable();
  }

  public void initBookingList()
  {
    MyModelManager manager = new MyModelManager();

    ObservableList<Booking> bookings = FXCollections.observableArrayList(
        manager.getAllBookings().getBookings());

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    bookingTable = new TableView<>(bookings);

    bookingIDView = new TableColumn<>("Booking ID");
    bookingIDView.setCellValueFactory(cellData -> new SimpleIntegerProperty(
        cellData.getValue().getBookingID()));
    bookingIDView.setStyle("-fx-alignment: CENTER;");

    petNameBookingView = new TableColumn<>("Pet Name");
    petNameBookingView.setCellValueFactory(cellData -> new SimpleStringProperty(
        cellData.getValue().getPet().getName()));
    petNameBookingView.setStyle("-fx-alignment: CENTER;");

    customerNameBookingView = new TableColumn<>("Customer Name");
    customerNameBookingView.setCellValueFactory(
        cellData -> new SimpleStringProperty(
            cellData.getValue().getCustomer().getName()));
    customerNameBookingView.setStyle("-fx-alignment: CENTER;");

    startDateBookingView = new TableColumn<>("Start Date");
    startDateBookingView.setCellValueFactory(
        cellData -> new SimpleStringProperty(
            cellData.getValue().getDateInterval().getStartDate()
                .format(formatter)));
    startDateBookingView.setStyle("-fx-alignment: CENTER;");

    endDateBookingView = new TableColumn<>("End Date");
    endDateBookingView.setCellValueFactory(cellData -> new SimpleStringProperty(
        cellData.getValue().getDateInterval().getEndDate().format(formatter)));
    endDateBookingView.setStyle("-fx-alignment: CENTER;");

//WE DON'T NEED THIS ANYMORE
//    startHourBookingView = new TableColumn<>("Start Hour");
//    startHourBookingView.setCellValueFactory(cellData -> new SimpleStringProperty(
//        cellData.getValue().getDateInterval().getStartDate().getHour()+":00"));
//    startHourBookingView.setStyle("-fx-alignment: CENTER;");
//
//    endHourBookingView = new TableColumn<>("End Hour");
//    endHourBookingView.setCellValueFactory(cellData -> new SimpleStringProperty(
//        cellData.getValue().getDateInterval().getEndDate().getHour()+":00"));
//    endHourBookingView.setStyle("-fx-alignment: CENTER;");

    bookingTable.getColumns()
        .addAll(bookingIDView, petNameBookingView, customerNameBookingView,
            startDateBookingView, endDateBookingView);

    bookingTable.refresh();

    addActionsBookingTable();
  }

  public void initSaleList()
  {
    MyModelManager manager = new MyModelManager();

    ObservableList<Sale> sales = FXCollections.observableArrayList(
        manager.getAllSales().getSaleList());

    saleTable = new TableView<>(sales);

    saleIDView = new TableColumn<>("Sale ID");
    saleIDView.setCellValueFactory(
        cellData -> new SimpleIntegerProperty(cellData.getValue().getSaleID()));
    saleIDView.setStyle("-fx-alignment: CENTER;");

    petNameSaleView = new TableColumn<>("Pet Name");
    petNameSaleView.setCellValueFactory(cellData -> new SimpleStringProperty(
        cellData.getValue().getPet().getName()));
    petNameSaleView.setStyle("-fx-alignment: CENTER;");

    customerNameSaleView = new TableColumn<>("Customer Name");
    customerNameSaleView.setCellValueFactory(
        cellData -> new SimpleStringProperty(
            cellData.getValue().getCustomer().getName()));
    customerNameSaleView.setStyle("-fx-alignment: CENTER;");

    priceSaleView = new TableColumn<>("Price");
    priceSaleView.setCellValueFactory(cellData -> new SimpleStringProperty(
        String.format("%.2f", cellData.getValue().getSalePrice())));
    priceSaleView.setStyle("-fx-alignment: CENTER;");

    saleTable.getColumns()
        .addAll(saleIDView, petNameSaleView, customerNameSaleView,
            priceSaleView);

    saleTable.refresh();

    addActionsSaleTable();
  }

  private void addActionsPetTable()
  {
    actionsPetView = new TableColumn<>("Actions");

    actionsPetView.setCellFactory(column -> new TableCell<Pet, Void>()
    {
      @Override protected void updateItem(Void item, boolean empty)
      {
        super.updateItem(item, empty);

        if (empty)
        {
          setGraphic(null);
        }
        else
        {
          Button editButton = new Button("Edit");
          Button deleteButton = new Button("Delete");
          HBox actionButtons = new HBox(10, editButton, deleteButton);
          actionButtons.setAlignment(Pos.CENTER);

          editButton.setOnAction(event -> {
            Pet selectedPet = getTableView().getItems().get(getIndex());
            DogPetViewController controller = new DogPetViewController();
            controller.handleEditAction(selectedPet);

//            if (selectedPet instanceof Dog) {
//              controller.saveEditDog((Dog) selectedPet);
//            }

          });

          deleteButton.setOnAction(event -> {
            // Create a Confirmation Alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirm your action");
            alert.setHeaderText(null);
            alert.setContentText("Do you really want to delete this " + getTableView().getItems().get(getIndex()).getClass().getSimpleName().toLowerCase() + "?");

            // Use default ButtonTypes
            ButtonType yesButtonType = ButtonType.YES;    // Default "Yes" button
            ButtonType noButtonType = ButtonType.CANCEL; // Default "No" button

            // Add ButtonTypes to the Alert
            alert.getButtonTypes().setAll(yesButtonType, noButtonType);

            // Access DialogPane and get Buttons
            DialogPane dialogPane = alert.getDialogPane();
            Button yesButton = (Button) dialogPane.lookupButton(yesButtonType);
            Button noButton = (Button) dialogPane.lookupButton(noButtonType);

            // Set actions for "Yes" and "No" buttons
            yesButton.setOnAction(response -> {
              MyModelManager manager = new MyModelManager();
              try
              {
                // Perform the deletion
                manager.deletePet(getTableView().getItems().get(getIndex()).getPetID());

                // Optionally, remove the item from the table view
                getTableView().getItems().remove(getIndex());
              }
              catch (IOException e)
              {
                throw new RuntimeException(e);
              }
              alert.close(); // Close the alert if needed
            });

            noButton.setOnAction(response -> {
              alert.close(); // Close the alert if needed
            });

            // Show the Alert
            alert.showAndWait();

          });

          setGraphic(actionButtons);
        }
      }
    });

    petTable.getColumns().add(actionsPetView);
  }

  private void addActionsCustomerTable()
  {
    actionsCustomerView = new TableColumn<>("Actions");

    actionsCustomerView.setCellFactory(column -> new TableCell<Customer, Void>()
    {
      @Override protected void updateItem(Void item, boolean empty)
      {
        super.updateItem(item, empty);

        if (empty)
        {
          setGraphic(null);
        }
        else
        {
          Button editButton = new Button("Edit");
          Button deleteButton = new Button("Delete");
          HBox actionButtons = new HBox(10, editButton, deleteButton);
          actionButtons.setAlignment(Pos.CENTER);

          editButton.setOnAction(event -> {
            Customer customer = getTableView().getItems().get(getIndex());
            // handleEditAction(customer);

          });

          deleteButton.setOnAction(event -> {
            // Create a Confirmation Alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirm your action");
            alert.setHeaderText(null);
            alert.setContentText("Do you really want to delete this " + getTableView().getItems().get(getIndex()).getClass().getSimpleName().toLowerCase() + "?");

            // Use default ButtonTypes
            ButtonType yesButtonType = ButtonType.YES;    // Default "Yes" button
            ButtonType noButtonType = ButtonType.CANCEL; // Default "No" button

            // Add ButtonTypes to the Alert
            alert.getButtonTypes().setAll(yesButtonType, noButtonType);

            // Access DialogPane and get Buttons
            DialogPane dialogPane = alert.getDialogPane();
            Button yesButton = (Button) dialogPane.lookupButton(yesButtonType);
            Button noButton = (Button) dialogPane.lookupButton(noButtonType);

            // Set actions for "Yes" and "No" buttons
            yesButton.setOnAction(response -> {
              MyModelManager manager = new MyModelManager();
              try
              {
                // Perform the deletion
                manager.deleteCustomer(getTableView().getItems().get(getIndex()).getCustomerID());

                // Optionally, remove the item from the table view
                getTableView().getItems().remove(getIndex());
              }
              catch (IOException e)
              {
                throw new RuntimeException(e);
              }
              alert.close(); // Close the alert if needed
            });

            noButton.setOnAction(response -> {
              alert.close(); // Close the alert if needed
            });

            // Show the Alert
            alert.showAndWait();

          });

          setGraphic(actionButtons);
        }
      }
    });

    customerTable.getColumns().add(actionsCustomerView);
  }

  private void addActionsBookingTable()
  {
    actionsBookingView = new TableColumn<>("Actions");

    actionsBookingView.setCellFactory(column -> new TableCell<Booking, Void>()
    {
      @Override protected void updateItem(Void item, boolean empty)
      {
        super.updateItem(item, empty);

        if (empty)
        {
          setGraphic(null);
        }
        else
        {
          Button editButton = new Button("Edit");
          Button deleteButton = new Button("Delete");
          HBox actionButtons = new HBox(10, editButton, deleteButton);
          actionButtons.setAlignment(Pos.CENTER);

          editButton.setOnAction(event -> {
            Booking booking = getTableView().getItems().get(getIndex());
            // handleEditAction(booking);

          });

          deleteButton.setOnAction(event -> {
            // Create a Confirmation Alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirm your action");
            alert.setHeaderText(null);
            alert.setContentText("Do you really want to delete this " + getTableView().getItems().get(getIndex()).getClass().getSimpleName().toLowerCase() + "?");

            // Use default ButtonTypes
            ButtonType yesButtonType = ButtonType.YES;    // Default "Yes" button
            ButtonType noButtonType = ButtonType.CANCEL; // Default "No" button

            // Add ButtonTypes to the Alert
            alert.getButtonTypes().setAll(yesButtonType, noButtonType);

            // Access DialogPane and get Buttons
            DialogPane dialogPane = alert.getDialogPane();
            Button yesButton = (Button) dialogPane.lookupButton(yesButtonType);
            Button noButton = (Button) dialogPane.lookupButton(noButtonType);

            // Set actions for "Yes" and "No" buttons
            yesButton.setOnAction(response -> {
              MyModelManager manager = new MyModelManager();
              try
              {
                // Perform the deletion
                manager.deleteBooking(getTableView().getItems().get(getIndex()).getBookingID());

                // Remove the item from the table view
                getTableView().getItems().remove(getIndex());
              }
              catch (IOException e)
              {
                throw new RuntimeException(e);
              }
              alert.close(); // Close the alert if needed
            });

            noButton.setOnAction(response -> {
              alert.close(); // Close the alert if needed
            });

            // Show the Alert
            alert.showAndWait();

          });

          setGraphic(actionButtons);
        }

      }
    });

    bookingTable.getColumns().add(actionsBookingView);
  }

  private void addActionsSaleTable()
  {
    actionsSaleView = new TableColumn<>("Actions");

    actionsSaleView.setCellFactory(column -> new TableCell<Sale, Void>()
    {
      @Override protected void updateItem(Void item, boolean empty)
      {
        super.updateItem(item, empty);

        if (empty)
        {
          setGraphic(null);
        }
        else
        {
          Button editButton = new Button("Edit");
          Button deleteButton = new Button("Delete");
          HBox actionButtons = new HBox(10, editButton, deleteButton);
          actionButtons.setAlignment(Pos.CENTER);

          editButton.setOnAction(event -> {
            Sale sale = getTableView().getItems().get(getIndex());
            // handleEditAction(sale);

          });

          deleteButton.setOnAction(event -> {
            // Create a Confirmation Alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirm your action");
            alert.setHeaderText(null);
            alert.setContentText("Do you really want to delete this " + getTableView().getItems().get(getIndex()).getClass().getSimpleName().toLowerCase() + "?");

            // Use default ButtonTypes
            ButtonType yesButtonType = ButtonType.YES;    // Default "Yes" button
            ButtonType noButtonType = ButtonType.CANCEL; // Default "No" button

            // Add ButtonTypes to the Alert
            alert.getButtonTypes().setAll(yesButtonType, noButtonType);

            // Access DialogPane and get Buttons
            DialogPane dialogPane = alert.getDialogPane();
            Button yesButton = (Button) dialogPane.lookupButton(yesButtonType);
            Button noButton = (Button) dialogPane.lookupButton(noButtonType);

            // Set actions for "Yes" and "No" buttons
            yesButton.setOnAction(response -> {
              MyModelManager manager = new MyModelManager();
              try
              {
                // Perform the deletion
                manager.deleteSale(getTableView().getItems().get(getIndex()).getSaleID());

                // Remove the item from the table view
                getTableView().getItems().remove(getIndex());
              }
              catch (IOException e)
              {
                throw new RuntimeException(e);
              }
              alert.close(); // Close the alert if needed
            });

            noButton.setOnAction(response -> {
              alert.close(); // Close the alert if needed
            });

            // Show the Alert
            alert.showAndWait();

          });

          setGraphic(actionButtons);
        }

      }
    });

    saleTable.getColumns().add(actionsSaleView);
  }
}
