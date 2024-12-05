package View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerViewController implements Initializable {
  private ObservableList<Customer> customerList = FXCollections.observableArrayList();

  @FXML
  private TableView<Customer> customerTable;

  @FXML
  private TableColumn<Customer, String> customerIDColumn;

  @FXML
  private TableColumn<Customer, String> nameColumn;

  @FXML
  private TableColumn<Customer, String> phoneNumberColumn;

  @FXML
  private TableColumn<Customer, String> emailColumn;

  @FXML
  private TableColumn<Customer, Void> actionColumn;

  public void initialize(URL location, ResourceBundle resources) {
    customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

    addActionButtons();

    customerTable.setItems(customerList);
  }

  private void addActionButtons() {
    actionColumn.setCellFactory(param -> new TableCell<>() {
      private final Button editButton = new Button("Edit");
      private final Button deleteButton = new Button("Delete");

      {
        editButton.setOnAction(event -> {
          Customer customer = getTableView().getItems().get(getIndex());
          handleEditCustomer(customer);
        });

        deleteButton.setOnAction(event -> {
          Customer customer = getTableView().getItems().get(getIndex());
          handleDeleteCustomer(customer);
        });
      }

    });
  }

  private void handleEditCustomer(Customer customer) {
    customer.setName("");
    customerTable.refresh();
  }

  private void handleDeleteCustomer(Customer customer) {
    customerList.remove(customer);
  }
}
