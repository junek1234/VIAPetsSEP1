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
import java.time.LocalDate;
import java.util.ArrayList;



public class SalesViewController
{

  @FXML private TextField salePetIDTextField;
  @FXML private TextField saleCustomerIDTextField;
  @FXML private TextField saleSalePriceTextField;

  @FXML private TextField salePetIDEditTextField;
  @FXML private TextField saleCustomerIDEditTextField;
  @FXML private TextField saleSalePriceEditTextField;

  @FXML private Button saveAddSale;

  private Sale selectedSale;

  @FXML private Button

      saleSaveButton;

  public void saveAddSale(ActionEvent actionEvent)
  {
    int petID = 0;
    int customerID = 0;
    int salePrice = 0;
    if (salePetIDTextField.getText().isEmpty()
        || saleCustomerIDTextField.getText().isEmpty()
        || saleSalePriceTextField.getText().isEmpty())
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("All inputs must be filled!");
      alert1.show();
    }
    else
    {

      try
      {
        petID = Integer.parseInt(salePetIDTextField.getText());
        customerID = Integer.parseInt(saleCustomerIDTextField.getText());
        salePrice = Integer.parseInt(saleSalePriceTextField.getText());
      }
      catch (NumberFormatException e)
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("All inputs must be numbers!");
        alert1.show();
        return;//it stops the method when catching exception
      }

      MyModelManager manager = new MyModelManager();
      Pet salePet = manager.getAllPets().getPetByID(petID);

      Customer saleCustomer = manager.getAllCustomers().getCustomer(customerID);

      //errors
      if (salePet == null)
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("No pet with ID: " + petID + "!");
        alert1.show();

      }
      else if (salePet.getLocation().equals("Kennel"))
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("This pet is from the kennel do not sell it!");
        alert1.show();
      }
      else if (!salePet.getStatus().equals("Not Sold"))
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("This pet is not for sale!");
        alert1.show();
      }
      else if (saleCustomer == null)
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("No customer with ID: " + customerID + "!");
        alert1.show();
      }
      else
      {

        //if everything is fine

        try
        {
          salePet.setStatus("Sold");
          manager.editPet(petID, salePet);

          Sale newSale = new Sale(MyModelManager.createNextSaleID(),
              saleCustomer, salePet, salePrice);
          manager.addSale(newSale);
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

  public void saveEditSale(ActionEvent actionEvent) {
    String petID = salePetIDEditTextField.getText();
    String customerID = saleCustomerIDEditTextField.getText();
    String priceInput = saleSalePriceEditTextField.getText();

    double price = 0;
    int parsedPetID = 0;
    int parsedCustomerID = 0;

    // Validate numeric fields
    try {
      parsedPetID = Integer.parseInt(petID);
      parsedCustomerID = Integer.parseInt(customerID);
      price = Double.parseDouble(priceInput);
      if (price <= 0) {
        throw new NumberFormatException("Price must be greater than 0.");
      }
    } catch (NumberFormatException e) {
      // Handle invalid input
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Input Error");
      alert.setHeaderText("Invalid Input");
      alert.setContentText("Please ensure Pet ID, Customer ID, and Price are valid numbers.");
      alert.showAndWait();
      return;
    }

    // Confirmation
    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Save Sale");
    confirmationAlert.setHeaderText("Are you sure you want to save this sale?");
    confirmationAlert.setContentText("Click OK to save or Cancel to cancel.");

    ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);
    if (result == ButtonType.OK) {
      try {
        // Retrieve the pet by ID from the PetList
        MyModelManager manager = new MyModelManager();
        PetList petList = manager.getAllPets();
        Pet pet = petList.getPetByID(parsedPetID);

        if (pet == null) {
          Alert petAlert = new Alert(Alert.AlertType.ERROR);
          petAlert.setTitle("Pet Not Found");
          petAlert.setHeaderText("Invalid Pet ID");
          petAlert.setContentText("No pet exists with the provided Pet ID. Please try again.");
          petAlert.showAndWait();
          return;
        }

        // Retrieve the customer by ID from the CustomerList
        CustomerList customerList = manager.getAllCustomers();
        Customer customer = customerList.getCustomerByID(parsedCustomerID);

        if (customer == null) {
          Alert customerAlert = new Alert(Alert.AlertType.ERROR);
          customerAlert.setTitle("Customer Not Found");
          customerAlert.setHeaderText("Invalid Customer ID");
          customerAlert.setContentText("No customer exists with the provided Customer ID. Please try again.");
          customerAlert.showAndWait();
          return;
        }

        // Create the sale object and set details
        Sale sale = selectedSale;
        sale.setPet(pet);
        sale.setCustomer(customer);
        sale.setSalePrice(price);

        // Save the sale to the file or database
        manager.editSale(selectedSale.getSaleID(), selectedSale);

        // Close the window
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
      } catch (IOException e) {
        // Handle file write error
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("File Error");
        errorAlert.setHeaderText("Error Saving Sale");
        errorAlert.setContentText("Could not save the sale. Please try again.");
        errorAlert.showAndWait();
      }


    }
  }

  public void fillSale(Sale sale)
  {
    selectedSale = sale;

    // Set the pet ID
    salePetIDEditTextField.setText(String.valueOf(sale.getPet().getPetID()));

    // Set the customer ID
    saleCustomerIDEditTextField.setText(
        String.valueOf(sale.getCustomer().getCustomerID()));

    // Set the sale price
    saleSalePriceEditTextField.setText(String.valueOf(sale.getSalePrice()));
  }

  public void handleEditAction(Sale sale) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/sales/EditSale.fxml"));
      Parent root = loader.load();

      SalesViewController controller = loader.getController();

      controller.fillSale(sale);  // Pass the Sale object to the controller for filling the fields

      Stage editStage = new Stage();
      editStage.setTitle("Edit Sale");
      editStage.setScene(new Scene(root));
      editStage.initModality(Modality.APPLICATION_MODAL);
      editStage.showAndWait();
    } catch (IOException e) {
      // Show a log the error message
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Failed to load the edit window.");
      alert.setContentText("There was an error loading the FXML for the edit window.");
      alert.showAndWait();
    }
  }


}








