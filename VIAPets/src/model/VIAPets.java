package model;

import utils.XMLHandler;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

// dont make it static
public class VIAPets implements Serializable
{
  public static int maxKennelSlots;
  public static int availableSlots;  //change in astah
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

  public void setAvailableSlots()
  {
    //counting how many slots are occupied in the kennel
    int count=0;
    for (int i = 0; i < allBookings.getBookings().size(); i++)
    {
      if((allBookings.getBookings().get(i).getDateInterval().getEndDate().isGreaterThan(getCurrentDate()))&&getCurrentDate().isGreaterThan(allBookings.getBookings().get(i).getDateInterval().getStartDate()))
      {
        count++;
      }
      else if(allBookings.getBookings().get(i).getDateInterval().getEndDate().equals(getCurrentDate())&&(allBookings.getBookings().get(i).getDateInterval().getEndDate().getHour()> LocalTime.now().getHour()))
      {
        count++;
      }
      else if(allBookings.getBookings().get(i).getDateInterval().getStartDate().equals(getCurrentDate())&&allBookings.getBookings().get(i).getDateInterval().getEndDate().getHour()< LocalTime.now().getHour())
      {
        count++;
      }
    }
    availableSlots=maxKennelSlots-count;
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
    return availableSlots;
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
    return new Date(now.getDayOfMonth(), now.getMonthValue(), now.getYear(), now.getHour());
  }


  public String toString()
  {
    return "VIAPets{" + "maxKennelSlots=" + maxKennelSlots + ", availableSlots="
        + availableSlots + ", bookingPrice=" + bookingPrice + ", allBookings="
        + allBookings + ", allCustomers=" + allCustomers + ", allSales="
        + allSales + ", allPets=" + allPets + '}';
  }
}
