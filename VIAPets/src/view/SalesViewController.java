package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

  @FXML private Button saveAddSale;


  public void saveAddSale(ActionEvent actionEvent)
  {
    int petID = 0;
    int customerID = 0;
    int salePrice=0;
    if(salePetIDTextField.getText().isEmpty()||saleCustomerIDTextField.getText().isEmpty()||saleSalePriceTextField.getText().isEmpty())
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

          Customer saleCustomer = manager.getAllCustomers()
              .getCustomer(customerID);

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

}








