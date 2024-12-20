package model;

import java.io.Serializable;

/**
 * Class representing a Rodent, extending the Pet class.
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Piotr Junosz
 * @version 1.0
 */
public class Rodent extends Pet implements Serializable
{
  /** The species of the Rodent. */
  private String species;

  /**
   * Constructs a new Rodent object.
   *
   * @param petID the ID of the pet
   * @param name the name of the rodent
   * @param color the color of the rodent
   * @param age the age of the rodent
   * @param gender the gender of the rodent
   * @param location the location of the rodent
   * @param status the status of the rodent
   * @param species the species of the rodent
   * @param basePrice the base price of the rodent
   * @param comment additional comments about the rodent
   */
  public Rodent(int petID, String name, String color, int age, char gender,
      String location, String status, String species, double basePrice, String comment)
  {
    super(petID, name, color, age, gender, location, status, basePrice, comment);
    this.species = species;
  }

  /**
   * Gets the species of the rodent.
   *
   * @return the species of the rodent
   */
  public String getSpecies()
  {
    return species;
  }

  /**
   * Sets the species of the rodent.
   *
   * @param species the species to set
   */
  public void setSpecies(String species)
  {
    this.species = species;
  }

  /**
   * Gets the pet ID of the rodent.
   *
   * @return the pet ID
   */
  public int getPetID()
  {
    return super.petID;
  }

  /**
   * Gets the name of the rodent.
   *
   * @return the name of the rodent
   */
  public String getName()
  {
    return super.name;
  }

  /**
   * Gets the age of the rodent.
   *
   * @return the age of the rodent
   */
  public int getAge()
  {
    return super.age;
  }

  /**
   * Gets the gender of the rodent.
   *
   * @return the gender of the rodent
   */
  public char getGender()
  {
    return super.gender;
  }

  /**
   * Gets additional comments about the rodent.
   *
   * @return the comments about the rodent
   */
  public String getComment()
  {
    return super.comment;
  }

  /**
   * Gets the location of the rodent.
   *
   * @return the location of the rodent
   */
  public String getLocation()
  {
    return super.location;
  }

  /**
   * Gets the status of the rodent.
   *
   * @return the status of the rodent
   */
  public String getStatus()
  {
    return super.status;
  }

  /**
   * Sets the pet ID of the rodent.
   *
   * @param petID the pet ID to set
   */
  public void setPetID(int petID)
  {
    super.petID = petID;
  }

  /**
   * Sets the name of the rodent.
   *
   * @param name the name to set
   */
  public void setName(String name)
  {
    super.name = name;
  }

  /**
   * Gets the color of the rodent.
   *
   * @return the color of the rodent
   */
  public String getColor()
  {
    return super.color;
  }

  /**
   * Sets the age of the rodent.
   *
   * @param age the age to set
   */
  public void setAge(int age)
  {
    super.age = age;
  }

  /**
   * Sets the gender of the rodent.
   *
   * @param gender the gender to set
   */
  public void setGender(char gender)
  {
    super.gender = gender;
  }

  /**
   * Sets additional comments about the rodent.
   *
   * @param comment the comments to set
   */
  public void setComment(String comment)
  {
    super.comment = comment;
  }

  /**
   * Sets the location of the rodent.
   *
   * @param location the location to set
   */
  public void setLocation(String location)
  {
    super.location = location;
  }

  /**
   * Sets the status of the rodent.
   *
   * @param status the status to set
   */
  public void setStatus(String status)
  {
    super.status = status;
  }

  /**
   * Checks if this rodent is equal to another object.
   *
   * @param obj the object to compare with
   * @return true if the objects are equal, false otherwise
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Rodent rodent = (Rodent) obj;
    return super.equals(rodent) && rodent.species.equals(species);
  }

  /**
   * Returns a string representation of the rodent.
   *
   * @return a string representation of the rodent
   */
  public String toString()
  {
    return "Rodent{" + "species='" + species + '\'' + '}'+ super.toString();
  }
}
