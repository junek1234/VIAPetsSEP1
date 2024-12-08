/*
package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class EditPetViewController implements Initializable
{

  @FXML private TextField nameField;
  @FXML private TextField ageField;
  @FXML private TextField speciesField;
  @FXML private TextField colorField;
  @FXML private TextField genderField;
  @FXML private ToggleGroup locationToggleGroup;
  @FXML private RadioButton shopRadioButton;
  @FXML private RadioButton kennelRadioButton;
  @FXML private ToggleGroup statusToggleGroup;
  @FXML private RadioButton soldRadioButton;
  @FXML private RadioButton notSoldRadioButton;
  @FXML private RadioButton notFromVIAPetsRadioButton;
  @FXML private TextArea commentArea;

  private Pet pet;

  public void initialize(URL location, ResourceBundle resources) {
    shopRadioButton.setToggleGroup(locationToggleGroup);
    kennelRadioButton.setToggleGroup(locationToggleGroup);

    soldRadioButton.setToggleGroup(statusToggleGroup);
    notSoldRadioButton.setToggleGroup(statusToggleGroup);
    notFromVIAPetsRadioButton.setToggleGroup(statusToggleGroup);
  }

  public void setPet(Pet pet) {
    this.pet = pet;

    nameField.setText(pet.getName());
    ageField.setText(String.valueOf(pet.getAge()));
    colorField.setText(pet.getColor());
    genderField.setText(String.valueOf(pet.getGender()));
    commentArea.setText(pet.getComment());

    if ("Shop".equals(pet.getLocation())) {
      shopRadioButton.setSelected(true);
    } else if ("Kennel".equals(pet.getLocation())) {
      kennelRadioButton.setSelected(true);
    }

    if ("Sold".equals(pet.getStatus())) {
      soldRadioButton.setSelected(true);
    } else if ("Not sold".equals(pet.getStatus())) {
      notSoldRadioButton.setSelected(true);
    } else if ("Not from VIAPets".equals(pet.getStatus())) {
      notFromVIAPetsRadioButton.setSelected(true);

    if (pet instanceof Dog) {
      speciesField.setText(Dog.getSpecies());

    } else if (pet instanceof Cat) {
      speciesField.setText(Cat.getSpecies());

    } else if (pet instanceof Bird) {

    }
  }
  }

  public void handleSaveChanges() {
    pet.setName(nameField.getText());
    pet.setAge(Integer.parseInt(ageField.getText()));
    pet.setSpecies(speciesField.getText());
    pet.setColor(colorField.getText());
    pet.setGender(genderField.getText());
    pet.setComment(commentArea.getText());

    //Add method to save to the file

  }
}
*/