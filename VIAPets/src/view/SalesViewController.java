package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    int petID = 0;//need to add exception later
    int customerID = 0;//need to add exception later
    int salePrice=0;
    if(salePetIDTextField.getText().isEmpty())
    {
      System.out.println("Error: Enter pet ID"); //later in exceptions
    }
    else
    {
      petID=Integer.parseInt(salePetIDTextField.getText());
    }


    if(saleCustomerIDTextField.getText().isEmpty())
    {
      System.out.println("Error: Enter customer ID"); //later in exceptions
    }
    else
    {
      customerID=Integer.parseInt(saleCustomerIDTextField.getText());
    }

    if(saleSalePriceTextField.getText().isEmpty())
    {
      System.out.println("Error: Enter Start Hour"); //later in exceptions
    }
    else
    {
      salePrice=Integer.parseInt(saleSalePriceTextField.getText());
    }


    MyModelManager manager = new MyModelManager();


    Pet salePet=manager.getAllPets().getPetByID(petID);
    Customer saleCustomer=manager.getAllCustomers().getCustomer(customerID);


    //if everything is fine

   Sale newSale = new Sale(MyModelManager.createNextSaleID(),saleCustomer, salePet, salePrice);
    System.out.println(newSale);
    try
    {
      manager.addSale(newSale);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }


    XMLHandler.updateXML();




    clearFields();
  }

  @FXML
  private void clearFields() {
    salePetIDTextField.clear();
    saleCustomerIDTextField.clear();
    saleSalePriceTextField.clear();


  }


}








