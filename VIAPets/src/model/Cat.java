package model;

import java.io.Serializable;

/**
 * Represents a Cat, which is a type of Pet.
 * Stores specific information about the cat, such as its breed and the breeder's name.
 * This class is serializable.
 *
 * @author Guillermo
 * @version 1
 */
public class Cat extends Pet implements Serializable
{
  private String breed;
  private String breederName;

  /**
   * Constructs a new Cat object with the specified attributes.
   *
   * @param petID        The unique identifier of the pet.
   * @param name         The name of the cat.
   * @param color        The color of the cat.
   * @param age          The age of the cat.
   * @param gender       The gender of the cat ('M' for male, 'F' for female).
   * @param isInTheShop  Indicates if the cat is currently in the shop.
   * @param isSold       The status of whether the cat is sold.
   * @param breed        The breed of the cat.
   * @param breederName  The name of the breeder who bred the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public Cat(int petID, String name, String color, int age, char gender,
      boolean isInTheShop, String isSold, String breed, String breederName)
  {
    super(petID, name, color, age, gender, isInTheShop, isSold);
    this.breed = breed;
    this.breederName = breederName;
  }

  /**
   * Gets the breed of the cat.
   *
   * @return The breed of the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public String getBreed()
  {
    return breed;
  }

  /**
   * Sets the breed of the cat.
   *
   * @param breed The breed of the cat.
   *
   * @author Guillermo
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
   * @author Guillermo
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
   * @author Guillermo
   * @version 1
   */
  public void setBreederName(String breederName)
  {
    this.breederName = breederName;
  }

  // Overrides and inherited methods

  /**
   * Gets the pet ID of the cat.
   *
   * @return The unique identifier of the pet.
   *
   * @author Guillermo
   * @version 1
   */
  public int getPetID()
  {
    return super.petID;
  }

  /**
   * Gets the name of the cat.
   *
   * @return The name of the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public String getName()
  {
    return super.name;
  }

  /**
   * Gets the age of the cat.
   *
   * @return The age of the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public int getAge()
  {
    return super.age;
  }

  /**
   * Gets the gender of the cat.
   *
   * @return The gender of the cat ('M' for male, 'F' for female).
   *
   * @author Guillermo
   * @version 1
   */
  public char getGender()
  {
    return super.gender;
  }

  /**
   * Gets additional comments about the cat.
   *
   * @return Comments about the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public String getComment()
  {
    return super.comment;
  }

  /**
   * Checks if the cat is in the shop.
   *
   * @return {@code true} if the cat is in the shop, otherwise {@code false}.
   *
   * @author Guillermo
   * @version 1
   */
  public boolean getIsInTheShop()
  {
    return super.isInTheShop;
  }

  /**
   * Gets the sale status of the cat.
   *
   * @return The sale status of the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public String getIsSold()
  {
    return super.isSold;
  }

  /**
   * Sets the pet ID of the cat.
   *
   * @param petID The unique identifier of the pet.
   *
   * @author Guillermo
   * @version 1
   */
  public void setPetID(int petID)
  {
    super.petID = petID;
  }

  /**
   * Sets the name of the cat.
   *
   * @param name The name of the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public void setName(String name)
  {
    super.name = name;
  }

  /**
   * Sets the age of the cat.
   *
   * @param age The age of the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public void setAge(int age)
  {
    super.age = age;
  }

  /**
   * Sets the gender of the cat.
   *
   * @param gender The gender of the cat ('M' for male, 'F' for female).
   *
   * @author Guillermo
   * @version 1
   */
  public void setGender(char gender)
  {
    super.gender = gender;
  }

  /**
   * Sets additional comments about the cat.
   *
   * @param comment Comments about the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public void setComment(String comment)
  {
    super.comment = comment;
  }

  /**
   * Sets whether the cat is in the shop.
   *
   * @param isInTheShop {@code true} if the cat is in the shop, otherwise {@code false}.
   *
   * @author Guillermo
   * @version 1
   */
  public void setIsInTheShop(boolean isInTheShop)
  {
    super.isInTheShop = isInTheShop;
  }

  /**
   * Sets the sale status of the cat.
   *
   * @param isSold The sale status of the cat.
   *
   * @author Guillermo
   * @version 1
   */
  public void setIsSold(String isSold)
  {
    super.isSold = isSold;
  }

  /**
   * Checks if this Cat is equal to another object.
   *
   * @param obj The object to compare with.
   * @return {@code true} if the objects are equal, otherwise {@code false}.
   *
   * @author Guillermo
   * @version 1
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Cat cat = (Cat) obj;
    return super.equals(cat) && cat.breed.equals(breed) && cat.breederName.equals(breederName);
  }

  /**
   * Returns a string representation of the Cat.
   *
   * @return A string representation of the Cat.
   *
   * @author Guillermo
   * @version 1
   */
  public String toString()
  {
    return "Cat{" + "breed='" + breed + '\'' + ", breederName='" + breederName
        + '\'' + '}' + super.toString();
  }
}