package model;

import java.util.ArrayList;

public class BookingList
{
    private ArrayList<Booking> bookings;

    // Constructor
    public BookingList() {
        bookings = new ArrayList<>();
    }

    // Add a new booking
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    // Edit an existing booking
    public void editBooking(Booking booking, int bookingID, int newPetID, int newCustomerID, String newStartDate, String newEndDate, String newStatus)
    {
        booking.setBookingID(bookingID);
        booking.setPetID(newPetID);
        booking.setCustomerID(newCustomerID);
        booking.setStartDate(newStartDate);
        booking.setEndDate(newEndDate);
        booking.setStatus(newStatus);
    }

    // Remove a booking by ID
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    // Get a booking by ID
    public Booking getBooking(int bookingID) {
        for (Booking booking : bookings) {
            if (booking.getBookingID() == bookingID) {
                return booking;
            }
        }
        return null;
    }

    // to display the list of bookings
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Booking booking : bookings) {
            sb.append(booking.toString()).append("\n");
        }
        return sb.toString();
    }
}
