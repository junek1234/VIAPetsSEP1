package model;

import java.io.Serializable;

/**
 * Represents a Fish, which is a type of Pet.
 * Stores specific information about the fish, such as whether it is saltwater,
 * its species, and if it is a predator.
 * This class is serializable.
 *
 * @author Guillermo
 * @version 1
 */
public class Fish extends Pet implements Serializable
{
  private boolean saltwater;
  private String species;
  private boolean predator;

  /**
   * Constructs a new Fish object with the specified attributes.
   *
   * @param petID        The unique identifier of the pet.
   * @param name         The name of the fish.
   * @param color        The color of the fish.
   * @param age          The age of the fish.
   * @param gender       The gender of the fish ('M' for male, 'F' for female).
   * @param isInTheShop  Indicates if the fish is currently in the shop.
   * @param isSold       The status of whether the fish is sold.
   * @param saltwater    Indicates if the fish is a saltwater fish.
   * @param species      The species of the fish.
   * @param predator     Indicates if the fish is a predator.
   */
  public Fish(int petID, String name, String color, int age, char gender,
      boolean isInTheShop, String isSold, boolean saltwater, String species,
      boolean predator)
  {
    super(petID, name, color, age, gender, isInTheShop, isSold);
    this.saltwater = saltwater;
    this.species = species;
    this.predator = predator;
  }

  /**
   * Checks if the fish is a saltwater fish.
   *
   * @return {@code true} if the fish is a saltwater fish, otherwise {@code false}.
   */
  public boolean isSaltwater()
  {
    return saltwater;
  }

  /**
   * Sets whether the fish is a saltwater fish.
   *
   * @param saltwater {@code true} if the fish is a saltwater fish, otherwise {@code false}.
   */
  public void setSaltwater(boolean saltwater)
  {
    this.saltwater = saltwater;
  }

  /**
   * Gets the species of the fish.
   *
   * @return The species of the fish.
   */
  public String getSpecies()
  {
    return species;
  }

  /**
   * Sets the species of the fish.
   *
   * @param species The species of the fish.
   */
  public void setSpecies(String species)
  {
    this.species = species;
  }

  /**
   * Checks if the fish is a predator.
   *
   * @return {@code true} if the fish is a predator, otherwise {@code false}.
   */
  public boolean isPredator()
  {
    return predator;
  }

  /**
   * Sets whether the fish is a predator.
   *
   * @param predator {@code true} if the fish is a predator, otherwise {@code false}.
   */
  public void setPredator(boolean predator)
  {
    this.predator = predator;
  }

  /**
   * Gets the pet ID of the fish.
   *
   * @return The unique identifier of the pet.
   */
  public int getPetID()
  {
    return super.petID;
  }

  /**
   * Gets the name of the fish.
   *
   * @return The name of the fish.
   */
  public String getName()
  {
    return super.name;
  }

  /**
   * Gets the age of the fish.
   *
   * @return The age of the fish.
   */
  public int getAge()
  {
    return super.age;
  }

  /**
   * Gets the gender of the fish.
   *
   * @return The gender of the fish ('M' for male, 'F' for female).
   */
  public char getGender()
  {
    return super.gender;
  }

  /**
   * Gets additional comments about the fish.
   *
   * @return Comments about the fish.
   */
  public String getComment()
  {
    return super.comment;
  }

  /**
   * Checks if the fish is in the shop.
   *
   * @return {@code true} if the fish is in the shop, otherwise {@code false}.
   */
  public boolean getIsInTheShop()
  {
    return super.isInTheShop;
  }

  /**
   * Gets the sale status of the fish.
   *
   * @return The sale status of the fish.
   */
  public String getIsSold()
  {
    return super.isSold;
  }

  /**
   * Sets the pet ID of the fish.
   *
   * @param petID The unique identifier of the pet.
   */
  public void setPetID(int petID)
  {
    super.petID = petID;
  }

  /**
   * Sets the name of the fish.
   *
   * @param name The name of the fish.
   */
  public void setName(String name)
  {
    super.name = name;
  }

  /**
   * Sets the age of the fish.
   *
   * @param age The age of the fish.
   */
  public void setAge(int age)
  {
    super.age = age;
  }

  /**
   * Sets the gender of the fish.
   *
   * @param gender The gender of the fish ('M' for male, 'F' for female).
   */
  public void setGender(char gender)
  {
    super.gender = gender;
  }

  /**
   * Sets additional comments about the fish.
   *
   * @param comment Comments about the fish.
   */
  public void setComment(String comment)
  {
    super.comment = comment;
  }

  /**
   * Sets whether the fish is in the shop.
   *
   * @param isInTheShop {@code true} if the fish is in the shop, otherwise {@code false}.
   */
  public void setIsInTheShop(boolean isInTheShop)
  {
    super.isInTheShop = isInTheShop;
  }

  /**
   * Sets the sale status of the fish.
   *
   * @param isSold The sale status of the fish.
   */
  public void setIsSold(String isSold)
  {
    super.isSold = isSold;
  }

  /**
   * Checks if this Fish is equal to another object.
   *
   * @param obj The object to compare with.
   * @return {@code true} if the objects are equal, otherwise {@code false}.
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Fish fish = (Fish) obj;
    return super.equals(fish) && fish.saltwater == saltwater &&
        fish.species.equals(species) && fish.predator == predator;
  }

  /**
   * Returns a string representation of the Fish.
   *
   * @return A string representation of the Fish.
   */
  public String toString()
  {
    return "Fish{" + "saltwater=" + saltwater + ", species='" + species + '\'' +
        ", predator=" + predator + '}' + super.toString();
  }
}
