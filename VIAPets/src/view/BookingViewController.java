package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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


  public void saveAddBooking(ActionEvent actionEvent)
  {
    int petID = 0;//need to add exception later
    int customerID = 0;//need to add exception later
    LocalDate startDateFromField;
    Date startDate = null;
    Date endDate = null;
    LocalDate endDateFromField;
    int startHour=0;
    int endHour=0;
    if(bookingPetIDTextField.getText().isEmpty())
    {
      System.out.println("Error: Enter pet ID"); //later in exceptions
    }
    else
    {
      petID=Integer.parseInt(bookingPetIDTextField.getText());
    }


    if(bookingCustomerIDTextField.getText().isEmpty())
    {
      System.out.println("Error: Enter customer ID"); //later in exceptions
    }
    else
    {
      customerID=Integer.parseInt(bookingCustomerIDTextField.getText());
    }

    if(bookingStartHourTextField.getText().isEmpty())
    {
      System.out.println("Error: Enter Start Hour"); //later in exceptions
    }
    else
    {
      startHour=Integer.parseInt(bookingStartHourTextField.getText());
    }
    if(bookingEndHourTextField.getText().isEmpty())
    {
      System.out.println("Error: Enter End Hour"); //later in exceptions
    }
    else
    {
      endHour=Integer.parseInt(bookingEndHourTextField.getText());
    }

  if(bookingStartDateDatePicker.getValue()==null)
    {
      System.out.println("Error: Enter Start Date"); //later in exceptions
    }
    else
    {
      startDateFromField=bookingStartDateDatePicker.getValue();
      startDate= new Date(startDateFromField.getDayOfMonth(),startDateFromField.getMonthValue(),startDateFromField.getYear(),startHour);
    }
    if(bookingEndDateDatePicker.getValue()==null)
    {
      System.out.println("Error: Enter End Date"); //later in exceptions
    }
    else
    {
      endDateFromField=bookingEndDateDatePicker.getValue();
      endDate= new Date(endDateFromField.getDayOfMonth(),endDateFromField.getMonthValue(),endDateFromField.getYear(),endHour);
    }

   MyModelManager manager = new MyModelManager();
    ArrayList<Pet> petsCopy = manager.getAllPets().getPets();
    ArrayList<Customer> customersCopy = manager.getAllCustomers().getCustomers();

    Pet bookingPet=manager.getAllPets().getPetByID(petID);
    Customer bookingCustomer=manager.getAllCustomers().getCustomer(customerID);


    //if everything is fine
    DateInterval newDateInterval = new DateInterval(startDate,endDate);
    Booking newBooking = new Booking(MyModelManager.createNextBookingID(),bookingPet,bookingCustomer,newDateInterval);
    System.out.println(newBooking);
    try
    {
      manager.addBooking(newBooking);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }


    XMLHandler.updateXML();




    clearFields();
  }

  @FXML
  private void clearFields() {
    bookingPetIDTextField.clear();
    bookingCustomerIDTextField.clear();
    bookingStartHourTextField.clear();
    bookingEndHourTextField.clear();


    bookingStartDateDatePicker.setValue(null);
    bookingEndDateDatePicker.setValue(null);


  }


}








