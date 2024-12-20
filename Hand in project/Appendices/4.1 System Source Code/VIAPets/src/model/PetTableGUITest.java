package model;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetTableGUITest extends Application {

  @Override
  public void start(Stage primaryStage) {
    // Create sample data (this should come from your actual list of Pet objects)
    ObservableList<Pet> pets = FXCollections.observableArrayList(
        new Dog(1, "Buddy", "Brown", 4, 'M', "New York", "Available", "idk", "idk", 150.0, "Friendly"),
        new Dog(2, "Luna", "Black", 2, 'F', "Boston", "Adopted", "idk", "idk",100.0, "Playful")
    );

    // Create TableView
    TableView<Pet> petTable = new TableView<>();
    petTable.setItems(pets);

    // Create columns for each field in the Pet class
    TableColumn<Pet, Number> petIDColumn = new TableColumn<>("Pet ID");
    petIDColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPetID()));

    TableColumn<Pet, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

    TableColumn<Pet, String> colorColumn = new TableColumn<>("Color");
    colorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));

    TableColumn<Pet, Number> ageColumn = new TableColumn<>("Age");
    ageColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAge()));

    TableColumn<Pet, String> genderColumn = new TableColumn<>("Gender");
    genderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getGender())));

    TableColumn<Pet, String> locationColumn = new TableColumn<>("Location");
    locationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocation()));

    TableColumn<Pet, String> statusColumn = new TableColumn<>("Status");
    statusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));

    // Add columns to the table
    petTable.getColumns().addAll(petIDColumn, nameColumn, colorColumn, ageColumn, genderColumn, locationColumn, statusColumn);

    // Create layout and add the TableView
    VBox vbox = new VBox(petTable);
    Scene scene = new Scene(vbox);

    primaryStage.setTitle("Pet Table");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}