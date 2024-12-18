package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The BookingList class represents a collection of bookings. It provides methods to retrieve,
 * add, edit, and remove Booking objects from the list.
 * This class implements the Serializable interface for object serialization.
 *
 * @author Cristina Aurelia Matei
 * @version 1.0
 */
public class BookingList implements Serializable {
    private ArrayList<Booking> bookings;

    /**
     * Constructs an empty BookingList object.
     * Initializes an empty ArrayList to store Booking objects.
     */
    public BookingList() {
        bookings = new ArrayList<>();
    }

    /**
     * Constructs a BookingList object with a given list of Booking objects.
     *
     * @param bookings the list of Bookings to initialize the BookingList with
     */
    public BookingList(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * Adds a new Booking to the BookingList.
     *
     * @param booking the Booking object to add to the list
     */
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    /**
     * Edits an existing Booking in the BookingList by replacing it with a new Booking object.
     *
     * @param bookingID the ID of the Booking to edit
     * @param newBooking the new Booking object to replace the old one
     */
    public void editBooking(int bookingID, Booking newBooking) {
        int index = bookings.indexOf(getBookingByID(bookingID));
        if (index != -1) {
            bookings.set(index, newBooking);
        }
    }

    /**
     * Removes a Booking from the BookingList.
     *
     * @param booking the Booking object to remove
     */
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    /**
     * Gets a Booking by its unique booking ID.
     *
     * @param bookingID the unique ID of the booking
     * @return the Booking object with the matching bookingID, or null if no booking with the given ID is found
     */
    public Booking getBookingByID(int bookingID) {
        for (Booking booking : bookings) {
            if (booking.getBookingID() == bookingID) {
                return booking;
            }
        }
        return null;
    }

    /**
     * Gets the list of all bookings in the BookingList.
     *
     * @return the list of Booking objects in the BookingList
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * Returns a string representation of all Bookings in the BookingList.
     *
     * @return a string representation of all Booking objects in the BookingList
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Booking booking : bookings) {
            sb.append(booking.toString()).append("\n");
        }
        return sb.toString();
    }
}
