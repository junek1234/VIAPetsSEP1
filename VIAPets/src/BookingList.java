import java.util.ArrayList;
import model.*;

  public class BookingList
  {
    private ArrayList<BookingList> bookings;

    public BookingList()
    {
      bookings = new ArrayList<>();
    }
    public void add(Booking booking)
    {
      bookings.add(booking);
    }
    //  public void edit(Pet pet) ???

    public void remove(Pet pet)
    {
      bookings.remove(booking);
    }
    public Pet getBookingByID(int BookingID) //change and think about this in Astah
    {
      for (int i = 0; i < bookings.size(); i++)
      {
        if (bookings.get(i).bookingID==bookingID)
        {
          return bookings.get(i);
        }

      }
      return null;
    }
    //  public void setPet() == edit ???

    public String toString()
    {
      return "PetList{" + "bookings=" + bookings.toString() + '}';
    }
  }

  public void editBooking(int bookingID) {
    for (int i = 0; i < bookings.size(); i++) {
      Booking booking = bookings.get(i);
      if (booking.getBookingID() == bookingID) {
        // Booking found, modify it
        System.out.println("Booking found. Editing details...");

        // Example updates
        Customer newCustomer = new Customer("Updated Name");
        Pet newPet = new Pet("Updated Pet Name");
        booking.setCustomer(newCustomer);
        booking.setPet(newPet);
        System.out.println("Booking updated successfully.");
        return; // Exit the method after updating
      }
    }

