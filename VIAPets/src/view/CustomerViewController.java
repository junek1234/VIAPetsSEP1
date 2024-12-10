package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.*;
import utils.XMLHandler;

import java.io.IOException;

public class CustomerViewController
{

  @FXML private TextField customerNameTextField;
  @FXML private TextField customerPhoneNumberTextField;
  @FXML private TextField customerEmailTextField;

  @FXML private Button saveButton;


  public void saveAddCustomer(ActionEvent actionEvent)
  {
    int number;
    if(customerPhoneNumberTextField.getText().isEmpty())
    {
      number=0;
    }
    else
    {
      number=Integer.parseInt(customerPhoneNumberTextField.getText());
    }

    String name = customerNameTextField.getText();
    String email = customerEmailTextField.getText();











   Customer newCustomer = new Customer(MyModelManager.createNextCustomerID(),name,number,email);

    System.out.println(newCustomer);
    MyModelManager manager = new MyModelManager();
    try
    {
      manager.addCustomer(newCustomer);

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
    customerNameTextField.clear();
    customerPhoneNumberTextField.clear();
    customerEmailTextField.clear();


  }


}








