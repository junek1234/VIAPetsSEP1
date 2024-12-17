package model;

import utils.XMLHandler;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

// dont make it static
public class VIAPets implements Serializable
{
  public static int maxKennelSlots;
  public static int availableSlotsToday;  //change in astah
  public static double bookingPrice;
  private BookingList allBookings;
  private CustomerList allCustomers;
  private SaleList allSales;
  public static PetList allPets;// must be static because of static method updateXML

  //add this too
  public static String lastCustomerID;
  public static String lastPetID;
  public static String lastBookingID;
  public static String lastSaleID;

  //and this
  public static String[] xmlLines;

  //reserved slots should not be here i guess - change the Astah design
  //changing reserved slots to available slots

  public void setMaxKennelSlots(int maxKennelSlots)
  {
    this.maxKennelSlots = maxKennelSlots;
  }

  public void setAvailableSlots(Date date)
  {
    //counting how many slots are occupied in the kennel
    int count = 0; // Initialize count and start at 0. 2
    for (int i = 0; i < allBookings.getBookings().size(); i++) // Loop through all bookings. n
    {
      //Check if the booking is in between the start and end date of the other bookings
      if((!date.isGreaterThan(allBookings.getBookings().get(i).getDateInterval().getEndDate()))
          &&(!allBookings.getBookings().get(i).getDateInterval().getStartDate().isGreaterThan(date)))
      {
        count++; // Add one to the count if true. 1
      }
    }
    availableSlotsToday = maxKennelSlots - count; //update the available slots of that given date subtracting the count to the maximum capacity of the kennel. 2
  }

  public void setBookingPrice(double bookingPrice)
  {
    this.bookingPrice = bookingPrice;
  }

  public void setLastCustomerID(String lastCustomerID)
  {
    this.lastCustomerID = lastCustomerID;
  }

  public void setLastPetID(String lastPetID)
  {
    this.lastPetID = lastPetID;
  }

  public void setLastBookingID(String lastBookingID)
  {
    this.lastBookingID = lastBookingID;
  }

  public void setLastSaleID(String lastSaleID)
  {
    this.lastSaleID = lastSaleID;
  }

  public void setAllBookings(BookingList allBookings)
  {
    this.allBookings = allBookings;
  }

  public void setAllCustomers(CustomerList allCustomers)
  {
    this.allCustomers = allCustomers;
  }

  public void setAllSales(SaleList allSales)
  {
    this.allSales = allSales;
  }

  public void setAllPets(PetList allPets)
  {
    this.allPets = allPets;
  }

  public int getMaxKennelSlots()
  {
    return maxKennelSlots;
  }

  public int getAvailableSlots()
  {
    return availableSlotsToday;
  }

  public double getBookingPrice()
  {
    return bookingPrice;
  }

  public BookingList getAllBookings()
  {
    return allBookings;
  }

  public CustomerList getAllCustomers()
  {
    return allCustomers;
  }

  public SaleList getAllSales()
  {
    return allSales;
  }

  public PetList getAllPets()
  {
    return allPets;
  }
  // change Astah
  public static Date getCurrentDate()
  {
    LocalDateTime now = LocalDateTime.now();
    return new Date(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
  }


  public String toString()
  {
    return "VIAPets{" + "maxKennelSlots=" + maxKennelSlots + ", availableSlots="
        + availableSlotsToday + ", bookingPrice=" + bookingPrice + ", allBookings="
        + allBookings + ", allCustomers=" + allCustomers + ", allSales="
        + allSales + ", allPets=" + allPets + '}';
  }
}



