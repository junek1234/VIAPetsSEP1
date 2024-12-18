package model;

import java.io.Serializable;

/**
 * Represents a customer with details such as ID, name, phone number, and email.
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Guillermo Sánchez Martínez
 * @version 1.0
 */
public class Customer implements Serializable {

  /**
   * The unique ID of the customer.
   */
  private int customerID;

  /**
   * The name of the customer.
   */
  private String name;

  /**
   * The phone number of the customer.
   */
  private int phoneNumber;

  /**
   * The email address of the customer.
   */
  private String email;

  /**
   * Constructs a Customer with the specified details.
   *
   * @param customerID the unique ID of the customer
   * @param name the name of the customer
   * @param phoneNumber the phone number of the customer
   * @param email the email address of the customer
   */
  public Customer(int customerID, String name, int phoneNumber, String email) {
    this.customerID = customerID;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  /**
   * Retrieves the customer's ID.
   *
   * @return the customer's ID
   */
  public int getCustomerID() {
    return customerID;
  }

  /**
   * Sets the customer's ID.
   *
   * @param customerID the new ID for the customer
   */
  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  /**
   * Retrieves the customer's name.
   *
   * @return the customer's name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the customer's name.
   *
   * @param name the new name for the customer
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Retrieves the customer's phone number.
   *
   * @return the customer's phone number
   */
  public int getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Sets the customer's phone number.
   *
   * @param phoneNumber the new phone number for the customer
   */
  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Retrieves the customer's email address.
   *
   * @return the customer's email address
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the customer's email address.
   *
   * @param email the new email address for the customer
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Returns a string representation of the customer.
   *
   * @return a string representation of the customer
   */
  @Override
  public String toString() {
    return "Customer{" +
        "customerID=" + customerID +
        ", name='" + name + '\'' +
        ", phoneNumber=" + phoneNumber +
        ", email='" + email + '\'' +
        '}';
  }

  /**
   * Compares this customer to another object for equality.
   * Customers are considered equal if their IDs match.
   *
   * @param obj the object to compare to
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Customer customer = (Customer) obj;

    return customerID == customer.customerID;
  }
}
