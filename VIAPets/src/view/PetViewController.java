//package view;
//
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
//import model.*;
//
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.ToggleGroup; // not needed if set in scenebuilder ig
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//public class PetViewController
//{
//
//  @FXML private TableView<Pet> petTable = new TableView<>();
//
//  @FXML private TableColumn<Pet, Number> petIDColumn = new TableColumn<>(
//      "petID");
//  @FXML private VBox vBox;
//
//  @FXML private TableColumn<Pet, String> petNameColumn;
//
//  @FXML private TableColumn<Pet, String> petColorColumn;
//
//  @FXML private TableColumn<Pet, String> petGenderColumn;
//
//  @FXML private TableColumn<Pet, String> petPriceColumn;
//
//  @FXML private TableColumn<Pet, Void> petActionColumn;
//
//  //connect ids below in scenebuilder that guillermo has
//  @FXML private TextField nameField;
//
//  @FXML private TextField color;
//
//  @FXML private TextField age;
//
//  @FXML private TextField gender; //isnt gender radiobutton or the checkbox you cant check both. cuz on discord screenpic is as a textfield.
//
//  @FXML private RadioButton shop;
//
//  @FXML private RadioButton kennel;
//
//  @FXML private RadioButton sold;
//
//  @FXML private RadioButton notSold;
//
//  @FXML private RadioButton notFromVIAPets;
//
//  @FXML private TextField species;
//
//  @FXML private TextArea comment;
//
//  private ObservableList<Pet> petList;
//
//  MyModelManager petManager = new MyModelManager();
//
//  //if I dont put these args, error shows not rrly sure
//  public void initialize()
//  {
//    petList = FXCollections.observableArrayList(
//        petManager.getAllPets().getPets());
//    ObservableList<Pet> pets = FXCollections.observableArrayList(
//        new Dog(1, "Buddy", "Brown", 4, 'M', "New York", "Available", "idk",
//            "idk", 150.0, "Friendly"),
//        new Dog(2, "Luna", "Black", 2, 'F', "Boston", "Adopted", "idk", "idk",
//            100.0, "Playful"));
//
//
//    petTable.setItems(pets);
//
//    // Create columns for each field in the Pet class
//   petIDColumn = new TableColumn<>("Pet ID");
//    petIDColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPetID()));
//
//    petNameColumn = new TableColumn<>("Pet Name");
//    petNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
//
//    petColorColumn = new TableColumn<>("Color");
//    petColorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
//
//    petGenderColumn = new TableColumn<>("Gender");
//    petGenderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getGender())));
//
//    petPriceColumn = new TableColumn<>("Price");
//    petPriceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBasePrice())));
//
//    petActionColumn = new TableColumn<>("Actions");
////    petGenderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getGender())));
//    // Add columns to the table
//    petTable.getColumns().addAll(petIDColumn, petNameColumn, petColorColumn, petGenderColumn);
//
//
//
//
//  }
//}