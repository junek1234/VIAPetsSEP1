package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Pet;

import java.net.URL;
import java.util.ResourceBundle;

public class PetViewController implements Initializable {
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

  public void initialize(URL location, ResourceBundle resources) {
    petIDColumn.setCellValueFactory(new PropertyValueFactory<>("petID"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    isInShopColumn.setCellValueFactory(new PropertyValueFactory<>("isInShop"));
    isSoldColumn.setCellValueFactory(new PropertyValueFactory<>("isSold"));

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
    pet.setName("");
    petTable.refresh();
  }

  private void handleDeletePet(Pet pet) {
    petList.remove(pet);
  }
}
