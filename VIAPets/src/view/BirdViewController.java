package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

import javafx.scene.control.RadioButton;
import utils.XMLHandler;

import javax.swing.*;
import javax.swing.text.View;
import java.io.IOException;

public class BirdViewController
{

  @FXML private TextField petNameTextField;
  @FXML private TextField petColorTextField;
  @FXML private TextField petAgeTextField;
  @FXML private TextField petPriceTextField;

  @FXML private TextArea petCommentTextField;
  @FXML private TextField birdSpeciesTextField;
  @FXML private TextField birdFoodTextField;

  @FXML private RadioButton petGenderMaleRadioButton;
  @FXML private RadioButton petGenderFemaleRadioButton;
  @FXML private RadioButton petLocationShopRadioButton;
  @FXML private RadioButton petLocationKennelRadioButton;
  @FXML private RadioButton petStatusSoldRadioButton;
  @FXML private RadioButton petStatusNotSoldRadioButton;
  @FXML private RadioButton petStatusNotFromViaRadioButton;


  @FXML private Button birdSaveButton;


  public void saveAddPet()
  {

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
    String species = birdSpeciesTextField.getText();
    String food = birdFoodTextField.getText();





    // Get RadioButton values
    char gender = petGenderMaleRadioButton.isSelected() ? 'm' :
        petGenderFemaleRadioButton.isSelected() ? 'f' : '-';

    String location = petLocationShopRadioButton.isSelected() ? "Shop" :
        petLocationKennelRadioButton.isSelected() ? "Kennel" : "";

    String status = petStatusSoldRadioButton.isSelected() ? "Sold" :
        petStatusNotSoldRadioButton.isSelected() ? "Not Sold" :
            petStatusNotFromViaRadioButton.isSelected() ? "Not From Via" : "";




    Bird newPet = new Bird(MyModelManager.createNextPetID(),name, color, age, gender,
        location, status, species, food, price, comment);

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
  }




    // Optionally clear fields after saving



  @FXML
  private void clearFields() {
    petNameTextField.clear();
    petColorTextField.clear();
    petAgeTextField.clear();
    petPriceTextField.clear();
    petCommentTextField.clear();
    birdSpeciesTextField.clear();
    birdFoodTextField.clear();

  }


}

