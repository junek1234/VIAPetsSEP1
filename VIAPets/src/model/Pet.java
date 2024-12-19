package model;

import java.io.Serializable;

/**
 * Abstract class representing a Pet
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Piotr Junosz
 * @author Felipe Figueiredo
 * @version 1.0
 */
public abstract class Pet implements Serializable {

  /** Unique identifier for the pet. */
  protected int petID;

  /** Name of the pet. */
  protected String name;

  /** Color of the pet. */
  protected String color;

  /** Age of the pet. */
  protected int age;

  /** Gender of the pet ('M' for male, 'F' for female). */
  protected char gender;

  /** Additional comments about the pet. */
  protected String comment;

  /** Location of the pet. ("Shop" or "Kennel")*/
  protected String location;

  /** Status of the pet ("Sold", "Not Sold" or "Not From Via"). */
  protected String status;

  /** Base price of the pet. */
  protected double basePrice;

  /**
   * Sets the color of the pet.
   *
   * @param color the new color of the pet.
   */
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * Sets the base price of the pet.
   *
   * @param basePrice the new base price of the pet.
   */
  public void setBasePrice(double basePrice) {
    this.basePrice = basePrice;
  }

  /**
   * Gets the base price of the pet.
   *
   * @return the base price of the pet.
   */
  public double getBasePrice() {
    return basePrice;
  }

  /**
   * Constructs a new Pet with the specified attributes.
   *
   * @param petID the unique identifier for the pet.
   * @param name the name of the pet.
   * @param color the color of the pet.
   * @param age the age of the pet.
   * @param gender the gender of the pet.
   * @param location the location of the pet.
   * @param status the status of the pet.
   * @param basePrice the base price of the pet.
   * @param comment additional comments about the pet.
   */
  public Pet(int petID, String name, String color, int age, char gender, String location, String status, double basePrice, String comment) {
    this.petID = petID;
    this.name = name;
    this.color = color;
    this.age = age;
    this.gender = gender;
    this.location = location;
    this.status = status;
    this.basePrice = basePrice;
    this.comment = comment;
  }

  /**
   * Gets the unique identifier for the pet.
   *
   * @return the pet ID.
   */
  public abstract int getPetID();

  /**
   * Gets the name of the pet.
   *
   * @return the name of the pet.
   */
  public abstract String getName();

  /**
   * Gets the color of the pet.
   *
   * @return the color of the pet.
   */
  public abstract String getColor();

  /**
   * Gets the age of the pet.
   *
   * @return the age of the pet.
   */
  public abstract int getAge();

  /**
   * Gets the gender of the pet.
   *
   * @return the gender of the pet.
   */
  public abstract char getGender();

  /**
   * Gets additional comments about the pet.
   *
   * @return comments about the pet.
   */
  public abstract String getComment();

  /**
   * Gets the location of the pet.
   *
   * @return the location of the pet.
   */
  public abstract String getLocation();

  /**
   * Gets the status of the pet.
   *
   * @return the status of the pet.
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * Gets the price of the pet.
   *
   * @return the price of the pet.
   */
  public double getPrice() {
    return this.basePrice;
  }

  /**
   * Sets the unique identifier for the pet.
   *
   * @param petID the new pet ID.
   */
  public abstract void setPetID(int petID);

  /**
   * Sets the name of the pet.
   *
   * @param name the new name of the pet.
   */
  public abstract void setName(String name);

  /**
   * Sets the age of the pet.
   *
   * @param age the new age of the pet.
   */
  public abstract void setAge(int age);

  /**
   * Sets the gender of the pet.
   *
   * @param gender the new gender of the pet.
   */
  public abstract void setGender(char gender);

  /**
   * Sets additional comments about the pet.
   *
   * @param comment the new comments about the pet.
   */
  public abstract void setComment(String comment);

  /**
   * Sets the location of the pet.
   *
   * @param location the new location of the pet.
   */
  public abstract void setLocation(String location);

  /**
   * Sets the status of the pet.
   *
   * @param status the new status of the pet.
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Compares this pet to another object for equality.
   *
   * @param obj the object to compare.
   * @return true if the objects are equal; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()) {
      return false;
    }

    Pet pet = (Pet) obj;
    return pet.petID == petID && pet.name.equals(name) && pet.color.equals(color) && pet.age == age
        && pet.gender == gender && pet.comment.equals(comment) && pet.location.equals(location) && pet.status.equals(status);
  }

  /**
   * Returns a string representation of the pet attributes values.
   *
   * @return a string describing the pet attributes values.
   */
  @Override
  public String toString() {
    return "Pet{" + "petID=" + petID + ", name='" + name + '\'' + ", color='"
        + color + '\'' + ", age=" + age + ", gender=" + gender + ", comment='"
        + comment + '\'' + ", Location=" + location + ", Status='"
        + status + '\'' + '}';
  }
}
