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
        startDateFromField = bookingStartDateDatePicker.getValue();
        startDate = new Date(startDateFromField.getDayOfMonth(),
            startDateFromField.getMonthValue(), startDateFromField.getYear());
        endDateFromField = bookingEndDateDatePicker.getValue();
        endDate = new Date(endDateFromField.getDayOfMonth(),
            endDateFromField.getMonthValue(), endDateFromField.getYear());

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
      DateInterval dateInterval = new DateInterval(startDate,endDate);
      //errors
      if(!manager.isThisPeriodAvailable(dateInterval))
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("This period is not available!");
        alert1.show();
      }
      else if (bookingPet == null)
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
        for (int i = 0; i < manager.getAllBookings().getBookings().size(); i++)
        {
          if((manager.getAllBookings().getBookings().get(i).getPet().getPetID()==petID))
              if((dateInterval.isBetween(manager.getAllBookings().getBookings().get(i).getDateInterval()
              .getStartDate()))||(dateInterval.isBetween(manager.getAllBookings().getBookings().get(i).getDateInterval()
              .getEndDate())))
          {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Error");
            alert1.setHeaderText(null);
            alert1.setContentText("There is already a booking for this pet in this period!");
            alert1.show();
            return;
          }
        }

        //if everything is fine

        try
        {
          bookingPet.setLocation("Kennel");
          manager.editPet(petID, bookingPet);
          Booking newBooking = new Booking(MyModelManager.createNextBookingID(),
              bookingPet, bookingCustomer, dateInterval);

          manager.addBooking(newBooking);
          Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene()
              .getWindow();
          stage.close();
          MyModelManager managerUpdateLists = new MyModelManager();

          XMLHandler.updateXML();

        }
        catch (IOException e)
        {
          throw new RuntimeException(e);
        }

      }

    }

  }


}











