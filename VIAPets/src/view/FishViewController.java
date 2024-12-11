package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.*;
import utils.XMLHandler;

import javax.swing.text.View;
import java.io.IOException;

public class FishViewController
{

  @FXML private TextField petNameTextField;
  @FXML private TextField petColorTextField;
  @FXML private TextField petAgeTextField;
  @FXML private TextField petPriceTextField;

  @FXML private TextArea petCommentTextField;


  @FXML private RadioButton petGenderMaleRadioButton;
  @FXML private RadioButton petGenderFemaleRadioButton;
  @FXML private RadioButton petLocationShopRadioButton;
  @FXML private RadioButton petLocationKennelRadioButton;
  @FXML private RadioButton petStatusSoldRadioButton;
  @FXML private RadioButton petStatusNotSoldRadioButton;
  @FXML private RadioButton petStatusNotFromViaRadioButton;
  @FXML private RadioButton petSaltWaterYesRadioButton;
  @FXML private RadioButton petSaltWaterNoRadioButton;
  @FXML private RadioButton petPredatorYesRadioButton;
  @FXML private RadioButton petPredatorNoRadioButton;
  @FXML private TextField petSpeciesTextField;

  @FXML private Button petSaveButton;


  public void saveAddPet(ActionEvent actionEvent)
  {
    String species = petSpeciesTextField.getText();
    String name = petNameTextField.getText();
    String color = petColorTextField.getText();
    int age;
    if(petAgeTextField.getText().isEmpty())
    {
      age=0;
    }
    else
    {
      age=Integer.parseInt(petAgeTextField.getText());
    }
    double price;
    if(petPriceTextField.getText().isEmpty())
    {
      price=0.0;
    }
    else
    {
      price = Double.parseDouble(petPriceTextField.getText());
    }

    String comment = petCommentTextField.getText();
    boolean isSaltWater = petSaltWaterYesRadioButton.isSelected() ? true :
        petSaltWaterNoRadioButton.isSelected() ? false : false;

    boolean isPredator = petPredatorYesRadioButton.isSelected() ? true :
        petPredatorNoRadioButton.isSelected() ? false : false;





    // Get RadioButton values
    char gender = petGenderMaleRadioButton.isSelected() ? 'm' :
        petGenderFemaleRadioButton.isSelected() ? 'f' : '-';

    String location = petLocationShopRadioButton.isSelected() ? "Shop" :
        petLocationKennelRadioButton.isSelected() ? "Kennel" : "";

    String status = petStatusSoldRadioButton.isSelected() ? "Sold" :
        petStatusNotSoldRadioButton.isSelected() ? "Not Sold" :
            petStatusNotFromViaRadioButton.isSelected() ? "Not From Via" : "";




    Fish newPet = new Fish(MyModelManager.createNextPetID(),name, color,age,gender,
        location,status, isSaltWater,  species, isPredator, price, comment);
    System.out.println(newPet);
    MyModelManager manager = new MyModelManager();
    try
    {
      manager.addPet(newPet);

    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }

    clearFields();
    XMLHandler.updateXML();




    clearFields();
  }

  @FXML
  private void clearFields() {
    petNameTextField.clear();
    petColorTextField.clear();
    petAgeTextField.clear();
    petPriceTextField.clear();
    petCommentTextField.clear();
    petSpeciesTextField.clear();



  }


}







