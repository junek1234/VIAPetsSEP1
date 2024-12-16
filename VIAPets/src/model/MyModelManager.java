package model;

import utils.MyFileHandler;
import utils.XMLHandler;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class MyModelManager implements Serializable
{
    //needs to be changed in Astah
    private static final String PET_FILE = "pets.bin";
    private static final String BOOKING_FILE = "bookings.bin";
    private static final String CUSTOMER_FILE = "customers.bin";
    private static final String SALE_FILE = "sales.bin";
    private static final String LAST_IDS = "last_ids.txt";
    private static final String BOOKINGS_SETTINGS = "settings.txt";

    VIAPets viaPets = new VIAPets();
    //needs to be changed in Astah

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
        viaPets.setAvailableSlots(VIAPets.getCurrentDate());
        XMLHandler.updateXML();
    }

    //    private String[] loadArrayFromXMLFile(String fileName)
    //    {
    //        try{
    //            String[] array = MyFileHandler.readArrayFromTextFile(fileName);
    //            return array;
    //        }
    //        catch (FileNotFoundException e)
    //        {
    //          e.printStackTrace();
    //        }
    //        String[] array = {"<?xml version=\"1.0\" encoding=\"UTF-8\"?>","<pets>","</pets>"};
    //        return array;
    //    }

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

    public PetList getAllPets() {
        return viaPets.getAllPets();
    }
    public BookingList getAllBookings() {
        return viaPets.getAllBookings();
    }
    public CustomerList getAllCustomers() {
        return viaPets.getAllCustomers();
    }
    public SaleList getAllSales() {
        return viaPets.getAllSales();
    }

    public static int createNextCustomerID()
    {
        int id=Integer.parseInt(VIAPets.lastCustomerID)+1;
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

    public static int createNextPetID()
    {
        int id=Integer.parseInt(VIAPets.lastPetID)+1;
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
    public static int createNextBookingID()
    {
        int id=Integer.parseInt(VIAPets.lastBookingID)+1;
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


    public void addPet(Pet pet) throws IOException
    {
        viaPets.getAllPets().addPet(pet);
        MyFileHandler.writeArrayToBinaryFile(PET_FILE, viaPets.getAllPets().getPets().toArray(new Pet[0]));

    }

    public void deletePet(int petID) throws IOException
    {
        viaPets.getAllPets().removePet(getAllPets().getPetByID(petID));
        MyFileHandler.writeArrayToBinaryFile(PET_FILE, viaPets.getAllPets().getPets().toArray(new Pet[0]));
    }

    public void editPet(int petID, Pet newPet) throws IOException
    {
        viaPets.getAllPets().editPet(petID, newPet);
        MyFileHandler.writeArrayToBinaryFile(PET_FILE, viaPets.getAllPets().getPets().toArray(new Pet[0]));
    }


    public void addBooking(Booking booking) throws IOException
    {
        viaPets.getAllBookings().addBooking(booking);
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, viaPets.getAllBookings().getBookings().toArray(new Booking[0]));
    }

    public void deleteBooking(int bookingID) throws IOException
    {
        viaPets.getAllBookings().removeBooking(getAllBookings().getBookingByID(bookingID));
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, viaPets.getAllBookings().getBookings().toArray(new Booking[0]));
    }

    public void editBooking(int bookingID, Booking newBooking)
        throws IOException
    {
        viaPets.getAllBookings().editBooking(bookingID, newBooking);
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, viaPets.getAllBookings().getBookings().toArray(new Booking[0]));
    }

    public void addCustomer(Customer customer) throws IOException
    {
        viaPets.getAllCustomers().addCustomer(customer);
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, viaPets.getAllCustomers().getCustomers().toArray(new Customer[0]));
    }

    public void deleteCustomer(int customerID) throws IOException
    {
        viaPets.getAllCustomers().removeCustomer(getAllCustomers().getCustomer(customerID));
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, viaPets.getAllCustomers().getCustomers().toArray(new Customer[0]));
    }

    public void editCustomer(int customerID, Customer newCustomer)
        throws IOException
    {
        viaPets.getAllCustomers().editCustomer(customerID, newCustomer);
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, viaPets.getAllCustomers().getCustomers().toArray(new Customer[0]));
    }


    public void addSale(Sale sale) throws IOException
    {
        viaPets.getAllSales().addSale(sale);
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, viaPets.getAllSales().getSaleList().toArray(new Sale[0]));
    }

    public void deleteSale(int saleID) throws IOException
    {
        viaPets.getAllSales().removeSale(getAllSales().getSaleByID(saleID));
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, viaPets.getAllSales().getSaleList().toArray(new Sale[0]));
    }

    public void editSale(int saleID, Sale newSale) throws IOException
    {
        viaPets.getAllSales().editSale(saleID, newSale);
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, viaPets.getAllSales().getSaleList().toArray(new Sale[0]));
    }

    public void saveBookingsSettings(int maxKennelSlots, double bookingPrice)
    {
        VIAPets.maxKennelSlots=maxKennelSlots;
        VIAPets.bookingPrice=bookingPrice;
        try
        {
            MyFileHandler.writeToTextFile(BOOKINGS_SETTINGS,VIAPets.maxKennelSlots+"");
            MyFileHandler.appendToTextFile(BOOKINGS_SETTINGS,VIAPets.bookingPrice+"");
            viaPets.setAvailableSlots(VIAPets.getCurrentDate());
            XMLHandler.updateXML();
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }
    public void loadBookingsSettings() {
        try {
            String[] settings = MyFileHandler.readArrayFromTextFile(BOOKINGS_SETTINGS);
            VIAPets.maxKennelSlots = Integer.parseInt(settings[0]);
            VIAPets.bookingPrice = Double.parseDouble(settings[1]);
        } catch (FileNotFoundException e) {
            saveBookingsSettings(10, (20.0));
        }
    }

    public boolean isThisPeriodAvailable(DateInterval dateInterval)
    {
        LocalDate startDate = dateInterval.getStartDate().toLocalDate(); // 1 + 1
        LocalDate endDate = dateInterval.getEndDate().toLocalDate();
        Date now;
        while(startDate.isBefore(endDate) || startDate.isEqual(endDate))
        {
            now= new Date(startDate.getDayOfMonth(), startDate.getMonthValue(), startDate.getYear());
            viaPets.setAvailableSlots(now);
            if(VIAPets.availableSlotsToday==0)
            {
                return false;
            }
            startDate=startDate.plusDays(1);
        }
        return true;
    }


}