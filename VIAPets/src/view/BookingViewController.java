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
import org.w3c.dom.Text;
import utils.XMLHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static model.VIAPets.getCurrentDate;

public class BookingViewController
{

  @FXML private TextField bookingPetIDTextField;
  @FXML private TextField bookingCustomerIDTextField;
  @FXML private DatePicker bookingStartDateDatePicker;
  @FXML private DatePicker bookingEndDateDatePicker;

  @FXML private TextField bookingPetIDEditTextField;
  @FXML private TextField bookingCustomerIDEditTextField;
  @FXML private DatePicker bookingStartDateEditDatePicker;
  @FXML private DatePicker bookingEndDateEditDatePicker;

  private Booking selectedBooking;

  @FXML private Button bookingSaveButton;

  public void saveAddBooking(ActionEvent actionEvent)
  {
    //Variable declaration and assignment
    int petID = 0;// 1
    int customerID = 0;// 1
    LocalDate startDateFromField; // 1
    Date startDate = null; // 1
    Date endDate = null;// 1
    LocalDate endDateFromField;// 1
    int startHour = 0; // 1
    int endHour = 0; // 1
    //Checking if all fields are empty.
    if (bookingPetIDTextField.getText().isEmpty()
        || bookingCustomerIDTextField.getText().isEmpty()
        || bookingStartDateDatePicker.getValue() == null
        || bookingEndDateDatePicker.getValue()
        == null) // 4 getters and 2 isEmpty(6) in total
    {
      //Create and display the alert
      Alert alert1 = new Alert(Alert.AlertType.ERROR); // 1
      alert1.setTitle("Error"); // 1
      alert1.setHeaderText(null); // 1
      alert1.setContentText("Invalid input!"); // 1
      alert1.show(); // 1
      return;//it stops the method when catching exception
    }
    else
    {
      try
      {
        //Assigning values to the variables.
        petID = Integer.parseInt(
            bookingPetIDTextField.getText()); // 1 parseInt and 1 getter. This takes 2
        customerID = Integer.parseInt(
            bookingCustomerIDTextField.getText()); // 1 parseInt and 1 getter. This takes 2
        startDateFromField = bookingStartDateDatePicker.getValue();
        startDate = new Date(startDateFromField.getDayOfMonth(),
            startDateFromField.getMonthValue(),
            startDateFromField.getYear()); // This takes 5 (assignation + getters
        endDateFromField = bookingEndDateDatePicker.getValue(); // Getter and assignment. 2
        endDate = new Date(endDateFromField.getDayOfMonth(),
            endDateFromField.getMonthValue(),
            endDateFromField.getYear()); // This takes 5 (assignation + getters

      }
      catch (NumberFormatException e)
      {
        //Create and display the alert
        Alert alert1 = new Alert(Alert.AlertType.ERROR); // 1
        alert1.setTitle("Error");// 1
        alert1.setHeaderText(null);// 1
        alert1.setContentText("Invalid input!");// 1
        alert1.show();// 1
        return;//it stops the method when catching exception
      }

      MyModelManager manager = new MyModelManager(); // 1

      Pet bookingPet = manager.getAllPets()
          .getPetByID(petID); // Getter plus assignment. This takes 2
      Customer bookingCustomer = manager.getAllCustomers()
          .getCustomer(customerID); // Getter plus assignment. This takes 2
      DateInterval dateInterval = new DateInterval(startDate,
          endDate); // Getter plus assignment. This takes 2

      if (!manager.isThisPeriodAvailable(dateInterval))
      {
        //Create and display the alert
        Alert alert1 = new Alert(Alert.AlertType.ERROR); // 1
        alert1.setTitle("Error"); // 1
        alert1.setHeaderText(null); // 1
        alert1.setContentText("This period is not available!"); // 1
        alert1.show(); // 1
      }
      else if (bookingPet == null)
      {
        //Create and display the alert
        Alert alert1 = new Alert(Alert.AlertType.ERROR); // 1
        alert1.setTitle("Error"); // 1
        alert1.setHeaderText(null); // 1
        alert1.setContentText("No pet with ID: " + petID + "!"); // 1
        alert1.show(); // 1

      }
      else if (bookingPet.getStatus().equals("Not Sold"))
      {
        //Create and display the alert
        Alert alert1 = new Alert(Alert.AlertType.ERROR); // 1
        alert1.setTitle("Error"); // 1
        alert1.setHeaderText(null); // 1
        alert1.setContentText("This pet has not been sold yet!"); // 1
        alert1.show(); // 1
      }
      else if (bookingCustomer == null)
      {
        //Create and display the alert
        Alert alert1 = new Alert(Alert.AlertType.ERROR); // 1
        alert1.setTitle("Error"); // 1
        alert1.setHeaderText(null); // 1
        alert1.setContentText("No customer with ID: " + customerID + "!"); // 1
        alert1.show(); // 1
      }
      else
      {
        for (int i = 0; i < manager.getAllBookings().getBookings()
            .size(); i++) // Checking if there is a slot available for all the days of the new booking. n
        {
          //Check if a pet already has a booking for that period.       if((manager.getAllBookings().getBookings().get(i).getPet().getPetID()==petID))
          if ((dateInterval.isBetween(
              manager.getAllBookings().getBookings().get(i).getDateInterval()
                  .getStartDate())) || (dateInterval.isBetween(
              manager.getAllBookings().getBookings().get(i).getDateInterval()
                  .getEndDate())))
          {
            //Create and display the alert
            Alert alert1 = new Alert(Alert.AlertType.ERROR); //1
            alert1.setTitle("Error"); //1
            alert1.setHeaderText(null); //1
            alert1.setContentText(
                "There is already a booking for this pet in this period!"); //1
            alert1.show(); //1
            return;
          }
        }

        try
        {
          bookingPet.setLocation(
              "Kennel"); //Change the location of the pet to kennel. This takes 1
          manager.editPet(petID, bookingPet); //1
          Booking newBooking = new Booking(MyModelManager.createNextBookingID(),
              bookingPet, bookingCustomer,
              dateInterval); // Assignment + create next booking id. This takes 1 + 13 = 14.

          manager.addBooking(newBooking); //1
          Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene()
              .getWindow(); //Assignment plus 3 getters. This takes 4
          stage.close(); //1
          MyModelManager managerUpdateLists = new MyModelManager(); //1

          XMLHandler.updateXML(); //1

        }
        catch (IOException e)
        {
          throw new RuntimeException(e);
        }
      }
    }
  }

  public void saveEditBooking(ActionEvent actionEvent) {
    String petID = bookingPetIDEditTextField.getText();
    String customerID = bookingCustomerIDEditTextField.getText();
    LocalDate startDateLocal = bookingStartDateEditDatePicker.getValue();
    LocalDate endDateLocal = bookingEndDateEditDatePicker.getValue();

    Date startDate = new Date(startDateLocal.getDayOfMonth(),
        startDateLocal.getMonthValue(), startDateLocal.getYear());
    Date endDate = new Date(endDateLocal.getDayOfMonth(),
        endDateLocal.getMonthValue(), endDateLocal.getYear());

    // Validate numeric fields
    int parsedPetID = 0;
    int parsedCustomerID = 0;
    try {
      parsedPetID = Integer.parseInt(petID);
      parsedCustomerID = Integer.parseInt(customerID);
    } catch (NumberFormatException e) {
      // Handle invalid input
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Input Error");
      alert.setHeaderText("Invalid Input");
      alert.setContentText("Please ensure Pet ID and Customer ID are valid numbers.");
      alert.showAndWait();
      return;
    }

    // Confirmation
    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Save Changes");
    confirmationAlert.setHeaderText("Are you sure you want to save the changes?");
    confirmationAlert.setContentText("Click OK to save or Cancel to cancel.");

    ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);
    if (result == ButtonType.OK) {
      try {
        // Retrieve the pet by ID from the PetList
        MyModelManager manager = new MyModelManager();
        PetList petList = manager.getAllPets();
        Pet newPet = petList.getPetByID(parsedPetID);

        if (newPet == null) {
          Alert petAlert = new Alert(Alert.AlertType.ERROR);
          petAlert.setTitle("Pet Not Found");
          petAlert.setHeaderText("Invalid Pet ID");
          petAlert.setContentText("No pet exists with the provided Pet ID. Please try again.");
          petAlert.showAndWait();
          return;
        }

        // Retrieve the customer by ID from the CustomerList
        CustomerList customerList = manager.getAllCustomers();
        Customer newCustomer = customerList.getCustomerByID(parsedCustomerID);

        if (newCustomer == null) {
          Alert customerAlert = new Alert(Alert.AlertType.ERROR);
          customerAlert.setTitle("Customer Not Found");
          customerAlert.setHeaderText("Invalid Customer ID");
          customerAlert.setContentText("No customer exists with the provided Customer ID. Please try again.");
          customerAlert.showAndWait();
          return;
        }

        // Update booking with the new pet and customer
        Booking booking = selectedBooking;
        booking.setPet(newPet);
        booking.setCustomerID(parsedCustomerID);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);

        // Save the updated booking to the file
        manager.editBooking(selectedBooking.getBookingID(), selectedBooking);

        // Close the window
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


  public void fillBooking(Booking booking) {
    selectedBooking = booking;

    // Set the pet ID
    bookingPetIDEditTextField.setText(String.valueOf(booking.getPet().getPetID()));

    // Set the customer ID
    bookingCustomerIDEditTextField.setText(String.valueOf(booking.getCustomer().getCustomerID()));

    // Define a formatter to match the Date class's toString() format
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Parse and set the start and end dates
    bookingStartDateEditDatePicker.setValue(
        LocalDate.parse(booking.getStartDate().toString(), formatter));
    bookingEndDateEditDatePicker.setValue(
        LocalDate.parse(booking.getEndDate().toString(), formatter));
  }

  public void handleEditAction(Booking booking){
      try
      {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("fxml/bookings/EditBooking.fxml"));
        Parent root = loader.load();

        BookingViewController controller = loader.getController();

        controller.fillBooking(booking);

        Stage editStage = new Stage();
        editStage.setTitle("Edit Booking");
        editStage.setScene(new Scene(root));
        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.showAndWait();
      }

      catch (IOException e)
      {
        // Show a log the error message
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Failed to load the edit window.");
        alert.setContentText(
            "There was an error loading the FXML for the edit window.");
        alert.showAndWait();
      }
    }


    }

//     We have no recursion so we do not need a base case.
//     We loop n times in the for loop because that is the length of the bookings list.
//     T(n) = 96 + n, so ignoring constants, we get T(n) = O(n).
//     We chose this method because it is the one with the biggest time complexity in our code.
//
//
//     Dominating Term Analysis
//     T(n) = 96 + n
//     - Dominating Term: n
//     - Coefficient Analysis: The coefficient 1 comes from the operations performed in each iteration of both the while and for loops.
//     -Explanation: The coefficient 1 influences practical runtime by multiplying the n factor.
//
//     Optimisation Suggestion
//     -By creating the alerts outside the ifs and just changing the text and showing them inside  the ifs would reduce the constant time complexity by almost a half.
//













