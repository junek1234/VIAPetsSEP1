package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;
import org.w3c.dom.Text;
import utils.XMLHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static model.VIAPets.getCurrentDate;

public class BookingViewController
{

  @FXML private TextField bookingPetIDTextField;
  @FXML private TextField bookingCustomerIDTextField;
  @FXML private DatePicker bookingStartDateDatePicker;
  @FXML private DatePicker bookingEndDateDatePicker;

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
        || bookingEndDateDatePicker.getValue() == null) // 4 getters and 2 isEmpty(6) in total
    {
      //Create and display the alert
      Alert alert1 = new Alert(Alert.AlertType.ERROR); // 1
      alert1.setTitle("Error"); // 1
      alert1.setHeaderText(null); // 1
      alert1.setContentText("Invalid input!"); // 1
      alert1.show();
    }
    else
    {
      try
      {
        //Assigning values to the variables.
        petID = Integer.parseInt(bookingPetIDTextField.getText()); // 1 parseInt and 1 getter. This takes 2
        customerID = Integer.parseInt(bookingCustomerIDTextField.getText()); // 1 parseInt and 1 getter. This takes 2
        startDateFromField = bookingStartDateDatePicker.getValue();
        startDate = new Date(startDateFromField.getDayOfMonth(),
            startDateFromField.getMonthValue(), startDateFromField.getYear()); // This takes 5 (assignation + getters
        endDateFromField = bookingEndDateDatePicker.getValue(); // Getter and assignment. 2
        endDate = new Date(endDateFromField.getDayOfMonth(),
            endDateFromField.getMonthValue(), endDateFromField.getYear()); // This takes 5 (assignation + getters




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


      Pet bookingPet = manager.getAllPets().getPetByID(petID); // Getter plus assignment. This takes 2
      Customer bookingCustomer = manager.getAllCustomers()
          .getCustomer(customerID); // Getter plus assignment. This takes 2
      DateInterval dateInterval = new DateInterval(startDate,endDate); // Getter plus assignment. This takes 2

      //Check if during that period there is an available slot in the kennel for the pet
      if(!manager.isThisPeriodAvailable(dateInterval))
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
        for (int i = 0; i < manager.getAllBookings().getBookings().size(); i++) // Loop through all bookings. This takes 1 + n.
        {
          //Check if a pet already has a booking for that period.
          if((manager.getAllBookings().getBookings().get(i).getPet().getPetID() == petID))
            if((dateInterval.isBetween(manager.getAllBookings().getBookings().get(i).getDateInterval()
              .getStartDate()))||(dateInterval.isBetween(manager.getAllBookings().getBookings().get(i).getDateInterval()
              .getEndDate())))
          {
            //Create and display the alert
            Alert alert1 = new Alert(Alert.AlertType.ERROR); //1
            alert1.setTitle("Error"); //1
            alert1.setHeaderText(null); //1
            alert1.setContentText("There is already a booking for this pet in this period!"); //1
            alert1.show(); //1
            return;
          }
        }


        //if everything is fine


        try
        {
          bookingPet.setLocation("Kennel"); //Change the location of the pet to kennel. This takes 1
          manager.editPet(petID, bookingPet); //1
          Booking newBooking = new Booking(MyModelManager.createNextBookingID(),
              bookingPet, bookingCustomer, dateInterval); // Assignment + create next booking id. This takes 1 + 13 = 14.


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

//     We have no recursion so we do not need a base case.
//     We loop n times in the for loop because that is the length of the bookings list.
//     T(n) = 97 + n, so ignoring constants, we get T(n) = O(n).
//     We chose this method because it is the one with the biggest time complexity in our code.
//
//     Dominating Term Analysis
//     T(n) = 97 + n
//     - Dominating Term: n
//     - Coefficient Analysis: The coefficient 1 comes from the operations performed in each iteration of both the while and for loops.
//     -Explanation: The coefficient 1 influences practical runtime by multiplying the n factor.
//
//     Optimisation Suggestion
//     -By creating the alerts outside the ifs and just changing the text and showing them inside  the ifs would reduce the constant time complexity by almost a half.
//

  }

}











