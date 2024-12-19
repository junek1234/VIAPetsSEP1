package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import utils.XMLHandler;

import java.io.IOException;

/**
 * Controller class for managing the Customer view.
 * Handles adding, editing, and validating Customer objects.
 * Provides methods to populate, save, and persist customer data.
 *
 *
 * @version 1.0
 * @author Piotr Junosz
 * @author Felipe Figueiredo
 * @author Guillermo Sánchez Martínez
 */
public class CustomerViewController
{

  @FXML private TextField customerNameTextField;
  @FXML private TextField customerPhoneNumberTextField;
  @FXML private TextField customerEmailTextField;

  @FXML private TextField customerNameEditTextField;
  @FXML private TextField customerPhoneNumberEditTextField;
  @FXML private TextField customerEmailEditTextField;

  @FXML private Button customerSaveButton;

  private Customer selectedCustomer;

  /**
   * Saves a new customer based on user input.
   * Validates the input fields and handles errors such as missing fields
   * or incorrect phone number format.
   *
   * @param actionEvent the action event triggered by clicking the save button
   * @throws RuntimeException if there is an error saving the customer data
   */
  public void saveAddCustomer(ActionEvent actionEvent)
  {
    int number = 0;

    if (customerNameTextField.getText().isEmpty()
        || customerEmailTextField.getText().isEmpty()
        || customerPhoneNumberTextField.getText().isEmpty())
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("All inputs must be filled!");
      alert1.show();
    }
    else
    {
      if (!customerPhoneNumberTextField.getText().isEmpty())
      {
        try
        {
          number = Integer.parseInt(customerPhoneNumberTextField.getText());
        }
        catch (NumberFormatException e)
        {
          Alert alert1 = new Alert(Alert.AlertType.ERROR);
          alert1.setTitle("Error");
          alert1.setHeaderText(null);
          alert1.setContentText("Phone number must be a number!");
          alert1.show();
          return;//it stops the method when catching exception
        }
        String name = customerNameTextField.getText();
        String email = customerEmailTextField.getText();

        Customer newCustomer = new Customer(
            MyModelManager.createNextCustomerID(), name, number, email);

        MyModelManager manager = new MyModelManager();
        try
        {
          manager.addCustomer(newCustomer);
          Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene()
              .getWindow();
          stage.close();

        }
        catch (IOException e)
        {
          throw new RuntimeException(e);
        }

        XMLHandler.updateXML();

      }

    }

  }

  /**
   * Saves changes to an existing customer.
   * Validates user input and updates the customer details if confirmed.
   *
   * @param actionEvent the action event triggered by clicking the save button
   */
  public void saveEditCustomer(ActionEvent actionEvent)
  {

    String name = customerNameEditTextField.getText();
    String email = customerEmailEditTextField.getText();

    // Parse numeric fields
    int phoneNumber = 0;
    try
    {
      phoneNumber = Integer.parseInt(
          customerPhoneNumberEditTextField.getText());

    }
    catch (NumberFormatException e)
    {
      // Handle invalid input
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Input Error");
      alert.setHeaderText("Invalid Input");
      alert.setContentText("Please ensure Age and Price are valid numbers.");
      alert.showAndWait();
      return;
    }

    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Save Changes");
    confirmationAlert.setHeaderText(
        "Are you sure you want to save the changes?");
    confirmationAlert.setContentText("Click OK to save or Cancel to cancel.");

    ButtonType result = confirmationAlert.showAndWait()
        .orElse(ButtonType.CANCEL);
    if (result == ButtonType.OK)
    {
      try
      {

        Customer customer = selectedCustomer;

        customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);

        // in the file
        MyModelManager mManager = new MyModelManager();
        mManager.editCustomer(selectedCustomer.getCustomerID(),
            selectedCustomer);

        // Close the edit window
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene()
            .getWindow();
        stage.close();
      }
      catch (IOException e)
      {
        // Handle file write error
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("File Error");
        errorAlert.setHeaderText("Error Saving Changes");
        errorAlert.setContentText(
            "Could not save changes to the file. Please try again.");
        errorAlert.showAndWait();
      }
    }
  }

  /**
   * Populates the edit form with data from the selected customer.
   * Sets the input fields to the customer's current details.
   *
   * @param customer the customer object to populate the form
   */
  public void fillCustomer(Customer customer)
  {

    selectedCustomer = customer;

    customerNameEditTextField.setText(customer.getName());
    customerPhoneNumberEditTextField.setText(
        String.valueOf(customer.getPhoneNumber()));
    customerEmailEditTextField.setText(customer.getEmail());

  }
  /**
   * Opens the edit window for modifying customer details.
   * Loads the FXML for editing a customer
   * as the target for editing.
   *
   * @param customer the customer object to be edited
   */
    public void handleEditAction(Customer customer){
    try
    {

      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("fxml/Customers/EditCustomer.fxml"));
      Parent root = loader.load();

      CustomerViewController controller = loader.getController();

      controller.fillCustomer(customer);

      Stage editStage = new Stage();
      editStage.setTitle("Edit customer");
      editStage.setScene(new Scene(root));
      editStage.initModality(Modality.APPLICATION_MODAL);
      editStage.showAndWait();
    }

    catch (IOException e)
    {
      // Show a log the error message
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Failed to load the edit window.");
      alert.setContentText(
          "There was an error loading the FXML for the edit window.");
      alert.showAndWait();
    }
  }

  }








