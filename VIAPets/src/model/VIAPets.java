package model;

import utils.XMLHandler;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The VIAPets class represents the main system for managing bookings, customers, sales, and pets in the VIAPets system.
 * It includes functionality for setting and retrieving kennel slot information, managing bookings, customers, sales, and pets.
 * This class provides methods to update system-wide settings.
 *
 * @author Piotr Junosz
 * @version 1.0
 */
public class VIAPets implements Serializable {
  public static int maxKennelSlots;  // Maximum number of kennel slots available
  public static int availableSlotsToday;  // Available slots for today's date
  public static double bookingPrice;  // Price for booking a pet
  private BookingList allBookings;  // List of all bookings in the system
  private CustomerList allCustomers;  // List of all customers in the system
  private SaleList allSales;  // List of all sales in the system
  public static PetList allPets;  // List of all pets in the system

  // Static variables to maintain the last ID used for customers, pets, bookings, and sales
  public static String lastCustomerID;
  public static String lastPetID;
  public static String lastBookingID;
  public static String lastSaleID;


  /**
   * Sets the maximum number of kennel slots available.
   *
   * @param maxKennelSlots the maximum number of kennel slots to set
   */
  public void setMaxKennelSlots(int maxKennelSlots) {
    this.maxKennelSlots = maxKennelSlots;
  }

  /**
   * Updates the available slots for today's date based on the current bookings.
   *
   * @param date the current date to check for available slots
   */
  public void checkAvailableSlots(Date date) {
    int count = 0;
    for (Booking booking : allBookings.getBookings()) {
      if (!date.isGreaterThan(booking.getDateInterval().getEndDate())
          && !booking.getDateInterval().getStartDate().isGreaterThan(date)) {
        count++;
      }
    }
    availableSlotsToday = maxKennelSlots - count;
  }

  /**
   * Sets the booking price.
   *
   * @param bookingPrice the price to set for booking a pet
   */
  public void setBookingPrice(double bookingPrice) {
    this.bookingPrice = bookingPrice;
  }

  /**
   * Sets the last customer ID used in the system.
   *
   * @param lastCustomerID the last customer ID to set
   */
  public void setLastCustomerID(String lastCustomerID) {
    this.lastCustomerID = lastCustomerID;
  }

  /**
   * Sets the last pet ID used in the system.
   *
   * @param lastPetID the last pet ID to set
   */
  public void setLastPetID(String lastPetID) {
    this.lastPetID = lastPetID;
  }

  /**
   * Sets the last booking ID used in the system.
   *
   * @param lastBookingID the last booking ID to set
   */
  public void setLastBookingID(String lastBookingID) {
    this.lastBookingID = lastBookingID;
  }

  /**
   * Sets the last sale ID used in the system.
   *
   * @param lastSaleID the last sale ID to set
   */
  public void setLastSaleID(String lastSaleID) {
    this.lastSaleID = lastSaleID;
  }

  /**
   * Sets the list of all bookings in the system.
   *
   * @param allBookings the BookingList object representing all bookings
   */
  public void setAllBookings(BookingList allBookings) {
    this.allBookings = allBookings;
  }

  /**
   * Sets the list of all customers in the system.
   *
   * @param allCustomers the CustomerList object representing all customers
   */
  public void setAllCustomers(CustomerList allCustomers) {
    this.allCustomers = allCustomers;
  }

  /**
   * Sets the list of all sales in the system.
   *
   * @param allSales the SaleList object representing all sales
   */
  public void setAllSales(SaleList allSales) {
    this.allSales = allSales;
  }

  /**
   * Sets the list of all pets in the system.
   *
   * @param allPets the PetList object representing all pets
   */
  public void setAllPets(PetList allPets) {
    this.allPets = allPets;
  }

  /**
   * Gets the maximum number of kennel slots available.
   *
   * @return the maximum number of kennel slots
   */
  public int getMaxKennelSlots() {
    return maxKennelSlots;
  }

  /**
   * Gets the available slots for today's date.
   *
   * @return the number of available slots for today's date
   */
  public int getAvailableSlots() {
    return availableSlotsToday;
  }

  /**
   * Gets the booking price.
   *
   * @return the price for booking a pet
   */
  public double getBookingPrice() {
    return bookingPrice;
  }

  /**
   * Gets the list of all bookings in the system.
   *
   * @return the BookingList object representing all bookings
   */
  public BookingList getAllBookings() {
    return allBookings;
  }

  /**
   * Gets the list of all customers in the system.
   *
   * @return the CustomerList object representing all customers
   */
  public CustomerList getAllCustomers() {
    return allCustomers;
  }

  /**
   * Gets the list of all sales in the system.
   *
   * @return the SaleList object representing all sales
   */
  public SaleList getAllSales() {
    return allSales;
  }

  /**
   * Gets the list of all pets in the system.
   *
   * @return the PetList object representing all pets
   */
  public PetList getAllPets() {
    return allPets;
  }

  /**
   * Gets the current date and time.
   *
   * @return a Date object representing the current date
   */
  public static Date getCurrentDate() {
    LocalDateTime now = LocalDateTime.now();
    return new Date(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
  }

  /**
   * Provides a string representation of the VIAPets system
   *
   * @return a string representation of the VIAPets system
   */
  public String toString() {
    return "VIAPets{" + "maxKennelSlots=" + maxKennelSlots + ", availableSlots="
        + availableSlotsToday + ", bookingPrice=" + bookingPrice + ", allBookings="
        + allBookings + ", allCustomers=" + allCustomers + ", allSales="
        + allSales + ", allPets=" + allPets + '}';
  }
}
