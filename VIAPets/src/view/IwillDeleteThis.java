//package view;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import model.*;
//
//  public class IwillDeleteThis
//  {
//
//    @FXML private TextField petNameTextField;
//    @FXML private TextField petColorTextField;
//    @FXML private TextField petAgeTextField;
//    @FXML private TextField petPriceTextField;
//    @FXML private TextField petBreedTextField;
//    @FXML private TextField petBreederNameTextField;
//    @FXML private TextArea petCommentTextField;
//    @FXML private TextField petSpeciesTextField;
//    @FXML private TextField petFoodTextField;
//
//    @FXML private RadioButton petGenderMaleRadioButton;
//    @FXML private RadioButton petGenderFemaleRadioButton;
//    @FXML private RadioButton petLocationShopRadioButton;
//    @FXML private RadioButton petLocationKennelRadioButton;
//    @FXML private RadioButton petStatusSoldRadioButton;
//    @FXML private RadioButton petStatusNotSoldRadioButton;
//    @FXML private RadioButton petStatusNotFromViaRadioButton;
//    @FXML private RadioButton petSaltWaterYesRadioButton;
//    @FXML private RadioButton petSaltWaterNoRadioButton;
//    @FXML private RadioButton petPredatorYesRadioButton;
//    @FXML private RadioButton petPredatprNoRadioButton;
//
//    @FXML private Button petSaveButton;
//
//
//    public void saveAddPet(ActionEvent actionEvent)
//    {
//      String name = petNameTextField.getText();
//      String color = petColorTextField.getText();
//      int age = Integer.parseInt(petAgeTextField.getText());
//      double price = Double.parseDouble(petPriceTextField.getText());
//      String breed = petBreedTextField.getText();
//      String breederName = petBreederNameTextField.getText();
//      String comment = petCommentTextField.getText();
//      String species = petSpeciesTextField.getText();
//      String food = petFoodTextField.getText();
//
//
//
//
//
//      // Get RadioButton values
//      char gender = petGenderMaleRadioButton.isSelected() ? 'm' :
//          petGenderFemaleRadioButton.isSelected() ? 'f' : '-';
//
//      String location = petLocationShopRadioButton.isSelected() ? "Shop" :
//          petLocationKennelRadioButton.isSelected() ? "Kennel" : "";
//
//      String status = petStatusSoldRadioButton.isSelected() ? "Sold" :
//          petStatusNotSoldRadioButton.isSelected() ? "Not Sold" :
//              petStatusNotFromViaRadioButton.isSelected() ? "Not From Via" : "";
//
//      boolean isSaltWater = petSaltWaterYesRadioButton.isSelected() ? true :
//          petSaltWaterNoRadioButton.isSelected() ? false : false;
//
//      boolean isPredator = petPredatorYesRadioButton.isSelected() ? true :
//          petPredatprNoRadioButton.isSelected() ? false : false;
//
//      // Debug print values to the console (for testing)
//      System.out.println("Name: " + name);
//      System.out.println("Color: " + color);
//      System.out.println("Age: " + age);
//      System.out.println("Price: " + price);
//      System.out.println("Breed: " + breed);
//      System.out.println("Breeder Name: " + breederName);
//      System.out.println("Comment: " + comment);
//      System.out.println("Species: " + species);
//      System.out.println("Food: " + food);
//      System.out.println("Gender: " + gender);
//      System.out.println("Location: " + location);
//      System.out.println("Status: " + status);
//      System.out.println("Saltwater: " + isSaltWater);
//      System.out.println("Predator: " + isPredator);
//
//      Object newPet;
//      switch(type)
//      {
//        case "Dog" ->
//        {
//          newPet = new Dog(MyModelManager.createNextPetID(),name,color,age,gender,
//              location, status, breed, breederName, price,comment);
//        }
//        case "Cat" ->
//        {
//          newPet = new Cat(MyModelManager.createNextPetID(),name,color,age,gender,
//              location, status, breed, breederName, price,comment);
//        }
//        case "Bird" ->
//        {
//          newPet = new Bird(MyModelManager.createNextPetID(),name, color, age, gender,
//              location, status, species, food, price, comment);
//        }
//        case "Fish" ->
//        {
//          newPet = new Fish(MyModelManager.createNextPetID(),name, color,age,gender,
//              location,status, isSaltWater,  species, isPredator, price, comment);
//        }
//        case "Rodent" ->
//        {
//          newPet = new Rodent(MyModelManager.createNextPetID(),name, color, age,  gender,
//              location, status,species, price, comment);
//        }
//        case "Various" ->
//        {
//          newPet = new Various(MyModelManager.createNextPetID(),name, color, age,  gender,
//              location, status,species, price, comment);
//        }
//        default ->
//        {
//          newPet = new Object();
//          System.out.println("Error: could not find the class: "+type);
//        }
//      }
//
//
//      // Save the pet (example; integrate with your actual logic)
//      System.out.println("New Pet saved: " + newPet);
//
//      // Optionally clear fields after saving
//      clearFields();
//    }
//
//    @FXML
//    private void clearFields() {
//      petNameTextField.clear();
//      petColorTextField.clear();
//      petAgeTextField.clear();
//      petPriceTextField.clear();
//      petBreedTextField.clear();
//      petBreederNameTextField.clear();
//      petCommentTextField.clear();
//      petSpeciesTextField.clear();
//      petFoodTextField.clear();
//
//    }
//
//
//  }
//
//
//
//
//
