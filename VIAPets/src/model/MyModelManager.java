package model;

import utils.MyFileHandler;
import java.io.IOException;
import java.io.FileNotFoundException;

public class MyModelManager {
    private static final String PET_FILE = "pets.dat";
    private static final String BOOKING_FILE = "bookings.dat";
    private static final String CUSTOMER_FILE = "customers.dat";
    private static final String SALE_FILE = "sales.dat";

    private PetList petList;
    private BookingList bookingList;
    private CustomerList customerList;
    private SaleList saleList;

    public MyModelManager() {
        petList = (PetList) loadFromFile(PET_FILE, new PetList());
        bookingList = (BookingList) loadFromFile(BOOKING_FILE, new BookingList());
        customerList = (CustomerList) loadFromFile(CUSTOMER_FILE, new CustomerList());
        saleList = (SaleList) loadFromFile(SALE_FILE, new SaleList());
    }

    private Object loadFromFile(String fileName, Object defaultValue) {
        try {
            return MyFileHandler.readFromBinaryFile(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName + ", initializing empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading file " + fileName + ": " + e.getMessage());
        }
        return defaultValue;
    }

    private void saveToFile(String fileName, Object obj) {
        try {
            MyFileHandler.writeToBinaryFile(fileName, obj);
        } catch (IOException e) {
            System.err.println("Error saving to file " + fileName + ": " + e.getMessage());
        }
    }

    public void addPet(Pet pet) {
        petList.add(pet);
        saveToFile(PET_FILE, petList);
    }

    public void deletePet(Pet petID) {
        petList.remove(petID);
        saveToFile(PET_FILE, petList);
    }

    public PetList getAllPets() {
        return petList;
    }

    public void addBooking(Booking booking) {
        bookingList.addBooking(booking);
        saveToFile(BOOKING_FILE, bookingList);
    }

    public void deleteBooking(Booking bookingID) {
        bookingList.removeBooking(bookingID);
        saveToFile(BOOKING_FILE, bookingList);
    }

    public BookingList getAllBookings() {
        return bookingList;
    }

    public void addCustomer(Customer customer) {
        customerList.addCustomer(customer);
        saveToFile(CUSTOMER_FILE, customerList);
    }

    public void deleteCustomer(Customer customerID) {
        customerList.removeCustomer(customerID);
        saveToFile(CUSTOMER_FILE, customerList);
    }

    public CustomerList getAllCustomers() {
        return customerList;
    }

    public void addSale(Sale sale) {
        saleList.addSale(sale);
        saveToFile(SALE_FILE, saleList);
    }

    public void deleteSale(Sale saleID) {
        saleList.removeSale(saleID);
        saveToFile(SALE_FILE, saleList);
    }

    public SaleList getAllSales() {
        return saleList;
    }
}

    

