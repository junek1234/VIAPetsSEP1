package model;

import java.io.Serializable;

/**
 * Class representing a Bird, extending the Pet class.
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Piotr Junosz
 * @version 1.0
 */
public class Bird extends Pet implements Serializable {

  /** The species of the bird. */
  private String species;

  /** The preferred food of the bird. */
  private String preferredFood;

  /**
   * Constructs a new Bird with the specified attributes.
   *
   * @param petID the unique identifier for the bird.
   * @param name the name of the bird.
   * @param color the color of the bird.
   * @param age the age of the bird.
   * @param gender the gender of the bird.
   * @param location the location of the bird.
   * @param status the status of the bird.
   * @param species the species of the bird.
   * @param preferredFood the preferred food of the bird.
   * @param basePrice the base price of the bird.
   * @param comment additional comments about the bird.
   */
  public Bird(int petID, String name, String color, int age, char gender,
      String location, String status, String species, String preferredFood, double basePrice, String comment) {
    super(petID, name, color, age, gender, location, status, basePrice, comment);
    this.species = species;
    this.preferredFood = preferredFood;
  }

  /**
   * Gets the species of the bird.
   *
   * @return the species of the bird.
   */
  public String getSpecies() {
    return species;
  }

  /**
   * Sets the species of the bird.
   *
   * @param species the new species of the bird.
   */
  public void setSpecies(String species) {
    this.species = species;
  }

  /**
   * Gets the preferred food of the bird.
   *
   * @return the preferred food of the bird.
   */
  public String getPreferredFood() {
    return preferredFood;
  }

  /**
   * Sets the preferred food of the bird.
   *
   * @param preferredFood the new preferred food of the bird.
   */
  public void setPreferredFood(String preferredFood) {
    this.preferredFood = preferredFood;
  }

  /**
   * Gets the pet ID of the bird.
   *
   * @return the pet ID.
   */
  public int getPetID() {
    return super.petID;
  }

  /**
   * Gets the name of the bird.
   *
   * @return the name of the bird.
   */
  public String getName() {
    return super.name;
  }

  /**
   * Gets the color of the bird.
   *
   * @return the color of the bird.
   */
  public String getColor() {
    return super.color;
  }

  /**
   * Gets the age of the bird.
   *
   * @return the age of the bird.
   */
  public int getAge() {
    return super.age;
  }

  /**
   * Gets the gender of the bird.
   *
   * @return the gender of the bird.
   */
  public char getGender() {
    return super.gender;
  }

  /**
   * Gets additional comments about the bird.
   *
   * @return comments about the bird.
   */
  public String getComment() {
    return super.comment;
  }

  /**
   * Gets the location of the bird.
   *
   * @return the location of the bird.
   */
  public String getLocation() {
    return super.location;
  }

  /**
   * Gets the status of the bird.
   *
   * @return the status of the bird.
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the pet ID of the bird.
   *
   * @param petID the new pet ID.
   */
  public void setPetID(int petID) {
    super.petID = petID;
  }

  /**
   * Sets the name of the bird.
   *
   * @param name the new name of the bird.
   */
  public void setName(String name) {
    super.name = name;
  }

  /**
   * Sets the age of the bird.
   *
   * @param age the new age of the bird.
   */
  public void setAge(int age) {
    super.age = age;
  }

  /**
   * Sets the gender of the bird.
   *
   * @param gender the new gender of the bird.
   */
  public void setGender(char gender) {
    super.gender = gender;
  }

  /**
   * Sets additional comments about the bird.
   *
   * @param comment the new comments about the bird.
   */
  public void setComment(String comment) {
    super.comment = comment;
  }

  /**
   * Sets the location of the bird.
   *
   * @param location the new location of the bird.
   */
  public void setLocation(String location) {
    super.location = location;
  }

  /**
   * Sets the status of the bird.
   *
   * @param status the new status of the bird.
   */
  public void setStatus(String status) {
    super.status = status;
  }

  /**
   * Compares this bird to another object for equality.
   *
   * @param obj the object to compare.
   * @return true if the objects are equal; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()) {
      return false;
    }
    Bird bird = (Bird) obj;
    return super.equals(bird) && bird.species.equals(species) && bird.preferredFood.equals(preferredFood);
  }

  /**
   * Returns a string representation of the bird.
   *
   * @return a string describing the bird.
   */
  @Override
  public String toString() {
    return "Bird{" + "species='" + species + '\'' + ", preferredFood='"
        + preferredFood + '\'' + '}'+ super.toString();
  }
}
