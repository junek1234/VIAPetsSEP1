package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable
{
  private ArrayList<Customer> customers;

  // Constructor
  public CustomerList() {
    customers = new ArrayList<>();
  }
  //change in Astah
  public CustomerList(ArrayList<Customer> customers)
  {
    this.customers = customers;
  }

  // Add a new customer
  public void addCustomer(Customer customer) {
    customers.add(customer);
  }


  // Edit an existing customer (replacing old customer object with a new one changed in the Controller)
  public void editCustomer(int customerID, Customer newCustomer)
  {
    customers.set(customerID, newCustomer);
  }

  // Remove a customer by ID
  public void removeCustomer(Customer customer) {
   customers.remove(customer);
  }

  // Get a customer by ID
  public Customer getCustomer(int customerID) {
    for (Customer customer : customers) {
      if (customer.getCustomerID() == customerID) {
        return customer;
      }
    }
    return null;
  }
  //get customers
  //change in Astah

  public ArrayList<Customer> getCustomers()
  {
    return customers;
  }

  // toString method to display the list of customers
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Customer customer : customers) {
      sb.append(customer.toString()).append("\n");
    }
    return sb.toString();
  }
}