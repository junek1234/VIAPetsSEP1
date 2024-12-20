package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Booking class represents a booking made by a customer for a pet, which includes the booking ID,
 * the pet being booked, the customer who made the booking, and the date interval for the booking period.
 * This class implements the Serializable interface for object serialization.
 *
 * @author Felipe Figueiredo
 * @version 1.0
 */
public class Booking implements Serializable {
  private int bookingID;
  private Pet pet;
  private Customer customer;
  private DateInterval dateInterval;

  /**
   * Constructs a Booking object with the specified booking ID, pet, customer, and date interval.
   *
   * @param bookingID the unique ID of the booking
   * @param pet the pet being booked
   * @param customer the customer making the booking
   * @param dateInterval the date interval for the booking period
   */
  public Booking(int bookingID, Pet pet, Customer customer, DateInterval dateInterval) {
    this.bookingID = bookingID;
    this.pet = pet;
    this.customer = customer;
    this.dateInterval = dateInterval;
  }

  /**
   * Sets the booking ID for the booking.
   *
   * @param bookingID the new booking ID
   */
  public void setBookingID(int bookingID) {
    this.bookingID = bookingID;
  }

  /**
   * Gets the booking ID for the booking.
   *
   * @return the booking ID
   */
  public int getBookingID() {
    return bookingID;
  }

  /**
   * Gets the pet associated with the booking.
   *
   * @return the pet being booked
   */
  public Pet getPet() {
    return pet;
  }

  /**
   * Sets the pet for the booking.
   *
   * @param pet the pet to set for the sale
   */
  public void setPet(Pet pet) {
    this.pet = pet;
  }

  /**
   * Gets the customer who made the booking.
   *
   * @return the customer of the booking
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * Gets the date interval for the booking period.
   *
   * @return the date interval of the booking
   */
  public DateInterval getDateInterval() {
    return dateInterval;
  }

  /**
   * Returns a string representation of the Booking object in the format:
   *
   * @return a string representation of the Booking object
   */
  public String toString() {
    return "Booking [" + "bookingID: " + bookingID + ", pet: " + pet + ", customer: " + customer + ", dateInterval: " + dateInterval + ']';
  }

  /**
   * Compares this Booking object to another object for equality.
   *
   * @param obj the object to compare this Booking to
   * @return true if the given object is equal to this Booking, false otherwise
   */
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Booking booking = (Booking) obj;
    return bookingID == booking.bookingID;
  }

  /**
   * Sets the pet ID for the pet associated with the booking.
   *
   * @param newPetID the new pet ID to set
   */
  public void setPetID(int newPetID) {
    this.pet.setPetID(newPetID);
  }

  /**
   * Sets the customer ID for the customer associated with the booking.
   *
   * @param newCustomerID the new customer ID to set
   */
  public void setCustomerID(int newCustomerID) {
    this.customer.setCustomerID(newCustomerID);
  }

  /**
   * Sets the start date for the booking by modifying the start date of the date interval.
   *
   * @param newStartDate the new start date for the booking
   */
  public void setStartDate(Date newStartDate) {
    this.dateInterval.setStartDate(newStartDate);
  }

  /**
   * Sets the end date for the booking by modifying the end date of the date interval.
   *
   * @param newEndDate the new end date for the booking
   */
  public void setEndDate(Date newEndDate) {
    this.dateInterval.setEndDate(newEndDate);
  }

  /**
   * Gets the start date for the booking by retrieving the start date of the date interval.
   *
   * @return the start date for the booking
   */
  public Date getStartDate() {
    return this.dateInterval.getStartDate();
  }

  /**
   * Gets the end date for the booking by retrieving the end date of the date interval.
   *
   * @return the end date for the booking
   */
  public Date getEndDate() {
    return this.dateInterval.getEndDate();
  }
}
