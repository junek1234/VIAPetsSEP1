/*
package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Pet;

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

    //user clicks edit then its already filled
    nameField.setText(pet.getName());
    ageField.setText(String.valueOf(pet.getAge()));
    speciesField.setText(pet.getClass()); //need to discuss, is species the animal or the species of the animal either way there should be animal in Pet constructor. discuss different animal has different windows
    colorField.setText(pet.getColor());
    genderField.setText(pet.getGender());
    commentArea.setText(pet.getComment());

    if (pet.getLocation().equals("Shop")) {
      shopRadioButton.setSelected(true);
    } else if (pet.getLocation().equals("Kennel")) { //change isInTheShop for getLocation and set it as String
      kennelRadioButton.setSelected(true);
    }

    if (pet.isSold()) {
      soldRadioButton.setSelected(true);
    } else {
      notSoldRadioButton.setSelected(true);
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
