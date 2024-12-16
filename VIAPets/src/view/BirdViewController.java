package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;

import javafx.scene.control.RadioButton;
import utils.XMLHandler;


import java.io.IOException;

public class BirdViewController
{

  @FXML private TextField petNameTextField;
  @FXML private TextField petColorTextField;
  @FXML private TextField petAgeTextField;
  @FXML private TextField petPriceTextField;

  @FXML private TextArea petCommentTextField;
  @FXML private TextField petSpeciesTextField;
  @FXML private TextField petFoodTextField;

  @FXML private ToggleGroup genderGroup;
  @FXML private RadioButton petBirdGenderMaleRadioButton;
  @FXML private RadioButton petBirdGenderFemaleRadioButton;

  @FXML private ToggleGroup locationGroup;
  @FXML private RadioButton petLocationShopRadioButton;
  @FXML private RadioButton petLocationKennelRadioButton;

  @FXML private ToggleGroup statusGroup;
  @FXML private RadioButton petStatusSoldRadioButton;
  @FXML private RadioButton petStatusNotSoldRadioButton;
  @FXML private RadioButton petStatusNotFromViaRadioButton;

  private Pet Pet;


  @FXML
  public void initialize()
  {
    genderGroup = new ToggleGroup();
    petBirdGenderMaleRadioButton.setToggleGroup(genderGroup);
    petBirdGenderFemaleRadioButton.setToggleGroup(genderGroup);

    locationGroup = new ToggleGroup();
    petLocationKennelRadioButton.setToggleGroup(locationGroup);
    petLocationShopRadioButton.setToggleGroup(locationGroup);

    statusGroup = new ToggleGroup();
    petStatusSoldRadioButton.setToggleGroup(statusGroup);
    petStatusNotSoldRadioButton.setToggleGroup(statusGroup);
    petStatusNotFromViaRadioButton.setToggleGroup(statusGroup);
  }

  public void saveAddPet(ActionEvent actionEvent)
  {

    String name = petNameTextField.getText();
    String color = petColorTextField.getText();
    int age = 0;
    double price = 0;
    String comment = petCommentTextField.getText();
    String species = petSpeciesTextField.getText();
    String food = petFoodTextField.getText();

    // Get RadioButton values
    char gender = petBirdGenderMaleRadioButton.isSelected() ?
        'm' :
        petBirdGenderFemaleRadioButton.isSelected() ? 'f' : '-';
    System.out.println(gender);
    String location = petLocationShopRadioButton.isSelected() ?
        "Shop" :
        petLocationKennelRadioButton.isSelected() ? "Kennel" : "";
    System.out.println(location);
    String status = petStatusSoldRadioButton.isSelected() ?
        "Sold" :
        petStatusNotSoldRadioButton.isSelected() ?
            "Not Sold" :
            petStatusNotFromViaRadioButton.isSelected() ? "Not From Via" : "";
    //check errors and Exceptions
     if (petNameTextField.getText().isEmpty() || petAgeTextField.getText()
          .isEmpty() || petPriceTextField.getText().isEmpty()
          || petSpeciesTextField.getText().isEmpty()
          || petFoodTextField.getText().isEmpty() || gender == '-'
          || location.isEmpty() || status.isEmpty() || petColorTextField.getText().isEmpty())
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("Complete all fields!");
        alert1.show();
      }

      else if ((petBirdGenderFemaleRadioButton.isSelected()
          && petBirdGenderFemaleRadioButton.isSelected()) || (
          petLocationShopRadioButton.isSelected()
              && petLocationKennelRadioButton.isSelected()) || (
          petStatusSoldRadioButton.isSelected()
              && petStatusNotSoldRadioButton.isSelected()) || (
          petStatusSoldRadioButton.isSelected()
              && petStatusNotFromViaRadioButton.isSelected())
          || petStatusNotSoldRadioButton.isSelected()
          && petStatusNotFromViaRadioButton.isSelected())
      {
        Alert alert2 = new Alert(Alert.AlertType.ERROR);
        alert2.setTitle("Error");
        alert2.setHeaderText(null);
        alert2.setContentText("More Than One Choice Selected!");
        alert2.show();
      }
      else
      {
        try
        {
          age = Integer.parseInt(petAgeTextField.getText());
          price = Double.parseDouble(petPriceTextField.getText());
        }
        catch (NumberFormatException e)
        {
          Alert alert1 = new Alert(Alert.AlertType.ERROR);
          alert1.setTitle("Error");
          alert1.setHeaderText(null);
          alert1.setContentText("Age and price must be numbers!");
          alert1.show();
          return;//it stops the method when catching exception
        }

        Bird newPet = new Bird(MyModelManager.createNextPetID(), name, color,
            age, gender, location, status, species, food, price, comment);

        MyModelManager manager = new MyModelManager();
        try
        {
          manager.addPet(newPet);
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

