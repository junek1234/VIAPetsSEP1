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
    if(salePetIDTextField.getText().isEmpty())
    {
      System.out.println("Error: no pet ID");
    }
    else
    {
      petID=Integer.parseInt(salePetIDTextField.getText());
    }


    if(saleCustomerIDTextField.getText().isEmpty())
    {
      System.out.println("Error: no customer ID");
    }
    else
    {
      customerID=Integer.parseInt(saleCustomerIDTextField.getText());
    }

    if(saleSalePriceTextField.getText().isEmpty())
    {
      System.out.println("Error: no Price");
    }
    else
    {
      salePrice=Integer.parseInt(saleSalePriceTextField.getText());
    }

    MyModelManager manager = new MyModelManager();
    Pet salePet = manager.getAllPets().getPetByID(petID);



    Customer saleCustomer = manager.getAllCustomers().getCustomer(customerID);
    System.out.println(salePet.getStatus());
    //errors
    if(salePet==null)
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("No pet with ID: "+petID+"!");
      alert1.show();

    }
    else if(salePet.getLocation().equals("Kennel"))
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("This pet is from the kennel!");
      alert1.show();
    }
    else if(!salePet.getStatus().equals("Not Sold"))
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("This pet is not for sale!");
      alert1.show();
    }
    else if (saleCustomer==null)
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("No customer with ID: "+customerID+"!");
      alert1.show();
    }
    else if(saleSalePriceTextField.getText().isEmpty())
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("Enter price!");
      alert1.show();
    } else
    {


      //if everything is fine


      try
      {
        salePet.setStatus("Sold");
        manager.editPet(petID,salePet);

        System.out.println(salePet);
        Sale newSale = new Sale(MyModelManager.createNextSaleID(), saleCustomer,
            salePet, salePrice);
        System.out.println(newSale);
        System.out.println(newSale.getPet());
        manager.addSale(newSale);
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
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








