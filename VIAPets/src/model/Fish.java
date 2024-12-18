package model;

import java.io.Serializable;

/**
 * Class representing a Fish, extending the Pet class.
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Piotr Junosz
 * @version 1.0
 */
public class Fish extends Pet implements Serializable
{
  /** Indicates if the fish is saltwater. */
  private boolean saltwater;

  /** The species of the fish. */
  private String species;

  /** Indicates if the fish is a predator. */
  private boolean predator;

  /**
   * Constructs a new Fish instance with specified details.
   *
   * @param petID the unique ID of the pet
   * @param name the name of the fish
   * @param color the color of the fish
   * @param age the age of the fish
   * @param gender the gender of the fish
   * @param location the location of the fish
   * @param status the current status of the fish
   * @param saltwater true if the fish is saltwater, false otherwise
   * @param species the species of the fish
   * @param predator true if the fish is a predator, false otherwise
   * @param basePrice the base price of the fish
   * @param comment additional comments about the fish
   */
  public Fish(int petID, String name, String color, int age, char gender,
      String location, String status, boolean saltwater, String species,
      boolean predator, double basePrice, String comment)
  {
    super(petID, name, color, age, gender, location, status, basePrice, comment);
    this.saltwater = saltwater;
    this.species = species;
    this.predator = predator;
  }

  /**
   * Checks if the fish is saltwater.
   *
   * @return true if the fish is saltwater, false otherwise
   */
  public boolean isSaltwater()
  {
    return saltwater;
  }

  /**
   * Sets whether the fish is saltwater.
   *
   * @param saltwater true if the fish is saltwater, false otherwise
   */
  public void setSaltwater(boolean saltwater)
  {
    this.saltwater = saltwater;
  }

  /**
   * Gets the species of the fish.
   *
   * @return the species of the fish
   */
  public String getSpecies()
  {
    return species;
  }

  /**
   * Sets the species of the fish.
   *
   * @param species the species of the fish
   */
  public void setSpecies(String species)
  {
    this.species = species;
  }

  /**
   * Checks if the fish is a predator.
   *
   * @return true if the fish is a predator, false otherwise
   */
  public boolean isPredator()
  {
    return predator;
  }

  /**
   * Sets whether the fish is a predator.
   *
   * @param predator true if the fish is a predator, false otherwise
   */
  public void setPredator(boolean predator)
  {
    this.predator = predator;
  }

  /**
   * Gets the pet ID of the fish.
   *
   * @return the pet ID
   */
  public int getPetID()
  {
    return super.petID;
  }

  /**
   * Gets the name of the fish.
   *
   * @return the name of the fish
   */
  public String getName()
  {
    return super.name;
  }

  /**
   * Gets the color of the fish.
   *
   * @return the color of the fish
   */
  public String getColor()
  {
    return super.color;
  }

  /**
   * Gets the age of the fish.
   *
   * @return the age of the fish
   */
  public int getAge()
  {
    return super.age;
  }

  /**
   * Gets the gender of the fish.
   *
   * @return the gender of the fish
   */
  public char getGender()
  {
    return super.gender;
  }

  /**
   * Gets additional comments about the fish.
   *
   * @return comments about the fish
   */
  public String getComment()
  {
    return super.comment;
  }

  /**
   * Gets the location of the fish.
   *
   * @return the location of the fish
   */
  public String getLocation()
  {
    return super.location;
  }

  /**
   * Gets the status of the fish.
   *
   * @return the status of the fish
   */
  public String getStatus()
  {
    return super.status;
  }

  /**
   * Sets the pet ID of the fish.
   *
   * @param petID the unique ID of the fish
   */
  public void setPetID(int petID)
  {
    super.petID=petID;
  }

  /**
   * Sets the name of the fish.
   *
   * @param name the name of the fish
   */
  public void setName(String name)
  {
    super.name=name;
  }

  /**
   * Sets the age of the fish.
   *
   * @param age the age of the fish
   */
  public void setAge(int age)
  {
    super.age=age;
  }

  /**
   * Sets the gender of the fish.
   *
   * @param gender the gender of the fish
   */
  public void setGender(char gender)
  {
    super.gender=gender;
  }

  /**
   * Sets additional comments about the fish.
   *
   * @param comment comments about the fish
   */
  public void setComment(String comment)
  {
    super.comment=comment;
  }

  /**
   * Sets the location of the fish.
   *
   * @param location the location of the fish
   */
  public void setLocation(String location)
  {
    super.location=location;
  }

  /**
   * Sets the status of the fish.
   *
   * @param status the status of the fish
   */
  public void setStatus(String status)
  {
    super.status=status;
  }

  /**
   * Compares this fish to another object for equality.
   *
   * @param obj the object to compare
   * @return true if the objects are equal, false otherwise
   */
  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
    {
      return false;
    }
    Fish fish = (Fish) obj;
    return super.equals(fish) && fish.saltwater==saltwater && fish.species.equals(species) && fish.predator==predator;
  }

  /**
   * Provides a string representation of the fish.
   *
   * @return a string representation of the fish
   */
  public String toString()
  {
    return "Fish{" + "saltwater=" + saltwater + ", species='" + species + '\''
        + ", predator=" + predator + '}'+super.toString();
  }
}
