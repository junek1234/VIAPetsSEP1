import java.util.ArrayList;

public class CustomerList {
  private ArrayList<Customer> customers;

  // Constructor
  public CustomerList() {
    customers = new ArrayList<>();
  }

  // Add a new customer
  public void addCustomer(Customer customer) {
    customers.add(customer);
  }

  // Edit an existing customer !!!!!this is wrong
  public void editCustomer(Customer customer, int customerID, String newName, int newPhoneNumber, String newEmail) {
    {
        customer.setCustomerID(customerID);
        customer.setName(newName);
        customer.setPhoneNumber(newPhoneNumber);
        customer.setEmail(newEmail);
      }
    }
  }

  // Remove a customer by ID
  public void removeCustomer(int customerID) {
    customers.removeIf(customer -> customer.getCustomerID() == customerID);
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