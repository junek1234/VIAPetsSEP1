package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Sale class represents a sale transaction.
 * It includes the sale's ID, the customer involved, the pet sold, and the final sale price.
 * This class implements the Serializable interface for object serialization.
 *
 * @author Guillermo Sánchez Martínez
 * Felipe Figueiredo
 * @version 1.0
 */
public class Sale implements Serializable {
  private Customer customer;
  private Pet pet;
  private double salePrice;
  private int saleID;

  /**
   * Constructs a Sale object with the specified sale ID, customer, pet, and sale price.
   *
   * @param saleID the unique ID of the sale
   * @param customer the customer involved in the sale
   * @param pet the pet being sold
   * @param salePrice the price of the sale
   */
  public Sale(int saleID, Customer customer, Pet pet, double salePrice) {
    this.saleID = saleID;
    this.customer = customer;
    this.pet = pet;
    this.salePrice = salePrice;
  }

  /**
   * Gets the sale ID of the sale.
   *
   * @return the sale ID
   */
  public int getSaleID() {
    return saleID;
  }

  /**
   * Gets the customer involved in the sale.
   *
   * @return the customer of the sale
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * Sets the customer for the sale.
   *
   * @param customer the customer to set for the sale
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  /**
   * Gets the pet being sold in the sale.
   *
   * @return the pet of the sale
   */
  public Pet getPet() {
    return pet;
  }

  /**
   * Sets the pet for the sale.
   *
   * @param pet the pet to set for the sale
   */
  public void setPet(Pet pet) {
    this.pet = pet;
  }

  /**
   * Gets the sale price of the sale.
   *
   * @return the sale price
   */
  public double getSalePrice() {
    return salePrice;
  }

  /**
   * Sets the sale price for the sale.
   *
   * @param salePrice the new sale price
   */
  public void setSalePrice(double salePrice) {
    this.salePrice = salePrice;
  }

  /**
   * Compares this Sale object to another object for equality.
   * Two Sale objects are considered equal if they have the same sale ID, customer, pet, and sale price.
   *
   * @param object the object to compare this Sale to
   * @return true if the given object is equal to this Sale, false otherwise
   */
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Sale sale = (Sale) object;
    return Double.compare(salePrice, sale.salePrice) == 0
        && saleID == sale.saleID && Objects.equals(customer, sale.customer)
        && Objects.equals(pet, sale.pet);
  }

  /**
   * Returns a string representation of the Sale object in the format:
   *
   * @return a string representation of the Sale object
   */
  public String toString() {
    return "Sale{" + "customer=" + customer + ", pet=" + pet + ", salePrice=" + salePrice + ", saleID=" + saleID + '}';
  }

  /**
   * Sets the pet ID for the pet associated with the sale.
   *
   * @param newPetID the new pet ID to set
   */
  public void setPetID(int newPetID) {
    this.pet.setPetID(newPetID);
  }

  /**
   * Sets the customer ID for the customer associated with the sale.
   *
   * @param newCustomerID the new customer ID to set
   */
  public void setCustomerID(int newCustomerID) {
    this.customer.setCustomerID(newCustomerID);
  }
}
