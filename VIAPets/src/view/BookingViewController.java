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
  @FXML private TextField bookingStartHourTextField;
  @FXML private TextField bookingEndHourTextField;

  @FXML private Button saveAddBooking;

  @FXML public TextField maxKennelSlotsTextField;
  @FXML public TextField pricePerHourTextField;

  public void saveAddBooking(ActionEvent actionEvent)
  {
    int petID = 0;//need to add exception later
    int customerID = 0;//need to add exception later
    LocalDate startDateFromField;
    Date startDate = null;
    Date endDate = null;
    LocalDate endDateFromField;
    int startHour = 0;
    int endHour = 0;
    if (bookingPetIDTextField.getText().isEmpty()
        || bookingCustomerIDTextField.getText().isEmpty()
        || bookingStartHourTextField.getText().isEmpty()
        || bookingEndHourTextField.getText().isEmpty()
        || bookingStartDateDatePicker.getValue() == null
        || bookingEndDateDatePicker.getValue() == null)
    {
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("Invalid input!");
      alert1.show();
      return;//it stops the method when catching exception
    }
    else
    {
      try
      {
        petID = Integer.parseInt(bookingPetIDTextField.getText());
        customerID = Integer.parseInt(bookingCustomerIDTextField.getText());
        startHour = Integer.parseInt(bookingStartHourTextField.getText());
        endHour = Integer.parseInt(bookingEndHourTextField.getText());
        startDateFromField = bookingStartDateDatePicker.getValue();
        startDate = new Date(startDateFromField.getDayOfMonth(),
            startDateFromField.getMonthValue(), startDateFromField.getYear(),
            startHour);
        endDateFromField = bookingEndDateDatePicker.getValue();
        endDate = new Date(endDateFromField.getDayOfMonth(),
            endDateFromField.getMonthValue(), endDateFromField.getYear(),
            endHour);

      }
      catch (NumberFormatException e)
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("Invalid input!");
        alert1.show();
        return;//it stops the method when catching exception
      }

      MyModelManager manager = new MyModelManager();

      Pet bookingPet = manager.getAllPets().getPetByID(petID);
      Customer bookingCustomer = manager.getAllCustomers()
          .getCustomer(customerID);
      //errors
      if (bookingPet == null)
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("No pet with ID: " + petID + "!");
        alert1.show();

      }
      else if (bookingPet.getStatus().equals("Not Sold"))
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("This pet has not been sold yet!");
        alert1.show();
      }
      else if (bookingCustomer == null)
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("No customer with ID: " + customerID + "!");
        alert1.show();
      }
      else
      {

        //if everything is fine

        try
        {
          bookingPet.setLocation("Kennel");
          manager.editPet(petID, bookingPet);
          DateInterval newDateInterval = new DateInterval(startDate, endDate);
          Booking newBooking = new Booking(MyModelManager.createNextBookingID(),
              bookingPet, bookingCustomer, newDateInterval);
          System.out.println(newBooking);

          manager.addBooking(newBooking);
          Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene()
              .getWindow();
          stage.close();

        }
        catch (IOException e)
        {
          throw new RuntimeException(e);
        }

        XMLHandler.updateXML();

      }

    }

  }
//bookings Settings actions

  //displaying current settings while opening this window
  public void initialize()
  {
    pricePerHourTextField.setText(VIAPets.bookingPrice+"");
    maxKennelSlotsTextField.setText(VIAPets.maxKennelSlots+"");
  }
  public void saveBookingsSettings(ActionEvent actionEvent)
  {

      if(pricePerHourTextField.getText().isEmpty()||maxKennelSlotsTextField.getText().isEmpty()){
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("Invalid input!");
        alert1.show();
      }
      else {
        try
        {
          MyModelManager manager = new MyModelManager();
          manager.saveBookingsSettings(Integer.parseInt(maxKennelSlotsTextField.getText()),Double.parseDouble(pricePerHourTextField.getText()));
          Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene()
              .getWindow();
          stage.close();
        }
        catch (NumberFormatException e)
        {
          Alert alert1 = new Alert(Alert.AlertType.ERROR);
          alert1.setTitle("Error");
          alert1.setHeaderText(null);
          alert1.setContentText("Invalid input!");
          alert1.show();
        }
      }

  }
}











