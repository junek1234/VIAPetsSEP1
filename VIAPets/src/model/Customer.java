package model;

public class Customer {
  private int customerID;
  private String name;
  private int phoneNumber;
  private String email;

  // Constructor
  public Customer(int customerID, String name, int phoneNumber, String email) {
    this.customerID = customerID;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  // Getter and Setter methods
  public int getCustomerID() {
    return customerID;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // toString method
  @Override
  public String toString() {
    return "Customer{" +
        "customerID=" + customerID +
        ", name='" + name + '\'' +
        ", phoneNumber=" + phoneNumber +
        ", email='" + email + '\'' +
        '}';
  }

  // equals method for comparing customers
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Customer customer = (Customer) obj;

    return customerID == customer.customerID;
  }
}