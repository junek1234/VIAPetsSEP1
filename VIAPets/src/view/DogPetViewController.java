package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import utils.XMLHandler;

import java.io.IOException;

public class DogPetViewController {

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

  @FXML private RadioButton petGenderMaleEditRadioButton;
  @FXML private RadioButton petGenderFemaleEditRadioButton;
  @FXML private RadioButton petLocationShopEditRadioButton;
  @FXML private RadioButton petLocationKennelEditRadioButton;
  @FXML private RadioButton petStatusSoldEditRadioButton;
  @FXML private RadioButton petStatusNotSoldEditRadioButton;
  @FXML private RadioButton petStatusNotFromViaEditRadioButton;

  @FXML private Button petSaveButton;

  private Pet selectedPet;

  private Dog dog;
  private Cat cat;
  private Bird bird;
  private Fish fish;
  private Rodent rodent;
  private Various various;

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
          alert1.setContentText("Invalid input!");
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
          alert1.setContentText("Invalid input!");
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
  

  public void saveEditPet(ActionEvent actionEvent) {

//    Pet selectedPet = getTableView().getItems().get(getIndex());

    // Retrieve updated values from text fields
    String name = petNameEditTextField.getText();
    String color = petColorEditTextField.getText();
    String breed = petBreedEditTextField.getText();
    String breederName = petBreederNameEditTextField.getText();
    String comment = petCommentEditTextField.getText();

    // Retrieve RadioButton values
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
      age = Integer.parseInt(petAgeTextField.getText());
      price = Double.parseDouble(petPriceTextField.getText());
    } catch (NumberFormatException e) {
      // Handle invalid input (optional)
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Input Error");
      alert.setHeaderText("Invalid Input");
      alert.setContentText("Please ensure Age and Price are valid numbers.");
      alert.showAndWait();
      return;
    }

    // Update the selected pet's attributes
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
    } else {
      // Handle other pet types if applicable
    }

  }


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

  public void handleEditAction(Pet pet) {
    try {

      if (pet instanceof Dog) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
            "fxml/pets/EditDogCatPetView.fxml"));
        Parent root = loader.load();

        DogPetViewController controller = loader.getController();

        controller.fillDog((Dog) pet);

        Stage editStage = new Stage();
        editStage.setTitle("Edit Pet");
        editStage.setScene(new Scene(root));
        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.showAndWait();
      }
    } catch (IOException e) {
      e.printStackTrace();
//      // Optionally show an alert or log the error message for better debugging
//      Alert alert = new Alert(Alert.AlertType.ERROR);
//      alert.setTitle("Error");
//      alert.setHeaderText("Failed to load the edit window.");
//      alert.setContentText("There was an error loading the FXML for the edit window.");
//      alert.showAndWait();
    }
  }
}
