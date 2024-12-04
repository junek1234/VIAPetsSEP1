package model;

public class Booking {
  private int bookingID;
  private Pet pet;
  private Customer customer;
  private DateInterval dateInterval;

  public Booking(int bookingID, Pet pet, Customer customer, DateInterval dateInterval) {
    this.bookingID = bookingID;
    this.pet = pet;
    this.customer = customer;
    this.dateInterval = dateInterval;
  }

  public void setBookingID(int bookingID)
  {
    this.bookingID = bookingID;
  }

  public int getBookingID() {
    return bookingID;
  }

  public Pet getPet() {
    return pet;
  }

  public Customer getCustomer() {
    return customer;
  }

  public DateInterval getDateInterval() {
    return dateInterval;
  }

  public String toString() {
    return "Booking [" + "bookingID: " + bookingID + ", pet: " + pet + ", customer: " + customer + ", dateInterval: " + dateInterval + ']';
  }

  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Booking booking = (Booking) obj;
    return bookingID == booking.bookingID;
  }
}
