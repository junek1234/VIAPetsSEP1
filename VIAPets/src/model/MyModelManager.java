package model;

import utils.MyFileHandler;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;

public class MyModelManager implements Serializable
{
    //needs to be changed in Astah
    private static final String PET_FILE = "pets.bin";
    private static final String BOOKING_FILE = "bookings.bin";
    private static final String CUSTOMER_FILE = "customers.bin";
    private static final String SALE_FILE = "sales.bin";
    private static final String LAST_IDS = "last_ids.txt";
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
        VIAPets.allPets = new PetList(pets);
        System.out.println();

        objects = loadArrayListFromFile(BOOKING_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            bookings.add((Booking)objects.get(i));
        }
        VIAPets.allBookings = new BookingList(bookings);

        objects = loadArrayListFromFile(CUSTOMER_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            customers.add((Customer) objects.get(i));
        }
        VIAPets.allCustomers = new CustomerList(customers);

        objects = loadArrayListFromFile(SALE_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            sales.add((Sale) objects.get(i));
        }
        VIAPets.allSales = new SaleList(sales);
        //Loading last ID from file
        String[] lastIDs = loadLastIDs(LAST_IDS);
        //CUSTOMER ID LINE 1 - index is 0
        VIAPets.lastCustomerID=lastIDs[0];
        //PET ID LINE 2 - index is 1
        VIAPets.lastPetID=lastIDs[1];
        //BOOKING ID LINE 3 - index is 2
        VIAPets.lastBookingID=lastIDs[2];
        //SALE ID LINE 4 - index is 3
        VIAPets.lastSaleID=lastIDs[3];
    }

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
            System.err.println("File not found: " + fileName + ", initializing empty list.");
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
        return VIAPets.allPets;
    }
    public BookingList getAllBookings() {
        return VIAPets.allBookings;
    }
    public CustomerList getAllCustomers() {
        return VIAPets.allCustomers;
    }
    public SaleList getAllSales() {
        return VIAPets.allSales;
    }

    public static int createNextCustomerID()
    {
        int id=Integer.parseInt(VIAPets.lastCustomerID)+1;
        try
        {
            String[] newLastIDS = {id+"",VIAPets.lastPetID, VIAPets.lastBookingID, VIAPets.lastSaleID};
            VIAPets.lastCustomerID=id+"";
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
        try
        {
            String[] newLastIDS = {VIAPets.lastCustomerID,id+"", VIAPets.lastBookingID, VIAPets.lastSaleID};
            VIAPets.lastPetID=id+"";
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
        try
        {
        String[] newLastIDS = {VIAPets.lastCustomerID,VIAPets.lastPetID, id+"", VIAPets.lastSaleID};
            VIAPets.lastBookingID=id+"";
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
        try
        {
            String[] newLastIDS = {VIAPets.lastCustomerID,VIAPets.lastPetID,VIAPets.lastBookingID, id+""};
            VIAPets.lastSaleID=id+"";
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
        VIAPets.allPets.addPet(pet);

        MyFileHandler.writeArrayToBinaryFile(PET_FILE, VIAPets.allPets.getPets().toArray(new Pet[0]));
    }

    public void deletePet(int petID) throws IOException
    {
        VIAPets.allPets.removePet(getAllPets().getPetByID(petID));
        MyFileHandler.writeArrayToBinaryFile(PET_FILE, VIAPets.allPets.getPets().toArray(new Pet[0]));
    }

    public void editPet(int petID, Pet newPet) throws IOException
    {
        VIAPets.allPets.editPet(petID, newPet);
        MyFileHandler.writeArrayToBinaryFile(PET_FILE, VIAPets.allPets.getPets().toArray(new Pet[0]));
    }


    public void addBooking(Booking booking) throws IOException
    {
        VIAPets.allBookings.addBooking(booking);
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, VIAPets.allBookings.getBookings().toArray(new Booking[0]));
    }

    public void deleteBooking(int bookingID) throws IOException
    {
        VIAPets.allBookings.removeBooking(getAllBookings().getBookingByID(bookingID));
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, VIAPets.allBookings.getBookings().toArray(new Booking[0]));
    }

    public void editBooking(int bookingID, Booking newBooking)
        throws IOException
    {
        VIAPets.allBookings.editBooking(bookingID, newBooking);
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, VIAPets.allBookings.getBookings().toArray(new Booking[0]));
    }

    public void addCustomer(Customer customer) throws IOException
    {
        VIAPets.allCustomers.addCustomer(customer);
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, VIAPets.allCustomers.getCustomers().toArray(new Customer[0]));
    }

    public void deleteCustomer(int customerID) throws IOException
    {
        VIAPets.allCustomers.removeCustomer(getAllCustomers().getCustomer(customerID));
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, VIAPets.allCustomers.getCustomers().toArray(new Customer[0]));
    }

    public void editCustomer(int customerID, Customer newCustomer)
        throws IOException
    {
        VIAPets.allCustomers.editCustomer(customerID, newCustomer);
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, VIAPets.allCustomers.getCustomers().toArray(new Customer[0]));


    }


    public void addSale(Sale sale) throws IOException
    {
        VIAPets.allSales.addSale(sale);
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, VIAPets.allSales.getSaleList().toArray(new Sale[0]));
    }

    public void deleteSale(int saleID) throws IOException
    {
        VIAPets.allSales.removeSale(getAllSales().getSaleByID(saleID));
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, VIAPets.allSales.getSaleList().toArray(new Sale[0]));
    }

    public void editSale(int saleID, Sale newSale) throws IOException
    {
        VIAPets.allSales.editSale(saleID, newSale);
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, VIAPets.allSales.getSaleList().toArray(new Sale[0]));

    }




}

    

