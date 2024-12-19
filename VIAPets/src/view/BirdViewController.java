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

import javafx.scene.control.RadioButton;
import utils.XMLHandler;


import java.io.IOException;

/**
 * Controller class for handling the Bird view functionality in the application.
 * Provides functionality to add, edit, and manage bird-related data.
 *
 * @version 1.0
 * @author Piotr Junosz
 * @author Felipe Figueiredo
 * @author Guillermo Sánchez Martínez
 * @author Cristina Aurelia Matei
 */
public class BirdViewController
{

  @FXML private TextField petNameTextField;
  @FXML private TextField petColorTextField;
  @FXML private TextField petAgeTextField;
  @FXML private TextField petPriceTextField;

  @FXML private TextArea petCommentTextField;
  @FXML private TextField petSpeciesTextField;
  @FXML private TextField petFoodTextField;


  @FXML private RadioButton petBirdGenderMaleRadioButton;
  @FXML private RadioButton petBirdGenderFemaleRadioButton;


  @FXML private RadioButton petLocationShopRadioButton;
  @FXML private RadioButton petLocationKennelRadioButton;


  @FXML private RadioButton petStatusSoldRadioButton;
  @FXML private RadioButton petStatusNotSoldRadioButton;
  @FXML private RadioButton petStatusNotFromViaRadioButton;

  private Pet Pet;

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
  @FXML private TextField petPreferredFoodEditTextField;

  @FXML private Button petSaveButton;

  private Pet selectedPet;

  /**
   * Saves a new bird to the application.
   * Validates input, creates a new Bird object, and adds it to the model.
   *
   * @param actionEvent the event triggered by the save button
   * @throws RuntimeException if there is an error saving the bird data
   */
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

      else if ((petBirdGenderMaleRadioButton.isSelected()
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

  /**
   * Saves the edited bird information.
   * Updates the existing Bird object and saves it back to the model.
   *
   * @param actionEvent the event triggered by the save button
   */
  public void saveEditBird(ActionEvent actionEvent) {
    String name = petNameEditTextField.getText();
    String color = petColorEditTextField.getText();
    String preferredFood = petPreferredFoodEditTextField.getText();
    String species = petSpeciesEditTextField.getText();
    String comment = petCommentEditTextField.getText();

    char gender = petGenderMaleEditRadioButton.isSelected() ?
        'm' : petGenderFemaleEditRadioButton.isSelected() ? 'f' : '-';

    String location = petLocationShopEditRadioButton.isSelected() ?
        "Shop" : petLocationKennelEditRadioButton.isSelected() ? "Kennel" : "";

    String status = petStatusSoldEditRadioButton.isSelected() ?
        "Sold" : petStatusNotSoldEditRadioButton.isSelected() ?
        "Not Sold" : petStatusNotFromViaEditRadioButton.isSelected() ? "Not From Via" : "";

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
    confirmationAlert.setContentText("Click OK to save or Cancel to cancel.");

    ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);
    if (result == ButtonType.OK) {
      try {

        if (selectedPet instanceof Bird) {
          Bird bird = (Bird) selectedPet;
          bird.setName(name);
          bird.setColor(color);
          bird.setSpecies(species);
          bird.setPreferredFood(preferredFood);
          bird.setComment(comment);
          bird.setGender(gender);
          bird.setLocation(location);
          bird.setStatus(status);
          bird.setAge(age);
          bird.setBasePrice(price);
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
   * Populates the edit form with details of the given bird.
   *
   * @param bird the Bird object to populate data from
   */
  public void fillBird(Bird bird) {

    selectedPet = bird;

    petNameEditTextField.setText(bird.getName());
    petColorEditTextField.setText(bird.getColor());
    petAgeEditTextField.setText(String.valueOf(bird.getAge()));
    petCommentEditTextField.setText(bird.getComment());
    petSpeciesEditTextField.setText(bird.getSpecies());
    petPreferredFoodEditTextField.setText(bird.getPreferredFood());

    petPriceEditTextField.setText(String.valueOf(bird.getBasePrice()));

    if (bird.getGender() == 'm') {
      petGenderMaleEditRadioButton.setSelected(true);
    } else if (bird.getGender() == 'f') {
      petGenderFemaleEditRadioButton.setSelected(true);
    }

    if ("Shop".equals(bird.getLocation())) {
      petLocationShopEditRadioButton.setSelected(true);
    } else if ("Kennel".equals(bird.getLocation())) {
      petLocationKennelEditRadioButton.setSelected(true);
    }

    if ("Sold".equals(bird.getStatus())) {
      petStatusSoldEditRadioButton.setSelected(true);
    } else if ("Not Sold".equals(bird.getStatus())) {
      petStatusNotSoldEditRadioButton.setSelected(true);
    } else if ("Not From Via".equals(bird.getStatus())) {
      petStatusNotFromViaEditRadioButton.setSelected(true);
    }
  }

  /**
   * Handles the action of opening the edit window for a given pet.
   *
   * @param pet the Pet object to edit
   */
  public void handleEditAction(Pet pet) {
    try {

      FXMLLoader loader = new FXMLLoader(getClass().getResource(
          "fxml/pets/EditBirdView.fxml"));
      Parent root = loader.load();

      BirdViewController controller = loader.getController();

      controller.fillBird((Bird) pet);

      Stage editStage = new Stage();
      editStage.setTitle("Edit Bird");
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

