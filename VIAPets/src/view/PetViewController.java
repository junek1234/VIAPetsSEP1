package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PetViewController implements Initializable {

  MyModelManager petManager = new MyModelManager();
  private ObservableList<Pet> petList = FXCollections.observableArrayList();

  @FXML
  private TableView<Pet> petTable;

  @FXML
  private TableColumn<Pet, String> petIDColumn;

  @FXML
  private TableColumn<Pet, String> nameColumn;

  @FXML
  private TableColumn<Pet, Boolean> isInShopColumn;

  @FXML
  private TableColumn<Pet, String> isSoldColumn;

  @FXML
  private TableColumn<Pet, Void> actionColumn;

  //if I dont put these args, error shows not rrly sure
  public void initialize(URL location, ResourceBundle resources) {
    petIDColumn.setCellValueFactory(new PropertyValueFactory<>("petID"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    isInShopColumn.setCellValueFactory(new PropertyValueFactory<>("isInShop"));
    isSoldColumn.setCellValueFactory(new PropertyValueFactory<>("isSold"));

    PetList pets = petManager.getAllPets(); //PetList --> ArrayList<Pet> pets

    petList.addAll(pets.getPets());

    addActionButtons();

    petTable.setItems(petList);
  }

  private void addActionButtons() {
    actionColumn.setCellFactory(param -> new TableCell<>() {
      private final Button editButton = new Button("Edit");
      private final Button deleteButton = new Button("Delete");

      {
        editButton.setOnAction(event -> {
          Pet pet = getTableView().getItems().get(getIndex());
          handleEditPet(pet);
        });

        deleteButton.setOnAction(event -> {
          Pet pet = getTableView().getItems().get(getIndex());
          handleDeletePet(pet);
        });
      }

    });
  }

  private void handleEditPet(Pet pet) {

    String petID = petIDField.getText(); //create these ids n connect them in scenebuilder, also connect the whole controller
    String name = nameField.getText();
    boolean isInShop = isInShopCheckBox.isSelected();
    boolean isSold = isSoldCheckBox.isSelected();

    if (petID.isEmpty() || name.isEmpty()) {

      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Invalid Input");
      alert.setContentText("Please fill in all required fields.");
      alert.showAndWait();
      return;
  }

    Pet newPet = new Pet(petID, name, isInShop, isSold);

    MyModelManager.addPet(newPet);

    petList.add(newPet);

    clearFields();
  }

  private void clearFields() {
    petIDField.clear();
    nameField.clear();
    isInShopCheckBox.setSelected(false);
    isSoldCheckBox.setSelected(false);
  }

  private void handleDeletePet(Pet pet) {
    //petList.remove(pet); not correct cuz deleting only form the table and the table will get it back when reading the binary file
    petManager.deletePet(pet.getPetID()); //deletes from the file, handle exception
  }

}
