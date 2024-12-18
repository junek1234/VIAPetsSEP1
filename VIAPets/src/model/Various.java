package model;

import java.io.Serializable;

/**
 * Class representing a Various pet (different type), extending the Pet class.
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Piotr Junosz
 * @version 1.0
 */
public class Various extends Pet implements Serializable
{
  /** The species of the pet. */
  private String species;

  /**
   * Constructs a new Various object with specified attributes.
   *
   * @param petID       the unique ID of the pet
   * @param name        the name of the pet
   * @param color       the color of the pet
   * @param age         the age of the pet
   * @param gender      the gender of the pet
   * @param location    the location of the pet
   * @param status      the status of the pet
   * @param species     the species of the pet
   * @param basePrice   the base price of the pet
   * @param comment     additional comments about the pet
   */
  public Various(int petID, String name, String color, int age, char gender,
      String location, String status, String species, double basePrice, String comment)
  {
    super(petID, name, color, age, gender, location, status, basePrice, comment);
    this.species = species;
  }

  /**
   * Gets the species of the pet.
   *
   * @return the species of the pet
   */
  public String getSpecies()
  {
    return species;
  }

  /**
   * Sets the species of the pet.
   *
   * @param species the species of the pet
   */
  public void setSpecies(String species)
  {
    this.species = species;
  }

  /**
   * Gets the unique ID of the pet.
   *
   * @return the pet's unique ID
   */
  public int getPetID()
  {
    return super.petID;
  }

  /**
   * Gets the name of the pet.
   *
   * @return the pet's name
   */
  public String getName()
  {
    return super.name;
  }

  /**
   * Gets the color of the pet.
   *
   * @return the pet's color
   */
  public String getColor()
  {
    return super.color;
  }

  /**
   * Gets the age of the pet.
   *
   * @return the pet's age
   */
  public int getAge()
  {
    return super.age;
  }

  /**
   * Gets the gender of the pet.
   *
   * @return the pet's gender
   */
  public char getGender()
  {
    return super.gender;
  }

  /**
   * Gets the comments about the pet.
   *
   * @return the pet's comments
   */
  public String getComment()
  {
    return super.comment;
  }

  /**
   * Gets the location of the pet.
   *
   * @return the pet's location
   */
  public String getLocation()
  {
    return super.location;
  }

  /**
   * Gets the status of the pet.
   *
   * @return the pet's status
   */
  public String getStatus()
  {
    return super.status;
  }

  /**
   * Sets the unique ID of the pet.
   *
   * @param petID the new ID of the pet
   */
  public void setPetID(int petID)
  {
    super.petID=petID;
  }

  /**
   * Sets the name of the pet.
   *
   * @param name the new name of the pet
   */
  public void setName(String name)
  {
    super.name=name;
  }

  /**
   * Sets the age of the pet.
   *
   * @param age the new age of the pet
   */
  public void setAge(int age)
  {
    super.age=age;
  }

  /**
   * Sets the gender of the pet.
   *
   * @param gender the new gender of the pet
   */
  public void setGender(char gender)
  {
    super.gender=gender;
  }

  /**
   * Sets the comments about the pet.
   *
   * @param comment the new comment about the pet
   */
  public void setComment(String comment)
  {
    super.comment=comment;
  }

  /**
   * Sets the location of the pet.
   *
   * @param location the new location of the pet
   */
  public void setLocation(String location)
  {
    super.location=location;
  }

  /**
   * Sets the status of the pet.
   *
   * @param status the new status of the pet
   */
  public void setStatus(String status)
  {
    super.status=status;
  }

  /**
   * Compares this Various object to another object for equality.
   *
   * @param obj the object to compare to
   * @return true if the objects are equal, false otherwise
   */
  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
    {
      return false;
    }
    Various various = (Various) obj;
    return super.equals(various) && various.species.equals(species);

  }

}