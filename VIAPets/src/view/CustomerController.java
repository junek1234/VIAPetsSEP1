//package view;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//
//import java.io.IOException;
//
//public class CustomerController
//{
//  // default customer view
//  @FXML Button addCustomerButton;
//  @FXML Button editCustomerButton;
//  @FXML Button deleteCustomerButton;
//  @FXML Button searchButton;
//  @FXML TextField searchBarTextField;
//
//  // add customer view
//  @FXML TextField CustomerIDTextField;
//  @FXML TextField nameTextField;
//  @FXML TextField PhoneNumberTextField;
//  @FXML TextField emailTextField;
//  @FXML Button addButton;
//
//  public void addTest(ActionEvent e)
//  {
//    System.out.println("works?");
//  }
//
//  @FXML
//  private void handleSaveButton() {
//    // Example fields
//    String name = nameField.getText();
//    String age = ageField.getText();
//    String species = speciesField.getText();
//    String color = colorField.getText();
//    String gender = genderField.getText();
//    String comment = commentArea.getText();
//    String location = shopRadioButton.isSelected() ? "Shop" : "Kennel"; // Example for radio buttons
//    boolean isSold = soldRadioButton.isSelected();
//
//    // Input validation
//    if (name.isEmpty() || age.isEmpty() || species.isEmpty() || color.isEmpty()) {
//      Alert alert = new Alert(Alert.AlertType.ERROR);
//      alert.setTitle("Validation Error");
//      alert.setHeaderText("Missing Information");
//      alert.setContentText("Please fill in all required fields.");
//      alert.showAndWait();
//      return;
//    }
//
//    try {
//      int ageInt = Integer.parseInt(age); // Validate numeric input for age
//      Pet newPet = new Pet(name, ageInt, species, color, gender, comment, location, isSold);
//
//      // Save the new pet (e.g., to a list or file)
//      MyModelManager.getInstance().addPet(newPet);
//
//      // Notify the user
//      Alert alert = new Alert(Alert.AlertType.INFORMATION);
//      alert.setTitle("Success");
//      alert.setHeaderText(null);
//      alert.setContentText("Pet saved successfully!");
//      alert.showAndWait();
//
//      // Return to the previous window
//      if (previousStage != null) {
//        previousStage.show();
//      }
//      Stage currentStage = (Stage) saveButton.getScene().getWindow();
//      currentStage.close();
//
//    } catch (NumberFormatException e) {
//      Alert alert = new Alert(Alert.AlertType.ERROR);
//      alert.setTitle("Invalid Input");
//      alert.setHeaderText("Age must be a number");
//      alert.setContentText("Please enter a valid numeric age.");
//      alert.showAndWait();
//    }
//  }
//
//}
