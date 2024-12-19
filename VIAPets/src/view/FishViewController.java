package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
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

  private ToggleGroup genderGroup;
  @FXML private RadioButton petGenderMaleRadioButton;
  @FXML private RadioButton petGenderFemaleRadioButton;

  private ToggleGroup locationGroup;
  @FXML private RadioButton petLocationShopRadioButton;
  @FXML private RadioButton petLocationKennelRadioButton;

  private ToggleGroup statusGroup;
  @FXML private RadioButton petStatusSoldRadioButton;
  @FXML private RadioButton petStatusNotSoldRadioButton;
  @FXML private RadioButton petStatusNotFromViaRadioButton;

  private ToggleGroup saltWaterGroup;
  @FXML private RadioButton petSaltWaterYesRadioButton;
  @FXML private RadioButton petSaltWaterNoRadioButton;

  private ToggleGroup predatorGroup;
  @FXML private RadioButton petPredatorYesRadioButton;
  @FXML private RadioButton petPredatorNoRadioButton;

  @FXML private TextField petSpeciesTextField;

  //for edit window
  @FXML private TextField petNameEditTextField;
  @FXML private TextField petColorEditTextField;
  @FXML private TextField petAgeEditTextField;
  @FXML private TextField petPriceEditTextField;
  @FXML private TextArea petCommentEditTextField;

  @FXML private RadioButton petGenderMaleEditRadioButton;
  @FXML private RadioButton petGenderFemaleEditRadioButton;

  @FXML private RadioButton petLocationShopEditRadioButton;
  @FXML private RadioButton petLocationKennelEditRadioButton;

  @FXML private RadioButton petStatusSoldEditRadioButton;
  @FXML private RadioButton petStatusNotSoldEditRadioButton;
  @FXML private RadioButton petStatusNotFromViaEditRadioButton;

  @FXML private RadioButton petSaltWaterYesEditRadioButton;
  @FXML private RadioButton petSaltWaterNoEditRadioButton;

  @FXML private RadioButton petPredatorYesEditRadioButton;
  @FXML private RadioButton petPredatorNoEditRadioButton;

  @FXML private TextField petSpeciesEditTextField;

  @FXML private Button petSaveButton;

  private Pet selectedPet;

//  @FXML
//  public void initialize()
//  {
//    genderGroup = new ToggleGroup();
//    petGenderMaleRadioButton.setToggleGroup(genderGroup);
//    petGenderFemaleRadioButton.setToggleGroup(genderGroup);
//
//    locationGroup = new ToggleGroup();
//    petLocationKennelRadioButton.setToggleGroup(locationGroup);
//    petLocationShopRadioButton.setToggleGroup(locationGroup);
//
//    statusGroup = new ToggleGroup();
//    petStatusSoldRadioButton.setToggleGroup(statusGroup);
//    petStatusNotSoldRadioButton.setToggleGroup(statusGroup);
//    petStatusNotFromViaRadioButton.setToggleGroup(statusGroup);
//
//    saltWaterGroup = new ToggleGroup();
//    petSaltWaterYesRadioButton.setToggleGroup(saltWaterGroup);
//    petSaltWaterNoRadioButton.setToggleGroup(saltWaterGroup);
//
//    predatorGroup = new ToggleGroup();
//    petPredatorYesRadioButton.setToggleGroup(predatorGroup);
//    petPredatorNoRadioButton.setToggleGroup(predatorGroup);
//
//  }

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

  public void saveEditFish(ActionEvent actionEvent) {
    String name = petNameEditTextField.getText();
    String color = petColorEditTextField.getText();
    String species = petSpeciesEditTextField.getText();
    String comment = petCommentEditTextField.getText();

    char gender = petGenderMaleEditRadioButton.isSelected() ?
        'm' : petGenderFemaleEditRadioButton.isSelected() ? 'f' : '-';

    String location = petLocationShopEditRadioButton.isSelected() ?
        "Shop" : petLocationKennelEditRadioButton.isSelected() ? "Kennel" : "";

    String status = petStatusSoldEditRadioButton.isSelected() ?
        "Sold" : petStatusNotSoldEditRadioButton.isSelected() ?
        "Not Sold" : petStatusNotFromViaEditRadioButton.isSelected() ? "Not From Via" : "";

    boolean saltWater = petSaltWaterYesEditRadioButton.isSelected();
    boolean predator = petPredatorYesEditRadioButton.isSelected();

    // Parse numeric fields
    int age = 0;
    double price = 0.0;
    try {
      age = Integer.parseInt(petAgeEditTextField.getText());
      price = Double.parseDouble(petPriceEditTextField.getText());
    } catch (NumberFormatException e) {
      // Handle invalid input
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Input Error");
      alert.setHeaderText("Invalid Input");
      alert.setContentText("Please ensure Age and Price are valid numbers.");
      alert.showAndWait();
      return;
    }

    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Save Changes");
    confirmationAlert.setHeaderText("Are you sure you want to save the changes?");
    confirmationAlert.setContentText("Click OK to save changes or Cancel to discard changes.");

    ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);
    if (result == ButtonType.OK) {
      try {

        if (selectedPet instanceof Fish) {
          Fish fish = (Fish) selectedPet;
          fish.setName(name);
          fish.setColor(color);
          fish.setSpecies(species);
          fish.setComment(comment);
          fish.setGender(gender);
          fish.setLocation(location);
          fish.setStatus(status);
          fish.setSaltwater(saltWater);
          fish.setPredator(predator);
          fish.setAge(age);
          fish.setBasePrice(price);
        }
        // in the file
        MyModelManager mManager = new MyModelManager();
        mManager.editPet(selectedPet.getPetID(), selectedPet);

        // Close the edit window
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
      } catch (IOException e) {
        // Handle file write error
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("File Error");
        errorAlert.setHeaderText("Error Saving Changes");
        errorAlert.setContentText("Could not save changes to the file. Please try again.");
        errorAlert.showAndWait();
      }
    }
  }

  public void fillFish(Fish fish) {

    selectedPet = fish;

    petNameEditTextField.setText(fish.getName());
    petColorEditTextField.setText(fish.getColor());
    petAgeEditTextField.setText(String.valueOf(fish.getAge()));
    petCommentEditTextField.setText(fish.getComment());
    petSpeciesEditTextField.setText(fish.getSpecies());

    petPriceEditTextField.setText(String.valueOf(fish.getBasePrice()));

    if (fish.getGender() == 'm') {
      petGenderMaleEditRadioButton.setSelected(true);
    } else if (fish.getGender() == 'f') {
      petGenderFemaleEditRadioButton.setSelected(true);
    }

    if ("Shop".equals(fish.getLocation())) {
      petLocationShopEditRadioButton.setSelected(true);
    } else if ("Kennel".equals(fish.getLocation())) {
      petLocationKennelEditRadioButton.setSelected(true);
    }

    if ("Sold".equals(fish.getStatus())) {
      petStatusSoldEditRadioButton.setSelected(true);
    } else if ("Not Sold".equals(fish.getStatus())) {
      petStatusNotSoldEditRadioButton.setSelected(true);
    } else if ("Not From Via".equals(fish.getStatus())) {
      petStatusNotFromViaEditRadioButton.setSelected(true);
    }

    if (fish.isSaltwater()) {
      petSaltWaterYesEditRadioButton.setSelected(true);
    } else {
      petSaltWaterNoEditRadioButton.setSelected(true);
    }

    if (fish.isPredator()) {
      petPredatorYesEditRadioButton.setSelected(true);
    } else {
      petPredatorNoEditRadioButton.setSelected(true);
    }
  }


  public void handleEditAction(Pet pet) {
    try {

      FXMLLoader loader = new FXMLLoader(getClass().getResource(
          "fxml/pets/EditFishView.fxml"));
      Parent root = loader.load();

      FishViewController controller = loader.getController();

      controller.fillFish((Fish) pet);

      Stage editStage = new Stage();
      editStage.setTitle("Edit Fish");
      editStage.setScene(new Scene(root));
      editStage.initModality(Modality.APPLICATION_MODAL);
      editStage.showAndWait();
    }

    catch (IOException e) {
      // Show a log the error message
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Failed to load the edit window.");
      alert.setContentText("There was an error loading the FXML for the edit window.");
      alert.showAndWait();
    }
  }


}