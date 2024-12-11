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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.*;


import javafx.scene.control.TableColumn;


import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ViewHandler
{
  public static String lastPopupSource;
  //for PetViewController
  //  @FXML private TextField petNameTextField;
  //  @FXML private TextField petColorTextField;
  //  @FXML private TextField petAgeTextField;
  //  @FXML private TextField petPriceTextField;
  //
  //  @FXML private TextArea petCommentTextField;
  //
  //  @FXML private RadioButton petGenderMaleRadioButton;
  //  @FXML private RadioButton petGenderFemaleRadioButton;
  //  @FXML private RadioButton petLocationShopRadioButton;
  //  @FXML private RadioButton petLocationKennelRadioButton;
  //  @FXML private RadioButton petStatusSoldRadioButton;
  //  @FXML private RadioButton petStatusNotSoldRadioButton;
  //  @FXML private RadioButton petStatusNotFromViaRadioButton;

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

  //tables
  @FXML private TableView<Pet> petTable;
  @FXML private TableColumn<Pet, Number> petIDPetView;
  @FXML private TableColumn<Pet, String> petTypePetView;
  @FXML private TableColumn<Pet, String> petLocationPetView;
  @FXML private TableColumn<Pet, String> petStatusPetView;
  @FXML private TableColumn<Pet, String> petNamePetView;
  @FXML private TableColumn<Pet, String> petColorPetView;
  @FXML private TableColumn<Pet, String> petGenderPetView;
  @FXML private TableColumn<Pet, String> petCommentPetView;
  @FXML private TableColumn<Pet, Void> actionsPetView;

  @FXML private TableView<Customer> customerTable;
  @FXML private TableColumn<Customer, Number> customerIDView;
  @FXML private TableColumn<Customer, String> customerNameView;
  @FXML private TableColumn<Customer, Number> phoneNumberView;
  @FXML private TableColumn<Customer, String> emailView;
  @FXML private TableColumn<Customer, Void> actionsCustomerView;

  @FXML private TableView<Booking> bookingTable;
  @FXML private TableColumn<Booking, Number> bookingIDView;
  @FXML private TableColumn<Booking, String> petNameBookingView;
  @FXML private TableColumn<Booking, String> customerNameBookingView;
  @FXML private TableColumn<Booking, String> startDateBookingView;
  @FXML private TableColumn<Booking, String> endDateBookingView;
  @FXML private TableColumn<Booking, Void> actionsBookingView;

  @FXML private TableView<Sale> saleTable;
  @FXML private TableColumn<Sale, Number> saleIDView;
  @FXML private TableColumn<Sale, String> petNameSaleView;
  @FXML private TableColumn<Sale, String> customerNameSaleView;
  @FXML private TableColumn<Sale, String> priceSaleView;
  @FXML private TableColumn<Sale, Void> actionsSaleView;

  private Stage stage;  // Keep a reference to the primaryStage
  private Parent root;
  private String fxmlDefPath = "fxml/currentlyworking/DefaultView.fxml";
  VIAPets viaPets = new VIAPets();
  MyModelManager myModelManager = new MyModelManager();
  BirdViewController birdViewController = new BirdViewController();

  @FXML public void switchScene(ActionEvent e) throws IOException
  {
    Object source = e.getSource();
    String fxmlPath;

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
    else if (source == bookingsSettingsMenuItem)
    {
      fxmlPath = "fxml/currentlyworking/BookingSettingsView.fxml";
    }
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
      fxmlPath = fxmlDefPath;
    }

    root = FXMLLoader.load(getClass().getResource(fxmlPath));
    MenuItem mirrorMenuItem = (MenuItem) source;
    stage = (Stage) mirrorMenuItem.getParentPopup().getOwnerWindow();
    VBox vbox = new VBox();
    vbox.getChildren().add(root);

    if (source == petsMenuItem)
    {
      vbox.getChildren().add(petTable);
    }

    else if (source == customersMenuItem)
    {
      vbox.getChildren().add(customerTable);
    }

    else if (source == bookingsMenuItem)
    {
      vbox.getChildren().add(bookingTable);
    }

    else if (source == salesMenuItem)
    {
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
    if (source == dogMenuItem || source == catMenuItem)
    {
      fxmlPath = "fxml/pets/DogCatPetView.fxml";
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

  }

  public void save()
  {
  }

  public void save(ActionEvent event)
  {
  }

  //  public void addTest(ActionEvent e) {
  //    customerController.addTest(e);
  //  }

  //  public void addPet(Object source) {
  //    petController.addPet(source);
  //  }
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

    // Add columns to the table
    petTable.getColumns()
        .addAll(petIDPetView, petTypePetView, petLocationPetView,
            petStatusPetView, petNamePetView, petColorPetView, petGenderPetView,
            petCommentPetView);
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
          // Buttons are created per cell instance to avoid shared state issues
          Button editButton = new Button("Edit");
          Button deleteButton = new Button("Delete");
          HBox actionButtons = new HBox(10, editButton, deleteButton);
          actionButtons.setAlignment(Pos.CENTER);

          editButton.setOnAction(event -> {
            Pet pet = getTableView().getItems().get(getIndex());
            // handleEditAction(pet); // Replace with your edit logic
          });

          deleteButton.setOnAction(event -> {
            Pet pet = getTableView().getItems().get(getIndex());
            // handleDeleteAction(pet); // Replace with your delete logic
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
          // Buttons are created per cell instance to avoid shared state issues
          Button editButton = new Button("Edit");
          Button deleteButton = new Button("Delete");
          HBox actionButtons = new HBox(10, editButton, deleteButton);
          actionButtons.setAlignment(Pos.CENTER);

          editButton.setOnAction(event -> {
            Customer customer = getTableView().getItems().get(getIndex());
            // handleEditAction(customer); // Replace with your edit logic
          });

          deleteButton.setOnAction(event -> {
            Customer customer = getTableView().getItems().get(getIndex());
            // handleDeleteAction(customer); // Replace with your delete logic
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
          // Buttons are created per cell instance to avoid shared state issues
          Button editButton = new Button("Edit");
          Button deleteButton = new Button("Delete");
          HBox actionButtons = new HBox(10, editButton, deleteButton);
          actionButtons.setAlignment(Pos.CENTER);

          editButton.setOnAction(event -> {
            Booking booking = getTableView().getItems().get(getIndex());
            // handleEditAction(customer); // Replace with your edit logic
          });

          deleteButton.setOnAction(event -> {
            Booking booking = getTableView().getItems().get(getIndex());
            // handleDeleteAction(customer); // Replace with your delete logic
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
          // Buttons are created per cell instance to avoid shared state issues
          Button editButton = new Button("Edit");
          Button deleteButton = new Button("Delete");
          HBox actionButtons = new HBox(10, editButton, deleteButton);
          actionButtons.setAlignment(Pos.CENTER);

          editButton.setOnAction(event -> {
            Sale sale = getTableView().getItems().get(getIndex());
            // handleEditAction(customer); // Replace with your edit logic
          });

          deleteButton.setOnAction(event -> {
            Sale sale = getTableView().getItems().get(getIndex());
            // handleDeleteAction(customer); // Replace with your delete logic
          });

          setGraphic(actionButtons);
        }
      }
    });

    saleTable.getColumns().add(actionsSaleView);
  }

  //  // Helper method to apply center alignment
  //  private void applyCenterAlignment(TableColumn<Pet, ?> column) {
  //    column.setCellFactory(new Callback<TableColumn<Pet, ?>, TableCell<Pet, ?>>() {
  //      @Override
  //      public TableCell<Pet, ?> call(TableColumn<Pet, ?> param) {
  //        return new TableCell<Pet, Object>() {  // Use Object to match any type
  //          @Override
  //          protected void updateItem(Object item, boolean empty) {
  //            super.updateItem(item, empty);
  //
  //            if (empty || item == null) {
  //              setText(null);
  //            } else {
  //              setText(item.toString());  // Convert item to String if it's not null
  //              setAlignment(Pos.CENTER); // Center align text
  //            }
  //          }
  //        };
  //      }
  //    });
  //}
}



