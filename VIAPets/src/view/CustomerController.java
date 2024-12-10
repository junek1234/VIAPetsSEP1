//package view;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//import model.*;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class CustomerController
//{
//
//  private MyModelManager customerManager = new MyModelManager();
//
//  private ObservableList<Customer> customerList = FXCollections.observableArrayList(
//      new Customer(1, "mara", 99, "@jnhkla"));
//
//  @FXML private TableView<Customer> customerTable;
//
//  @FXML private TableColumn<Customer, Number> customerIDColumn;
//
//  @FXML private TableColumn<Customer, String> nameColumn;
//
//  @FXML private TableColumn<Customer, Number> phoneNumberColumn;
//
//  @FXML private TableColumn<Customer, String> emailColumn;
//
//  @FXML private TableColumn<Customer, Void> actionColumn;
//
//  // Default customer view
//  @FXML private Button addCustomerButton, editCustomerButton, deleteCustomerButton, searchButton;
//
//  @FXML private TextField searchBarField;
//
//  // Add customer view
//  @FXML private TextField addCustomerIDField, addNameField, addPhoneNumberField, addEmailField;
//
//  @FXML private Button addSaveButton;
//
//  // Edit customer view
//  @FXML private TextField editCustomerIDField, editNameField, editPhoneNumberField, editEmailField;
//
//  @FXML private Button editSaveButton;
//
//  public void initialize(URL location, ResourceBundle resources)
//  {
//
//    customerIDColumn.setCellValueFactory(
//        new PropertyValueFactory<>("customerID"));
//    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//    phoneNumberColumn.setCellValueFactory(
//        new PropertyValueFactory<>("phoneNumber"));
//    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//    customerList.addAll(customerManager.getAllCustomers());
//    customerTable.setItems(customerList);
//
//  }
//}
//
