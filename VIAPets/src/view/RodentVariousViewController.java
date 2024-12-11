package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;
import utils.XMLHandler;

import java.io.IOException;

public class RodentVariousViewController
{

  @FXML private TextField petNameTextField;
  @FXML private TextField petColorTextField;
  @FXML private TextField petAgeTextField;
  @FXML private TextField petPriceTextField;

  @FXML private TextArea petCommentTextField;
  @FXML private TextField petSpeciesTextField;


  @FXML private RadioButton petGenderMaleRadioButton;
  @FXML private RadioButton petGenderFemaleRadioButton;
  @FXML private RadioButton petLocationShopRadioButton;
  @FXML private RadioButton petLocationKennelRadioButton;
  @FXML private RadioButton petStatusSoldRadioButton;
  @FXML private RadioButton petStatusNotSoldRadioButton;
  @FXML private RadioButton petStatusNotFromViaRadioButton;


  @FXML private Button petSaveButton;


  public void saveAddPet(ActionEvent actionEvent)
  {
    int age;
    if (petAgeTextField.getText().isEmpty())
    {
      age = 0;
    }
    else
    {
      age = Integer.parseInt(petAgeTextField.getText());
    }
    double price;
    if (petPriceTextField.getText().isEmpty())
    {
      price = 0.0;
    }
    else
    {
      price = Double.parseDouble(petPriceTextField.getText());
    }
    String name = petNameTextField.getText();
    String color = petColorTextField.getText();

    String comment = petCommentTextField.getText();
    String species = petSpeciesTextField.getText();

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
      alert1.setContentText("Invalid input!");
      alert1.show();
    }
    else if((petGenderMaleRadioButton.isSelected()&&petGenderFemaleRadioButton.isSelected())||(petLocationShopRadioButton.isSelected()&&petLocationKennelRadioButton.isSelected())||(petStatusSoldRadioButton.isSelected()&&petStatusNotSoldRadioButton.isSelected())||(petStatusSoldRadioButton.isSelected()&&petStatusNotFromViaRadioButton.isSelected())||petStatusNotSoldRadioButton.isSelected()&&petStatusNotFromViaRadioButton.isSelected())
    {
      Alert alert2 = new Alert(Alert.AlertType.ERROR);
      alert2.setTitle("Error");
      alert2.setHeaderText(null);
      alert2.setContentText("More Than One Choice Selected!");
      alert2.show();
    }
    else
    {

      Pet newPet;
      if (ViewHandler.lastPopupSource.equals("rodentMenuItem"))
      {
        newPet = new Rodent(MyModelManager.createNextPetID(), name, color, age,
            gender, location, status, species, price, comment);
      }
      else
      {
        newPet = new Various(MyModelManager.createNextPetID(), name, color, age,
            gender, location, status, species, price, comment);
      }
      System.out.println(newPet);
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








