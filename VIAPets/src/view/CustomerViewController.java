package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    if(customerNameTextField.getText().isEmpty()||customerEmailTextField.getText().isEmpty()||customerPhoneNumberTextField.getText().isEmpty())
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("Invalid input!");
      alert1.show();
    }
    else
    {
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

  }

  @FXML
  private void clearFields() {
    customerNameTextField.clear();
    customerPhoneNumberTextField.clear();
    customerEmailTextField.clear();


  }


}








