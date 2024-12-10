package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.MyModelManager;
import model.Customer;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Pet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable
{
  MyModelManager customerManager = new MyModelManager();

  private ObservableList<Customer> customerList = FXCollections.observableArrayList(
      new Customer(00,"mara", 99,"@kkaf")
  );

  @FXML private TableView<Customer> customerTable;
  @FXML private TableColumn<Customer, Number> customerIDColumn;
  @FXML private TableColumn<Customer, String> nameColumn;
  @FXML private TableColumn<Customer, Number> phoneNumberColumn;
  @FXML private TableColumn<Customer, String> emailColumn;
  @FXML private TableColumn<Customer, Void> actionColumn;

  public void initialize(URL location, ResourceBundle resources) {

    customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

    customerTable.setItems(customerList);
  }

  // default customer view
  @FXML Button addCustomerButton;
  @FXML Button editCustomerButton;
  @FXML Button deleteCustomerButton;
  @FXML Button searchButton;
  @FXML TextField searchBarTextField;

  // add customer view
  @FXML TextField CustomerIDTextField;
  @FXML TextField nameTextField;
  @FXML TextField PhoneNumberTextField;
  @FXML TextField emailTextField;
  @FXML Button addButton;

  public void addTest(ActionEvent e)
  {
    System.out.println("works?");
  }
}

/*
  @FXML
  private void handleSaveButton() {
    // Example fields
    String name = nameField.getText();
    String age = ageField.getText();
    String species = speciesField.getText();
    String color = colorField.getText();
    String gender = genderField.getText();
    String comment = commentArea.getText();
    String location = shopRadioButton.isSelected() ? "Shop" : "Kennel"; // Example for radio buttons
    boolean isSold = soldRadioButton.isSelected();


  }*/

