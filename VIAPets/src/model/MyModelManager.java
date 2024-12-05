package model;

import utils.MyFileHandler;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MyModelManager {
    //needs to be changed in Astah
    private static final String PET_FILE = "pets.bin";
    private static final String BOOKING_FILE = "bookings.bin";
    private static final String CUSTOMER_FILE = "customers.bin";
    private static final String SALE_FILE = "sales.bin";
    //needs to be changed in Astah

    public MyModelManager()
    {
        //loading lists of object from files and casting them
        ArrayList<Pet> pets=new ArrayList<>();
        ArrayList<Booking> bookings=new ArrayList<>();
        ArrayList<Customer> customers=new ArrayList<>();
        ArrayList<Sale> sales=new ArrayList<>();

        ArrayList<Object> objects = loadFromFile(PET_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            pets.add((Pet)objects.get(i));
        }
        VIAPets.allPets = new PetList(pets);

        objects = loadFromFile(BOOKING_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            bookings.add((Booking)objects.get(i));
        }
        VIAPets.allBookings = new BookingList(bookings);

        objects = loadFromFile(CUSTOMER_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            customers.add((Customer) objects.get(i));
        }
        VIAPets.allCustomers = new CustomerList(customers);

        objects = loadFromFile(SALE_FILE);
        for (int i = 0; i < objects.size(); i++)
        {
            sales.add((Sale) objects.get(i));
        }
        VIAPets.allSales = new SaleList(sales);
    }

    private ArrayList<Object> loadFromFile(String fileName) {
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

    private void saveToFile(String fileName, Object obj) {
        try {
            MyFileHandler.writeToBinaryFile(fileName, obj);
        } catch (IOException e) {
            System.err.println("Error saving to file " + fileName + ": " + e.getMessage());
        }
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


    public void addPet(Pet pet) throws IOException
    {
        VIAPets.allPets.addPet(pet);
        MyFileHandler.appendToBinaryFile(PET_FILE, pet);
    }

    public void deletePet(int petID) throws IOException
    {
        VIAPets.allPets.removePet(getAllPets().getPetByID(petID));
        MyFileHandler.writeArrayToBinaryFile(PET_FILE, VIAPets.allPets.getPets().toArray(new Pet[0]));
    }



    public void addBooking(Booking booking) throws IOException
    {
        VIAPets.allBookings.addBooking(booking);
        MyFileHandler.appendToBinaryFile(BOOKING_FILE, booking);
    }

    public void deleteBooking(int bookingID) throws IOException
    {
        VIAPets.allBookings.removeBooking(getAllBookings().getBooking(bookingID));
        MyFileHandler.writeArrayToBinaryFile(BOOKING_FILE, VIAPets.allBookings.getBookings().toArray(new Booking[0]));
    }



    public void addCustomer(Customer customer) throws IOException
    {
        VIAPets.allCustomers.addCustomer(customer);
        MyFileHandler.appendToBinaryFile(CUSTOMER_FILE, customer);
    }

    public void deleteCustomer(int customerID) throws IOException
    {
        VIAPets.allCustomers.removeCustomer(getAllCustomers().getCustomer(customerID));
        MyFileHandler.writeArrayToBinaryFile(CUSTOMER_FILE, VIAPets.allCustomers.getCustomers().toArray(new Customer[0]));
    }


    public void addSale(Sale sale) throws IOException
    {
        VIAPets.allSales.addSale(sale);
        MyFileHandler.appendToBinaryFile(SALE_FILE, sale);
    }

    public void deleteSale(int saleID) throws IOException
    {
        VIAPets.allSales.removeSale(getAllSales().getSaleByID(saleID));
        MyFileHandler.writeArrayToBinaryFile(SALE_FILE, VIAPets.allSales.getSaleList().toArray(new Sale[0]));
    }


}

    

