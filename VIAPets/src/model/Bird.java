package model;

import java.io.Serializable;

/**
 * Represents a Bird, which is a type of Pet.
 * Stores specific information about the bird, such as its species and preferred food.
 * This class is serializable.
 *
 * @author Guillermo
 * @version 1
 */
public class Bird extends Pet implements Serializable
{
  private String species;
  private String preferredFood;

  /**
   * Constructs a new Bird object with the specified attributes.
   *
   * @param petID        The unique identifier of the pet.
   * @param name         The name of the bird.
   * @param color        The color of the bird.
   * @param age          The age of the bird.
   * @param gender       The gender of the bird ('M' for male, 'F' for female).
   * @param isInTheShop  Indicates if the bird is currently in the shop.
   * @param isSold       The status of whether the bird is sold.
   * @param species      The species of the bird.
   * @param preferredFood The bird's preferred type of food.
   *
   * @author Guillermo
   * @version 1
   */
  public Bird(int petID, String name, String color, int age, char gender,
      boolean isInTheShop, String isSold, String species, String preferredFood)
  {
    super(petID, name, color, age, gender, isInTheShop, isSold);
    this.species = species;
    this.preferredFood = preferredFood;
  }

  /**
   * Gets the species of the bird.
   *
   * @return The species of the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public String getSpecies()
  {
    return species;
  }

  /**
   * Sets the species of the bird.
   *
   * @param species The species of the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public void setSpecies(String species)
  {
    this.species = species;
  }

  /**
   * Gets the preferred food of the bird.
   *
   * @return The preferred food of the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public String getPreferredFood()
  {
    return preferredFood;
  }

  /**
   * Sets the preferred food of the bird.
   *
   * @param preferredFood The preferred food of the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public void setPreferredFood(String preferredFood)
  {
    this.preferredFood = preferredFood;
  }

  // Overrides and inherited methods

  /**
   * Gets the pet ID of the bird.
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
   * Gets the name of the bird.
   *
   * @return The name of the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public String getName()
  {
    return super.name;
  }

  /**
   * Gets the age of the bird.
   *
   * @return The age of the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public int getAge()
  {
    return super.age;
  }

  /**
   * Gets the gender of the bird.
   *
   * @return The gender of the bird ('M' for male, 'F' for female).
   *
   * @author Guillermo
   * @version 1
   */
  public char getGender()
  {
    return super.gender;
  }

  /**
   * Gets additional comments about the bird.
   *
   * @return Comments about the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public String getComment()
  {
    return super.comment;
  }

  /**
   * Checks if the bird is in the shop.
   *
   * @return {@code true} if the bird is in the shop, otherwise {@code false}.
   *
   * @author Guillermo
   * @version 1
   */
  public boolean getIsInTheShop()
  {
    return super.isInTheShop;
  }

  /**
   * Gets the sale status of the bird.
   *
   * @return The sale status of the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public String getIsSold()
  {
    return super.isSold;
  }

  /**
   * Sets the pet ID of the bird.
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
   * Sets the name of the bird.
   *
   * @param name The name of the bird.
   *
   * @version 1
   */
  public void setName(String name)
  {
    super.name = name;
  }

  /**
   * Sets the age of the bird.
   *
   * @param age The age of the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public void setAge(int age)
  {
    super.age = age;
  }

  /**
   * Sets the gender of the bird.
   *
   * @param gender The gender of the bird ('M' for male, 'F' for female).
   *
   * @author Guillermo
   * @version 1
   */
  public void setGender(char gender)
  {
    super.gender = gender;
  }

  /**
   * Sets additional comments about the bird.
   *
   * @param comment Comments about the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public void setComment(String comment)
  {
    super.comment = comment;
  }

  /**
   * Sets whether the bird is in the shop.
   *
   * @param isInTheShop {@code true} if the bird is in the shop, otherwise {@code false}.
   *
   * @author Guillermo
   * @version 1
   */
  public void setIsInTheShop(boolean isInTheShop)
  {
    super.isInTheShop = isInTheShop;
  }

  /**
   * Sets the sale status of the bird.
   *
   * @param isSold The sale status of the bird.
   *
   * @author Guillermo
   * @version 1
   */
  public void setIsSold(String isSold)
  {
    super.isSold = isSold;
  }

  /**
   * Checks if this Bird is equal to another object.
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
    Bird bird = (Bird) obj;
    return super.equals(bird) && bird.species.equals(species) && bird.preferredFood.equals(preferredFood);
  }

  /**
   * Returns a string representation of the Bird.
   *
   * @return A string representation of the Bird.
   *
   * @author Guillermo
   * @version 1
   */
  public String toString()
  {
    return "Bird{" + "species='" + species + '\'' + ", preferredFood='"
        + preferredFood + '\'' + '}' + super.toString();
  }
}