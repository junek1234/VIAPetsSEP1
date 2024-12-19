package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a list of customers. Provides methods to add, edit, remove, and retrieve customers.
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Guillermo Sánchez Martínez
 * @version 1.0
 */
public class CustomerList implements Serializable {

  /**
   * List of customers managed by this class.
   */
  private ArrayList<Customer> customers;

  /**
   * Constructs an empty CustomerList.
   */
  public CustomerList() {
    customers = new ArrayList<>();
  }

  /**
   * Constructs a CustomerList with the given list of customers.
   *
   * @param customers the initial list of customers
   */
  public CustomerList(ArrayList<Customer> customers) {
    this.customers = customers;
  }

  /**
   * Adds a customer to the list.
   *
   * @param customer the customer to be added
   */
  public void addCustomer(Customer customer) {
    customers.add(customer);
  }

  /**
   * Edits an existing customer by replacing it with a new customer object.
   *
   * @param customerID the ID of the customer to be replaced
   * @param newCustomer the new customer object to replace the old one
   * @throws IndexOutOfBoundsException if the customer ID does not exist in the list
   */
  public void editCustomer(int customerID, Customer newCustomer) {
    int index = customers.indexOf(getCustomer(customerID));
    customers.set(index, newCustomer);
  }

  /**
   * Removes a customer from the list.
   *
   * @param customer the customer to be removed
   */
  public void removeCustomer(Customer customer) {
    customers.remove(customer);
  }

  /**
   * Retrieves a customer by their ID.
   *
   * @param customerID the ID of the customer to be retrieved
   * @return the customer with the specified ID, or {@code null} if not found
   */
  public Customer getCustomer(int customerID) {
    for (Customer customer : customers) {
      if (customer.getCustomerID() == customerID) {
        return customer;
      }
    }
    return null;
  }

  /**
   * Returns the list of customers.
   *
   * @return the list of customers
   */
  public ArrayList<Customer> getCustomers() {
    return customers;
  }

  /**
   * Returns a string representation of the CustomerList.
   *
   * @return a string representation of the CustomerList
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Customer customer : customers) {
      sb.append(customer.toString()).append("\n");
    }
    return sb.toString();
  }

  /**
   * Retrieves a pet by its ID.
   *
   * @param customerID the ID of the pet to be retrieved
   * @return the customer with the specified ID, or null if not found
   */
  public Customer getCustomerByID(int customerID) {
    for (int i = 0; i < getCustomers().size(); i++) {
      if (getCustomers().get(i).getCustomerID() == customerID) {
        return getCustomers().get(i);
      }
    }
    return null;
  }
}


