package model;

import java.io.Serializable;

public class Sale implements Serializable
{
  private Customer customer;
  private Pet pet;
  private double salePrice;

  public Sale(Customer customer, Pet pet, double salePrice)
  {
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
}