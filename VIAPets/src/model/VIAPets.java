package model;

public class VIAPets
{
  private int maxKennelSlots;
  private int reservedSlots;
  private double bookingPrice;
  private BookingList allBookings;
  private CustomerList allCustomers;
  private SaleList allSales;
  private PetList allPets;

  public VIAPets(int maxKennelSlots, double bookingPrice) //reserved slots should not be here i guess - change the Astah design
  {
    this.maxKennelSlots = maxKennelSlots;
    this.bookingPrice = bookingPrice;
    reservedSlots=0;
    allBookings = new BookingList();
    allCustomers = new CustomerList();
    allSales = new SaleList();
    allPets = new PetList();
  }

  public void setMaxKennelSlots(int maxKennelSlots)
  {
    this.maxKennelSlots = maxKennelSlots;
  }

  public void setReservedSlots(int reservedSlots)
  {
    this.reservedSlots = reservedSlots;
  }

  public void setBookingPrice(double bookingPrice)
  {
    this.bookingPrice = bookingPrice;
  }

  public int getMaxKennelSlots()
  {
    return maxKennelSlots;
  }

  public int getReservedSlots()
  {
    return reservedSlots;
  }

  public double getBookingPrice()
  {
    return bookingPrice;
  }

  public int checkAvailability()
  {
    //For later
    return 0;
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

  public String toString()
  {
    return "VIAPets{" + "maxKennelSlots=" + maxKennelSlots + ", reservedSlots="
        + reservedSlots + ", bookingPrice=" + bookingPrice + ", allBookings="
        + allBookings + ", allCustomers=" + allCustomers + ", allSales="
        + allSales + ", allPets=" + allPets + '}';
  }
}
