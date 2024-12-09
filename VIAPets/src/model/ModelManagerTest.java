package model;

import utils.XMLHandler;

import java.io.IOException;
import java.util.ArrayList;

public class ModelManagerTest
{
  public static void main(String[] args) throws IOException
  {
    MyModelManager test1 = new MyModelManager();
    VIAPets viaPets = new VIAPets(1,2);
    int dogID=MyModelManager.createNextPetID();
    Dog dog = new Dog(dogID,"Bimbo","Brown",2,'m',"Shop","Sold","No","Idk", 15, "bla");
    int catID=MyModelManager.createNextPetID();
    Cat cat = new Cat(catID,"Limbo","Brown",2,'m',"Shop","Sold","No","Idk", 15, "bla");
    int fishID=MyModelManager.createNextPetID();
    Fish fish = new Fish(fishID,"Wqeqwe","Brown",2,'m',"Shop","Sold",false,"Idk", true, 20, "bla");


//    int customerID1 = MyModelManager.createNextCustomerID();
//    Customer customer1 = new Customer(customerID1,"Adam",1234,"wdadawdawd.com");
//    customerID1 = MyModelManager.createNextCustomerID();
//    Customer customer2 = new Customer(customerID1,"Guillermo",643,"wdadawdawd.com");
//
//    int saleID = MyModelManager.createNextSaleID();
//    Sale sale1 = new Sale(saleID, customer1, dog, 123);
//    int bookingID = MyModelManager.createNextBookingID();
//    Date date1 = new Date(1,1,2009,1);
//    Date date2 = new Date(1,1,2010,1);
//    DateInterval dateInterval=new DateInterval(date1, date2);
//    Booking booking1 = new Booking(bookingID, dog, customer1, dateInterval);
    test1.addPet(dog);
    test1.addPet(cat);
    test1.addPet(fish);
//    test1.addCustomer(customer1);
//    test1.addCustomer(customer2);
//    test1.addSale(sale1);
//    test1.addBooking(booking1);
//   System.out.println(test1.getAllPets().getPets().size());
    ArrayList<Pet> testArrayListPets = test1.getAllPets().getPets();
//    ArrayList<Customer> testArrayListCustomers = test1.getAllCustomers().getCustomers();
//    ArrayList<Sale> testArrayListSales = test1.getAllSales().getSaleList();
//    ArrayList<Booking> testArrayListBookings = test1.getAllBookings().getBookings();


    System.out.println(testArrayListPets);
//    System.out.println(testArrayListCustomers);
//    System.out.println(testArrayListSales);
//    System.out.println(testArrayListBookings);
      test1.deletePet(3);

    XMLHandler.updateXML();
  }
}
