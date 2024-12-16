package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
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

  @FXML private ToggleGroup genderGroup;
  @FXML private RadioButton petGenderMaleRadioButton;
  @FXML private RadioButton petGenderFemaleRadioButton;

  @FXML private ToggleGroup locationGroup;
  @FXML private RadioButton petLocationShopRadioButton;
  @FXML private RadioButton petLocationKennelRadioButton;

  @FXML private ToggleGroup statusGroup;
  @FXML private RadioButton petStatusSoldRadioButton;
  @FXML private RadioButton petStatusNotSoldRadioButton;
  @FXML private RadioButton petStatusNotFromViaRadioButton;

  @FXML private ToggleGroup saltWaterGroup;
  @FXML private RadioButton petSaltWaterYesRadioButton;
  @FXML private RadioButton petSaltWaterNoRadioButton;

  @FXML private ToggleGroup predatorGroup;
  @FXML private RadioButton petPredatorYesRadioButton;
  @FXML private RadioButton petPredatorNoRadioButton;
  @FXML private TextField petSpeciesTextField;

  @FXML private Button petSaveButton;

  @FXML
  public void initialize()
  {
    genderGroup = new ToggleGroup();
    petGenderMaleRadioButton.setToggleGroup(genderGroup);
    petGenderFemaleRadioButton.setToggleGroup(genderGroup);

    locationGroup = new ToggleGroup();
    petLocationKennelRadioButton.setToggleGroup(locationGroup);
    petLocationShopRadioButton.setToggleGroup(locationGroup);

    statusGroup = new ToggleGroup();
    petStatusSoldRadioButton.setToggleGroup(statusGroup);
    petStatusNotSoldRadioButton.setToggleGroup(statusGroup);
    petStatusNotFromViaRadioButton.setToggleGroup(statusGroup);

    saltWaterGroup = new ToggleGroup();
    petSaltWaterYesRadioButton.setToggleGroup(saltWaterGroup);
    petSaltWaterNoRadioButton.setToggleGroup(saltWaterGroup);

    predatorGroup = new ToggleGroup();
    petPredatorYesRadioButton.setToggleGroup(predatorGroup);
    petPredatorNoRadioButton.setToggleGroup(predatorGroup);

  }

  public void saveAddPet(ActionEvent actionEvent)
  {
    String species = petSpeciesTextField.getText();
    String name = petNameTextField.getText();
    String color = petColorTextField.getText();
    int age=0;
    double price=0;

    String comment = petCommentTextField.getText();
    boolean isSaltWater = petSaltWaterYesRadioButton.isSelected() ?
        true :
        petSaltWaterNoRadioButton.isSelected() ? false : false;

    boolean isPredator = petPredatorYesRadioButton.isSelected() ?
        true :
        petPredatorNoRadioButton.isSelected() ? false : false;

    // Get RadioButton values
    char gender = petGenderMaleRadioButton.isSelected() ?
        'm' :
        petGenderFemaleRadioButton.isSelected() ? 'f' : '-';

    String location = petLocationShopRadioButton.isSelected() ?
        "Shop" :
        petLocationKennelRadioButton.isSelected() ? "Kennel" : "";

    String status = petStatusSoldRadioButton.isSelected() ?
        "Sold" :
        petStatusNotSoldRadioButton.isSelected() ?
            "Not Sold" :
            petStatusNotFromViaRadioButton.isSelected() ? "Not From Via" : "";

    if (petNameTextField.getText().isEmpty()||petAgeTextField.getText().isEmpty()||petPriceTextField.getText().isEmpty()||petSpeciesTextField.getText().isEmpty()||gender=='-'||location.isEmpty()||status.isEmpty())
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("All inputs must be filled!");
      alert1.show();
    }
    else if((petGenderMaleRadioButton.isSelected()&&petGenderFemaleRadioButton.isSelected())||(petLocationShopRadioButton.isSelected()&&petLocationKennelRadioButton.isSelected())||(petStatusSoldRadioButton.isSelected()&&petStatusNotSoldRadioButton.isSelected())||(petStatusSoldRadioButton.isSelected()&&petStatusNotFromViaRadioButton.isSelected())||(petStatusNotSoldRadioButton.isSelected()&&petStatusNotFromViaRadioButton.isSelected())||(
    petSaltWaterNoRadioButton.isSelected()&&petSaltWaterYesRadioButton.isSelected())||(petPredatorNoRadioButton.isSelected()&&petPredatorYesRadioButton.isSelected()))
    {
      Alert alert2 = new Alert(Alert.AlertType.ERROR);
      alert2.setTitle("Error");
      alert2.setHeaderText(null);
      alert2.setContentText("More Than One Choice Selected!");
      alert2.show();
    }

    else
    {
      if(!petAgeTextField.getText().isEmpty())
      {
        try
        {
          age = Integer.parseInt(petAgeTextField.getText());
        }
        catch (NumberFormatException e)
        {
          Alert alert1 = new Alert(Alert.AlertType.ERROR);
          alert1.setTitle("Error");
          alert1.setHeaderText(null);
          alert1.setContentText("Age must be a number!");
          alert1.show();
          return;//it stops the method when catching exception
        }

      }
      if (!petPriceTextField.getText().isEmpty())
      {
        try
        {
          price = Double.parseDouble(petPriceTextField.getText());
        }
        catch (NumberFormatException e)
        {
          Alert alert1 = new Alert(Alert.AlertType.ERROR);
          alert1.setTitle("Error");
          alert1.setHeaderText(null);
          alert1.setContentText("Price must be a number!");
          alert1.show();
          return;//it stops the method when catching exception
        }
      }

      Fish newPet = new Fish(MyModelManager.createNextPetID(), name, color, age,
          gender, location, status, isSaltWater, species, isPredator, price,
          comment);
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







