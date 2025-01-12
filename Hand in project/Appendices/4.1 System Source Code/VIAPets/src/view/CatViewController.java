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
 * Controller class for managing the Cat view.
 * Handles the addition, editing, and validation of Cat objects.
 * Includes methods for saving and editing cat data, and populating forms.
 * @author Piotr Junosz
 * @author Felipe Figueiredo
 * @author Guillermo Sánchez Martínez
 * @author Cristina Aurelia Matei
 * @version 1.0
 */
public class CatViewController
{

  @FXML private TextField petNameTextField;
  @FXML private TextField petColorTextField;
  @FXML private TextField petAgeTextField;
  @FXML private TextField petPriceTextField;
  @FXML private TextField petBreedTextField;
  @FXML private TextField petBreederNameTextField;
  @FXML private TextArea petCommentTextField;

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
  @FXML private TextField petBreedEditTextField;
  @FXML private TextField petBreederNameEditTextField;
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

  @FXML private Button petSaveButton;

  private Pet selectedPet;

  /**
   * Saves a new cat based on user input.
   * Validates the input fields and handles errors accordingly.
   *
   * @param actionEvent the action event triggered by clicking the save button
   * @throws RuntimeException if there is an error saving the cat data
   */
  public void saveAddPet(ActionEvent actionEvent) {
    String name = petNameTextField.getText();
    String color = petColorTextField.getText();
    String breed = petBreedTextField.getText();
    String breederName = petBreederNameTextField.getText();
    String comment = petCommentTextField.getText();

    // Get RadioButton values
    char gender = petGenderMaleRadioButton.isSelected() ?
        'm' :
        petGenderFemaleRadioButton.isSelected() ? 'f' : '-';

    String location = petLocationShopRadioButton.isSelected() ?
        "Shop" :
        petLocationKennelRadioButton.isSelected() ? "Kennel" : "";

    String status = petStatusSoldRadioButton.isSelected() ?
        "Sold" :
        petStatusNotSoldRadioButton.isSelected() ? "Not Sold" :
            petStatusNotFromViaRadioButton.isSelected() ? "Not From Via" : "";
    int age = 0;
    double price = 0;

    if (petNameTextField.getText().isEmpty() || petAgeTextField.getText()
        .isEmpty() || petPriceTextField.getText().isEmpty()
        || petBreedTextField.getText().isEmpty()
        || petBreederNameTextField.getText().isEmpty() || gender == '-'
        || location.isEmpty() || status.isEmpty()) {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("Complete all fields!");
      alert1.show();
    } else if ((petGenderMaleRadioButton.isSelected()
        && petGenderFemaleRadioButton.isSelected()) || (
        petLocationShopRadioButton.isSelected()
            && petLocationKennelRadioButton.isSelected()) || (
        petStatusSoldRadioButton.isSelected()
            && petStatusNotSoldRadioButton.isSelected()) || (
        petStatusSoldRadioButton.isSelected()
            && petStatusNotFromViaRadioButton.isSelected())
        || petStatusNotSoldRadioButton.isSelected()
        && petStatusNotFromViaRadioButton.isSelected()) {
      Alert alert2 = new Alert(Alert.AlertType.ERROR);
      alert2.setTitle("Error");
      alert2.setHeaderText(null);
      alert2.setContentText("More Than One Choice Selected!");
      alert2.show();
    } else {
      if (!petAgeTextField.getText().isEmpty()) {
        try {
          age = Integer.parseInt(petAgeTextField.getText());
        } catch (NumberFormatException e) {
          Alert alert1 = new Alert(Alert.AlertType.ERROR);
          alert1.setTitle("Error");
          alert1.setHeaderText(null);
          alert1.setContentText("Age must be a number!");
          alert1.show();
          return; //it stops the method when catching exception
        }

      }
      if (!petPriceTextField.getText().isEmpty()) {
        try {
          price = Double.parseDouble(petPriceTextField.getText());
        } catch (NumberFormatException e) {
          Alert alert1 = new Alert(Alert.AlertType.ERROR);
          alert1.setTitle("Error");
          alert1.setHeaderText(null);
          alert1.setContentText("Price must be a number!");
          alert1.show();
          return; //it stops the method when catching exception
        }
      }

      Pet newPet;
      if (ViewHandler.lastPopupSource.equals("catMenuItem")) {
        newPet = new Cat(MyModelManager.createNextPetID(), name, color, age,
            gender, location, status, breed, breederName, price, comment);
      } else {
        newPet = new Cat(MyModelManager.createNextPetID(), name, color, age,
            gender, location, status, breed, breederName, price, comment);
      }
      MyModelManager manager = new MyModelManager();
      try {
        manager.addPet(newPet);
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      XMLHandler.updateXML();
    }
  }
  /**
   * Saves changes to an existing cat.
   * Updates the cat object with new values and persists the changes.
   *
   * @param actionEvent the action event triggered by clicking the save button
   */
  public void saveEditCat(ActionEvent actionEvent) {
    String name = petNameEditTextField.getText();
    String color = petColorEditTextField.getText();
    String breed = petBreedEditTextField.getText();
    String breederName = petBreederNameEditTextField.getText();
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

        if (selectedPet instanceof Cat) {
          Cat cat = (Cat) selectedPet;
          cat.setName(name);
          cat.setColor(color);
          cat.setBreed(breed);
          cat.setBreederName(breederName);
          cat.setComment(comment);
          cat.setGender(gender);
          cat.setLocation(location);
          cat.setStatus(status);
          cat.setAge(age);
          cat.setBasePrice(price);
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
   * Populates the edit form with data from the selected cat.
   * Fills all input fields based on the cat's properties.
   *
   * @param cat the cat whose data will populate the edit form
   */
  public void fillCat(Cat cat) {

    selectedPet = cat;

    petNameEditTextField.setText(cat.getName());
    petColorEditTextField.setText(cat.getColor());
    petAgeEditTextField.setText(String.valueOf(cat.getAge()));
    petCommentEditTextField.setText(cat.getComment());

    petBreedEditTextField.setText(cat.getBreed());
    petBreederNameEditTextField.setText(cat.getBreederName());
    petPriceEditTextField.setText(String.valueOf(cat.getBasePrice()));

    if (cat.getGender() == 'm') {
      petGenderMaleEditRadioButton.setSelected(true);
    } else if (cat.getGender() == 'f') {
      petGenderFemaleEditRadioButton.setSelected(true);
    }

    if ("Shop".equals(cat.getLocation())) {
      petLocationShopEditRadioButton.setSelected(true);
    } else if ("Kennel".equals(cat.getLocation())) {
      petLocationKennelEditRadioButton.setSelected(true);
    }

    if ("Sold".equals(cat.getStatus())) {
      petStatusSoldEditRadioButton.setSelected(true);
    } else if ("Not Sold".equals(cat.getStatus())) {
      petStatusNotSoldEditRadioButton.setSelected(true);
    } else if ("Not From Via".equals(cat.getStatus())) {
      petStatusNotFromViaEditRadioButton.setSelected(true);
    }
  }

  /**
   * Opens the edit window for modifying cat details.
   * Loads the FXML for editing a cat
   *
   * @param pet the pet object to be edited, cast to Cat
   */
  public void handleEditAction(Pet pet) {
    try {

      FXMLLoader loader = new FXMLLoader(getClass().getResource(
          "fxml/pets/EditCatView.fxml"));
      Parent root = loader.load();

      CatViewController controller = loader.getController();

      controller.fillCat((Cat) pet);

      Stage editStage = new Stage();
      editStage.setTitle("Edit Cat");
      editStage.setScene(new Scene(root));
      editStage.initModality(Modality.APPLICATION_MODAL);
      editStage.showAndWait();
    }

    catch (IOException e) {
      // Optionally show an alert or log the error message for better debugging
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Failed to load the edit window.");
      alert.setContentText("There was an error loading the FXML for the edit window.");
      alert.showAndWait();
    }
  }
}
