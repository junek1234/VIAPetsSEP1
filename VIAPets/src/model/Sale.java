package model;

import java.io.Serializable;
import java.util.Objects;

public class Sale implements Serializable
{
  private Customer customer;
  private Pet pet;
  private double salePrice;
  private int saleID;

  public Sale(int saleID, Customer customer, Pet pet, double salePrice)
  {
    this.saleID=saleID;
    this.customer = customer;
    this.pet = pet;
    this.salePrice = salePrice;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  public Pet getPet()
  {
    return pet;
  }

  public void setPet(Pet pet)
  {
    this.pet = pet;
  }

  public double getSalePrice()
  {
    return salePrice;
  }

  public void setSalePrice(double salePrice)
  {
    this.salePrice = salePrice;
  }

  public boolean equals(Object object)
  {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    Sale sale = (Sale) object;
    return Double.compare(salePrice, sale.salePrice) == 0
        && saleID == sale.saleID && Objects.equals(customer, sale.customer)
        && Objects.equals(pet, sale.pet);
  }

  public String toString()
  {
    return "Sale{" + "customer=" + customer + ", pet=" + pet + ", salePrice="
        + salePrice + ", saleID=" + saleID + '}';
  }
}