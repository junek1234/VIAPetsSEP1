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

import java.io.IOException;
/**
 * Controller class for managing the various pet-related actions in the application.
 * Handles saving and editing pet information.
 *
 * @author Piotr Junosz
 * @author Felipe Figueiredo
 * @author Guillermo Sánchez Martínez
 * @author Cristina Aurelia Matei
 * @version 1.0
 */
public class VariousViewController
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

  //for edit window
  @FXML private TextField petNameEditTextField;
  @FXML private TextField petColorEditTextField;
  @FXML private TextField petAgeEditTextField;
  @FXML private TextField petPriceEditTextField;
  @FXML private TextArea petCommentEditTextField;

  @FXML ToggleGroup genderGroup;
  @FXML private RadioButton petGenderMaleEditRadioButton;
  @FXML private RadioButton petGenderFemaleEditRadioButton;

  @FXML ToggleGroup locationGroup;
  @FXML private RadioButton petLocationShopEditRadioButton;
  @FXML private RadioButton petLocationKennelEditRadioButton;

  @FXML ToggleGroup statusGroup;
  @FXML private RadioButton petStatusSoldEditRadioButton;
  @FXML private RadioButton petStatusNotSoldEditRadioButton;
  @FXML private RadioButton petStatusNotFromViaEditRadioButton;

  @FXML private TextField petSpeciesEditTextField;

  @FXML private Button petSaveButton;

  private Pet selectedPet;
  /**
   * Saves the new pet information entered by the user in the "Add Pet" view.
   * Validates the input fields and adds the pet to the model.
   *
   * @param actionEvent the action event triggered by the save button.
   * @throws RuntimeException if there is an error saving the pet information to the file.
   */
  public void saveAddPet(ActionEvent actionEvent)
  {
    int age=0;
    double price=0;
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

      Pet newPet;
      if (ViewHandler.lastPopupSource.equals("variousMenuItem"))
      {
        newPet = new Various(MyModelManager.createNextPetID(), name, color, age,
            gender, location, status, species, price, comment);
      }
      else
      {
        newPet = new Various(MyModelManager.createNextPetID(), name, color, age,
            gender, location, status, species, price, comment);
      }
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
  /**
   * Saves the edited pet information in the "Edit Pet" view.
   * Validates the edited fields and saves the changes.
   *
   * @param actionEvent the action event triggered by the save button.
   */
  public void saveEditVarious(ActionEvent actionEvent) {
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

    // Parse numeric fields safely
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

        if (selectedPet instanceof Various) {
          Various various = (Various) selectedPet;
          various.setName(name);
          various.setColor(color);
          various.setSpecies(species);
          various.setComment(comment);
          various.setGender(gender);
          various.setLocation(location);
          various.setStatus(status);
          various.setAge(age);
          various.setBasePrice(price);
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
  /**
   * Fills the edit fields with the selected pet's current information for editing.
   *
   * @param various the pet to be edited.
   */
  public void fillVarious(Various various) {

    selectedPet = various;

    petNameEditTextField.setText(various.getName());
    petColorEditTextField.setText(various.getColor());
    petAgeEditTextField.setText(String.valueOf(various.getAge()));
    petCommentEditTextField.setText(various.getComment());
    petSpeciesEditTextField.setText(various.getSpecies());

    petPriceEditTextField.setText(String.valueOf(various.getBasePrice()));

    if (various.getGender() == 'm') {
      petGenderMaleEditRadioButton.setSelected(true);
    } else if (various.getGender() == 'f') {
      petGenderFemaleEditRadioButton.setSelected(true);
    }

    if ("Shop".equals(various.getLocation())) {
      petLocationShopEditRadioButton.setSelected(true);
    } else if ("Kennel".equals(various.getLocation())) {
      petLocationKennelEditRadioButton.setSelected(true);
    }

    if ("Sold".equals(various.getStatus())) {
      petStatusSoldEditRadioButton.setSelected(true);
    } else if ("Not Sold".equals(various.getStatus())) {
      petStatusNotSoldEditRadioButton.setSelected(true);
    } else if ("Not From Via".equals(various.getStatus())) {
      petStatusNotFromViaEditRadioButton.setSelected(true);
    }
  }
  /**
   * Handles the action to edit a selected pet, opening the corresponding edit window.
   *
   * @param pet the pet to be edited.
   */
  public void handleEditAction(Pet pet) {
    try {

      FXMLLoader loader = new FXMLLoader(getClass().getResource(
          "fxml/pets/EditVariousView.fxml"));
      Parent root = loader.load();

      VariousViewController controller = loader.getController();

      controller.fillVarious((Various) pet);

      Stage editStage = new Stage();
      editStage.setTitle("Edit Various");
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








