package model;

import java.io.Serializable;

/**
 * Represents a Dog, which is a type of Pet.
 * Stores specific information about the dog, such as its breed and the breeder's name.
 * This class is serializable.
 *
 * @author Guillermo
 * @version 1
 */
public class Dog extends Pet implements Serializable
{
  private String breed;
  private String breederName;

  /**
   * Constructs a new Dog object with the specified attributes.
   *
   * @param petID        The unique identifier of the pet.
   * @param name         The name of the dog.
   * @param color        The color of the dog.
   * @param age          The age of the dog.
   * @param gender       The gender of the dog ('M' for male, 'F' for female).
   * @param isInTheShop  Indicates if the dog is currently in the shop.
   * @param isSold       The status of whether the dog is sold.
   * @param breed        The breed of the dog.
   * @param breederName  The name of the breeder who bred the dog.
   *
   * @version 1
   */
  public Dog(int petID, String name, String color, int age, char gender,
      boolean isInTheShop, String isSold, String breed, String breederName)
  {
    super(petID, name, color, age, gender, isInTheShop, isSold);
    this.breed = breed;
    this.breederName = breederName;
  }

  /**
   * Gets the breed of the dog.
   *
   * @return The breed of the dog.
   *
   * @version 1
   */
  public String getBreed()
  {
    return breed;
  }

  /**
   * Sets the breed of the dog.
   *
   * @param breed The breed of the dog.
   *
   * @version 1
   */
  public void setBreed(String breed)
  {
    this.breed = breed;
  }

  /**
   * Gets the name of the breeder.
   *
   * @return The name of the breeder.
   *
   * @version 1
   */
  public String getBreederName()
  {
    return breederName;
  }

  /**
   * Sets the name of the breeder.
   *
   * @param breederName The name of the breeder.
   *
   * @version 1
   */
  public void setBreederName(String breederName)
  {
    this.breederName = breederName;
  }

  /**
   * Gets the pet ID of the dog.
   *
   * @return The unique identifier of the pet.
   *
   * @version 1
   */
  public int getPetID()
  {
    return super.petID;
  }

  /**
   * Gets the name of the dog.
   *
   * @return The name of the dog.
   *
   * @version 1
   */
  public String getName()
  {
    return super.name;
  }

  /**
   * Gets the age of the dog.
   *
   * @return The age of the dog.
   *
   * @version 1
   */
  public int getAge()
  {
    return super.age;
  }

  /**
   * Gets the gender of the dog.
   *
   * @return The gender of the dog ('M' for male, 'F' for female).
   *
   * @version 1
   */
  public char getGender()
  {
    return super.gender;
  }

  /**
   * Gets additional comments about the dog.
   *
   * @return Comments about the dog.
   *
   * @version 1
   */
  public String getComment()
  {
    return super.comment;
  }

  /**
   * Checks if the dog is in the shop.
   *
   * @return {@code true} if the dog is in the shop, otherwise {@code false}.
   *
   * @version 1
   */
  public boolean getIsInTheShop()
  {
    return super.isInTheShop;
  }

  /**
   * Gets the sale status of the dog.
   *
   * @return The sale status of the dog.
   *
   * @version 1
   */
  public String getIsSold()
  {
    return super.isSold;
  }

  /**
   * Sets the pet ID of the dog.
   *
   * @param petID The unique identifier of the pet.
   *
   * @version 1
   */
  public void setPetID(int petID)
  {
    super.petID = petID;
  }

  /**
   * Sets the name of the dog.
   *
   * @param name The name of the dog.
   *
   * @version 1
   */
  public void setName(String name)
  {
    super.name = name;
  }

  /**
   * Sets the age of the dog.
   *
   * @param age The age of the dog.
   *
   * @version 1
   */
  public void setAge(int age)
  {
    super.age = age;
  }

  /**
   * Sets the gender of the dog.
   *
   * @param gender The gender of the dog ('M' for male, 'F' for female).
   *
   * @version 1
   */
  public void setGender(char gender)
  {
    super.gender = gender;
  }

  /**
   * Sets additional comments about the dog.
   *
   * @param comment Comments about the dog.
   *
   * @version 1
   */
  public void setComment(String comment)
  {
    super.comment = comment;
  }

  /**
   * Sets whether the dog is in the shop.
   *
   * @param isInTheShop {@code true} if the dog is in the shop, otherwise {@code false}.
   *
   * @version 1
   */
  public void setIsInTheShop(boolean isInTheShop)
  {
    super.isInTheShop = isInTheShop;
  }

  /**
   * Sets the sale status of the dog.
   *
   * @param isSold The sale status of the dog.
   *
   * @version 1
   */
  public void setIsSold(String isSold)
  {
    super.isSold = isSold;
  }

  /**
   * Checks if this Dog is equal to another object.
   *
   * @param obj The object to compare with.
   * @return {@code true} if the objects are equal, otherwise {@code false}.
   *
   * @version 1
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Dog dog = (Dog) obj;
    return super.equals(dog) && dog.breed.equals(breed) && dog.breederName.equals(breederName);
  }

  /**
   * Returns a string representation of the Dog.
   *
   * @return A string representation of the Dog.
   *
   * @version 1
   */
  public String toString()
  {
    return "Dog{" + "breed='" + breed + '\'' + ", breederName='" + breederName
        + '\'' + '}' + super.toString();
  }
}