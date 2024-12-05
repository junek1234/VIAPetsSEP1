package model;

import java.time.LocalDateTime;

public class VIAPets
{
  private int maxKennelSlots;
  private int availableSlots;  //change in astah
  private double bookingPrice;
  private BookingList allBookings;
  private CustomerList allCustomers;
  private SaleList allSales;
  private PetList allPets;


  //reserved slots should not be here i guess - change the Astah design
  //changing reserved slots to available slots
  public VIAPets(int maxKennelSlots, double bookingPrice)
  {
    this.maxKennelSlots = maxKennelSlots;
    this.bookingPrice = bookingPrice;
    setAvailableSlots();
    allBookings = new BookingList();
    allCustomers = new CustomerList();
    allSales = new SaleList();
    allPets = new PetList();
  }

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
      if(allBookings.getBooking(i).getDateInterval().getEndDate().isGreaterThan(getCurrentDate()))
      {
        count++;
      }
    }
    this.availableSlots=count;
  }

  public void setBookingPrice(double bookingPrice)
  {
    this.bookingPrice = bookingPrice;
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
//remove from design
//  public int checkAvailability()
//  {
//    //For later
//    return 0;
//  }

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
