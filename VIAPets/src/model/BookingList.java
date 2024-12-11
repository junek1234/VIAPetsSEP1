package model;

import java.io.Serializable;
import java.util.ArrayList;

public class BookingList implements Serializable
{
    private ArrayList<Booking> bookings;

    // Constructor
    public BookingList() {
        bookings = new ArrayList<>();
    }
    //change in Astah
    public BookingList(ArrayList<Booking> bookings)
    {
        this.bookings = bookings;
    }

    // Add a new booking
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    // Edit an existing booking (replacing old booking object with a new one changed in the Controller)
    public void editBooking(int bookingID, Booking newBooking)
    {
        int index = bookings.indexOf(getBookingByID(bookingID));
        bookings.set(index,newBooking);
    }

    // Remove a booking by ID
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    // Get a booking by ID
    public Booking getBookingByID(int bookingID) {
        for (Booking booking : bookings) {
            if (booking.getBookingID() == bookingID) {
                return booking;
            }
        }
        return null;
    }

    //get bookings
    //change in Astah
    public ArrayList<Booking> getBookings()
    {
        return bookings;
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
