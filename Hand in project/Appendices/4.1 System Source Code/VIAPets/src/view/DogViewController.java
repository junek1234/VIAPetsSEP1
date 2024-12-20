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
 * Controller class for handling the Dog-related events in the application.
 * Manages actions for adding and editing dog details, including form validation and error handling.
 * Provides methods for saving, editing, and filling dog information.
 *
 * @author Piotr Junosz
 * @author Felipe Figueiredo
 * @author Guillermo Sánchez Martínez
 * @author Cristina Aurelia Matei
 * @version 1.0
 */
public class DogViewController
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
   * Handles the action of saving a new pet (dog) to the system.
   * Validates the input fields and creates a new pet object
   *
   * @param actionEvent the event triggered when the save button is pressed.
   * @throws RuntimeException if an error occurs while adding the pet or updating the XML file.
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
      alert1.setContentText("Invalid input!");
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
      if (ViewHandler.lastPopupSource.equals("dogMenuItem")) {
        newPet = new Dog(MyModelManager.createNextPetID(), name, color, age,
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
   * Handles the action of saving the changes made to an existing dog (pet).
   * Validates the input fields and updates the selected dog in the model manager.
   *
   * @param actionEvent the event triggered when the save button is pressed.
   */
  public void saveEditDog(ActionEvent actionEvent) {
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

        if (selectedPet instanceof Dog) {
          Dog dog = (Dog) selectedPet;
          dog.setName(name);
          dog.setColor(color);
          dog.setBreed(breed);
          dog.setBreederName(breederName);
          dog.setComment(comment);
          dog.setGender(gender);
          dog.setLocation(location);
          dog.setStatus(status);
          dog.setAge(age);
          dog.setBasePrice(price);
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
   * Fills the form with the details of the selected dog for editing.
   *
   * @param dog the dog object to be displayed in the form.
   */
  public void fillDog(Dog dog) {

    selectedPet = dog;

    petNameEditTextField.setText(dog.getName());
    petColorEditTextField.setText(dog.getColor());
    petAgeEditTextField.setText(String.valueOf(dog.getAge()));
    petCommentEditTextField.setText(dog.getComment());

    petBreedEditTextField.setText(dog.getBreed());
    petBreederNameEditTextField.setText(dog.getBreederName());
    petPriceEditTextField.setText(String.valueOf(dog.getBasePrice()));

    if (dog.getGender() == 'm') {
      petGenderMaleEditRadioButton.setSelected(true);
    } else if (dog.getGender() == 'f') {
      petGenderFemaleEditRadioButton.setSelected(true);
    }

    if ("Shop".equals(dog.getLocation())) {
      petLocationShopEditRadioButton.setSelected(true);
    } else if ("Kennel".equals(dog.getLocation())) {
      petLocationKennelEditRadioButton.setSelected(true);
    }

    if ("Sold".equals(dog.getStatus())) {
      petStatusSoldEditRadioButton.setSelected(true);
    } else if ("Not Sold".equals(dog.getStatus())) {
      petStatusNotSoldEditRadioButton.setSelected(true);
    } else if ("Not From Via".equals(dog.getStatus())) {
      petStatusNotFromViaEditRadioButton.setSelected(true);
    }
  }
  /**
   * Handles the action to edit a dog's details in a separate window.
   *
   * @param pet the pet to be edited.
   */
  public void handleEditAction(Pet pet) {
    try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
            "fxml/pets/EditDogView.fxml"));
        Parent root = loader.load();

        DogViewController controller = loader.getController();

        controller.fillDog((Dog) pet);

        Stage editStage = new Stage();
        editStage.setTitle("Edit Dog");
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