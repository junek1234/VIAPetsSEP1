package model;

import utils.MyFileHandler;
import utils.XMLHandler;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Manages the core functionality of the VIAPets application,
 * including operations for pets, bookings, customers, and sales,
 * as well as ID generation and settings management.
 * It is a connector between VIAPets class, MyFileHandler, and also XMLHandler
 *
 * @author Piotr Junosz
 * @version 1.0
 */
public class MyModelManager implements Serializable
{

    private static final String PET_FILE = "pets.bin";
    private static final String BOOKING_FILE = "bookings.bin";
    private static final String CUSTOMER_FILE = "customers.bin";
    private static final String SALE_FILE = "sales.bin";
    private static final String LAST_IDS = "last_ids.txt";
    private static final String BOOKINGS_SETTINGS = "settings.txt";

    VIAPets viaPets = new VIAPets();


    /**
     * Initializes the model manager by loading data from various files into the system.
     * The constructor handles loading the lists of pets, bookings, customers, and sales
     * from their respective binary files and casts the objects to their specific types.
     * It also loads the last used IDs for each entity and sets the booking settings and
     * available slots based on the current date.
     */
    public MyModelManager()
    {
        //loading lists of object from files and casting them
        ArrayList<Pet> pets=new ArrayList<>();
        ArrayList<Booking> bookings=new ArrayList<>();
        ArrayList<Customer> customers=new ArrayList<>();
        ArrayList<Sale> sales=new ArrayList<>();




        ArrayList<Object> objects = loadArrayListFromFile(PET_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            pets.add((Pet)objects.get(i));
        }
        viaPets.setAllPets(new PetList(pets));

        objects = loadArrayListFromFile(BOOKING_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            bookings.add((Booking)objects.get(i));
        }
        viaPets.setAllBookings(new BookingList(bookings));
        objects = loadArrayListFromFile(CUSTOMER_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            customers.add((Customer) objects.get(i));
        }
        viaPets.setAllCustomers(new CustomerList(customers));

        objects = loadArrayListFromFile(SALE_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            sales.add((Sale) objects.get(i));
        }
        viaPets.setAllSales(new SaleList(sales));
        //Loading last ID from file
        String[] lastIDs = loadLastIDs(LAST_IDS);
        //CUSTOMER ID LINE 1 - index is 0
        viaPets.setLastCustomerID(lastIDs[0]);
        //PET ID LINE 2 - index is 1
        viaPets.setLastPetID(lastIDs[1]);
        //BOOKING ID LINE 3 - index is 2
        viaPets.setLastBookingID(lastIDs[2]);
        //SALE ID LINE 4 - index is 3
        viaPets.setLastSaleID(lastIDs[3]);


        loadBookingsSettings();
        viaPets.checkAvailableSlots(VIAPets.getCurrentDate());
        XMLHandler.updateXML();
    }

    /**
     * Loads an ArrayList of objects from a binary file using MyFileHandler.
     *
     * @param fileName the name of the file to load data from
     * @return an ArrayList of objects read from the file
     */
    private ArrayList<Object> loadArrayListFromFile(String fileName) {
        try {
            Object[] array = MyFileHandler.readArrayFromBinaryFile(fileName);
            ArrayList<Object> arrayList = new ArrayList<>();
            for (int i = 0; i < array.length; i++)
            {
                arrayList.add(array[i]);
            }
            return arrayList;
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading file " + fileName + ": " + e.getMessage());
        }
        return new ArrayList<>();
    }
    /**
     * Loads the last IDs from a text file.
     *
     * @param fileName the name of the file to load IDs from
     * @return an array of last IDs
     */
    private String[] loadLastIDs(String fileName)
    {
        try
        {
            String[] array = MyFileHandler.readArrayFromTextFile(fileName);
            return array;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String[] array = {"0","0","0","0"};
        return array;
    }

    /**
     * Retrieves all pets.
     *
     * @return a PetList containing all pets
     */
    public PetList getAllPets() {
        return viaPets.getAllPets();
    }
    /**
     * Retrieves all bookings.
     *
     * @return a BookingList containing all bookings
     */
    public BookingList getAllBookings() {
        return viaPets.getAllBookings();
    }
    /**
     * Retrieves all customers.
     *
     * @return a CustomerList containing all customers
     */
    public CustomerList getAllCustomers() {
        return viaPets.getAllCustomers();
    }
    /**
     * Retrieves all sales.
     *
     * @return a SaleList containing all sales
     */
    public SaleList getAllSales() {
        return viaPets.getAllSales();
    }
    /**
     * Creates the next customer ID and updates the last ID file.
     *
     * @return the next customer ID
     * @throws RuntimeException if FileNotFoundException is caught
     */
    public static int createNextCustomerID()
    {
        int id = Integer.parseInt(VIAPets.lastCustomerID)+1;
        VIAPets.lastCustomerID=id+"";
        try
        {
            String[] newLastIDS = {id+"",VIAPets.lastPetID, VIAPets.lastBookingID, VIAPets.lastSaleID};
            MyFileHandler.writeArrayToTextFile(LAST_IDS,newLastIDS);
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return id;
    }
    /**
     * Creates the next pet ID and updates the last ID file.
     *
     * @return the next pet ID
     * @throws RuntimeException if FileNotFoundException is caught
     */
    public static int createNextPetID()
    {
        int id = Integer.parseInt(VIAPets.lastPetID)+1;
        VIAPets.lastPetID=id+"";
        try
        {
            String[] newLastIDS = {VIAPets.lastCustomerID,id+"", VIAPets.lastBookingID, VIAPets.lastSaleID};
            MyFileHandler.writeArrayToTextFile(LAST_IDS,newLastIDS);
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return id;
    }
    /**
     * Creates the next booking ID and updates the last ID file.
     *
     * @return the next booking ID
     * @throws RuntimeException if FileNotFoundException is caught
     */
    public static int createNextBookingID()
    {
        int id = Integer.parseInt(VIAPets.lastBookingID)+1;
        VIAPets.lastBookingID=id+"";
        try
        {
            String[] newLastIDS = {VIAPets.lastCustomerID,VIAPets.lastPetID, id+"", VIAPets.lastSaleID};
            MyFileHandler.writeArrayToTextFile(LAST_IDS,newLastIDS);
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return id;
    }

    /**
     * Creates the next sale ID and updates the last ID file.
     *
     * @return the next sale ID
     * @throws RuntimeException if FileNotFoundException is caught
     */
    public static int createNextSaleID()
    {
        int id=Integer.parseInt(VIAPets.lastSaleID)+1;
        VIAPets.lastSaleID=id+"";
        try
        {
            String[] newLastIDS = {VIAPets.lastCustomerID,VIAPets.lastPetID,VIAPets.lastBookingID, id+""};
            MyFileHandler.writeArrayToTextFile(LAST_IDS,newLastIDS);
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return id;
    }


    /**
     * Adds a pet to the system.
     *
     * @param pet the pet to be added
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void addPet(Pet pet) throws IOException
    {
        viaPets.getAllPets().addPet(pet);
        MyFileHandler.writeArrayToBinaryFile(PET_FILE, viaPets.getAllPets().getPets().toArray(new Pet[0]));

    }
    /**
     * Deletes a pet by its ID.
     *
     * @param petID the ID of the pet to be deleted
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void deletePet(int petID) throws IOException
    {
        viaPets.getAllPets().removePet(getAllPets().getPetByID(petID));
        MyFileHandler.writeArrayToBinaryFile(PET_FILE, viaPets.getAllPets().getPets().toArray(new Pet[0]));
    }

    /**
     * Edits the details of an existing pet.
     *
     * @param petID the unique ID of the pet to be edited.
     * @param newPet the new Pet object containing updated details.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void editPet(int petID, Pet newPet) throws IOException
    {
        viaPets.getAllPets().editPet(petID, newPet);
        MyFileHandler.writeArrayToBinaryFile(PET_FILE, viaPets.getAllPets().getPets().toArray(new Pet[0]));
    }

    /**
     * Adds a new booking to the system.
     *
     * @param booking the Booking object to be added.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void addBooking(Booking booking) throws IOException
    {
        viaPets.getAllBookings().addBooking(booking);
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, viaPets.getAllBookings().getBookings().toArray(new Booking[0]));
    }

    /**
     * Deletes a booking from the system.
     *
     * @param bookingID the unique ID of the booking to be deleted.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void deleteBooking(int bookingID) throws IOException
    {
        viaPets.getAllBookings().removeBooking(getAllBookings().getBookingByID(bookingID));
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, viaPets.getAllBookings().getBookings().toArray(new Booking[0]));
    }

    /**
     * Edits the details of an existing booking.
     *
     * @param bookingID the unique ID of the booking to be edited.
     * @param newBooking the new Booking object containing updated details.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void editBooking(int bookingID, Booking newBooking)
        throws IOException
    {
        viaPets.getAllBookings().editBooking(bookingID, newBooking);
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, viaPets.getAllBookings().getBookings().toArray(new Booking[0]));
    }

    /**
     * Adds a new customer to the system.
     *
     * @param customer the Customer object to be added.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void addCustomer(Customer customer) throws IOException
    {
        viaPets.getAllCustomers().addCustomer(customer);
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, viaPets.getAllCustomers().getCustomers().toArray(new Customer[0]));
    }

    /**
     * Deletes a customer from the system.
     *
     * @param customerID the unique ID of the customer to be deleted.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void deleteCustomer(int customerID) throws IOException
    {
        viaPets.getAllCustomers().removeCustomer(getAllCustomers().getCustomer(customerID));
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, viaPets.getAllCustomers().getCustomers().toArray(new Customer[0]));
    }

    /**
     * Edits the details of an existing customer.
     *
     * @param customerID the unique ID of the customer to be edited.
     * @param newCustomer the new Customer object containing updated details.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void editCustomer(int customerID, Customer newCustomer)
        throws IOException
    {
        viaPets.getAllCustomers().editCustomer(customerID, newCustomer);
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, viaPets.getAllCustomers().getCustomers().toArray(new Customer[0]));
    }

    /**
     * Adds a new sale to the system.
     *
     * @param sale the Sale object to be added.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void addSale(Sale sale) throws IOException
    {
        viaPets.getAllSales().addSale(sale);
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, viaPets.getAllSales().getSaleList().toArray(new Sale[0]));
    }

    /**
     * Deletes a sale from the system.
     *
     * @param saleID the unique ID of the sale to be deleted.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void deleteSale(int saleID) throws IOException
    {
        viaPets.getAllSales().removeSale(getAllSales().getSaleByID(saleID));
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, viaPets.getAllSales().getSaleList().toArray(new Sale[0]));
    }

    /**
     * Edits the details of an existing sale.
     *
     * @param saleID the unique ID of the sale to be edited.
     * @param newSale the new Sale object containing updated details.
     * @throws IOException if an IOException occurs while saving the changes.
     */
    public void editSale(int saleID, Sale newSale) throws IOException
    {
        viaPets.getAllSales().editSale(saleID, newSale);
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, viaPets.getAllSales().getSaleList().toArray(new Sale[0]));
    }

    /**
     * Saves the booking settings, including maximum kennel slots and booking price.
     *
     * @param maxKennelSlots the maximum number of kennel slots available.
     * @param bookingPrice the price per booking.
     * @throws RuntimeException if the settings file cannot be written.
     */
    public void saveBookingsSettings(int maxKennelSlots, double bookingPrice)
    {
        VIAPets.maxKennelSlots=maxKennelSlots;
        VIAPets.bookingPrice=bookingPrice;
        try
        {
            MyFileHandler.writeToTextFile(BOOKINGS_SETTINGS,VIAPets.maxKennelSlots+"");
            MyFileHandler.appendToTextFile(BOOKINGS_SETTINGS,VIAPets.bookingPrice+"");
            viaPets.checkAvailableSlots(VIAPets.getCurrentDate());
            XMLHandler.updateXML();
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the booking settings from the settings file.
     * If the file is not found, default settings are saved.
     *
     * @throws RuntimeException if the settings file cannot be read.
     */
    public void loadBookingsSettings() {
        try {
            String[] settings = MyFileHandler.readArrayFromTextFile(BOOKINGS_SETTINGS);
            VIAPets.maxKennelSlots = Integer.parseInt(settings[0]);
            VIAPets.bookingPrice = Double.parseDouble(settings[1]);
        } catch (FileNotFoundException e) {
            saveBookingsSettings(10, (20.0));
        }
    }

    /**
     * Checks if a specific period is available for booking.
     *
     * @param dateInterval the date range to check for availability
     * @return true if the period is available, false otherwise
     */
    public boolean isThisPeriodAvailable(DateInterval dateInterval)
    {
        LocalDate startDate = dateInterval.getStartDate().toLocalDate(); // Assignment, get and local date. This takes 3.
        LocalDate endDate = dateInterval.getEndDate().toLocalDate(); // Assignment, get and local date. This takes 3.
        Date now; //Declaration. This takes 1.
        while(startDate.isBefore(endDate) || startDate.isEqual(endDate)) // Go through al the date interval. This takes n.
        {
            now= new Date(startDate.getDayOfMonth(), startDate.getMonthValue(), startDate.getYear()); // Assign a value to now, one "=" and 3 getters. This takes 4.
            viaPets.checkAvailableSlots(now); //call method to check if the date has available slots that day. This takes n
            if(VIAPets.availableSlotsToday==0) //Check if any of the days does not have free slots.
            {
                return false; // 1 return.
            }
            //Add one day to the start day to check its availability.
            startDate=startDate.plusDays(1);  // Assignment and plusDays. This takes 2.
        }
        return true; // 1 return

        // We have no recursion so we do not need a base case.
//        We loop through all days of the date interval and for each day we loop through all bookings to check thair availability.
//        T(n) = 13 + n^2. So ignoring constants we get T(n) = O(n^2).
//        We chose this method because is the one that has the biggest big O in all our code.
//
//        Dominating Term Analysis
//        T(n) = 13 + n^2
//        - Dominating Term: n^2.
//        - Explanation: This method will run n^2 since for each date in the date interval it is going to check in all bookings
//        if there is any available slot.
//
//        Optimisation Suggestion
//        - By creating another list for previous bookings and just looping through the current and future bookings we could reduce
//          the times of iterations done by the loop since there will be fewer bookings to loop through.
    }


}