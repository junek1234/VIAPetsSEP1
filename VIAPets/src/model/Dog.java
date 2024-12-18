package model;

import java.io.Serializable;

/**
 * Class representing a Dog, extending the Pet class.
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Piotr Junosz
 * @version 1.0
 */
public class Dog extends Pet implements Serializable {

  /** The breed of the dog. */
  private String breed;

  /** The name of the breeder of the dog. */
  private String breederName;

  /**
   * Constructs a new Dog with the specified attributes.
   *
   * @param petID the unique identifier for the dog.
   * @param name the name of the dog.
   * @param color the color of the dog.
   * @param age the age of the dog.
   * @param gender the gender of the dog.
   * @param location the location of the dog.
   * @param status the status of the dog.
   * @param breed the breed of the dog.
   * @param breederName the name of the breeder of the dog.
   * @param basePrice the base price of the dog.
   * @param comment additional comments about the dog.
   */
  public Dog(int petID, String name, String color, int age, char gender,
      String location, String status, String breed, String breederName, double basePrice, String comment) {
    super(petID, name, color, age, gender, location, status, basePrice, comment);
    this.breed = breed;
    this.breederName = breederName;
  }

  /**
   * Gets the breed of the dog.
   *
   * @return the breed of the dog.
   */
  public String getBreed() {
    return breed;
  }

  /**
   * Sets the breed of the dog.
   *
   * @param breed the new breed of the dog.
   */
  public void setBreed(String breed) {
    this.breed = breed;
  }

  /**
   * Gets the name of the breeder of the dog.
   *
   * @return the name of the breeder.
   */
  public String getBreederName() {
    return breederName;
  }

  /**
   * Sets the name of the breeder of the dog.
   *
   * @param breederName the new name of the breeder.
   */
  public void setBreederName(String breederName) {
    this.breederName = breederName;
  }

  /**
   * Gets the pet ID of the dog.
   *
   * @return the pet ID.
   */
  public int getPetID() {
    return super.petID;
  }

  /**
   * Gets the name of the dog.
   *
   * @return the name of the dog.
   */
  public String getName() {
    return super.name;
  }

  /**
   * Gets the color of the dog.
   *
   * @return the color of the dog.
   */
  public String getColor() {
    return super.color;
  }

  /**
   * Gets the age of the dog.
   *
   * @return the age of the dog.
   */
  public int getAge() {
    return super.age;
  }

  /**
   * Gets the gender of the dog.
   *
   * @return the gender of the dog.
   */
  public char getGender() {
    return super.gender;
  }

  /**
   * Gets additional comments about the dog.
   *
   * @return comments about the dog.
   */
  public String getComment() {
    return super.comment;
  }

  /**
   * Gets the location of the dog.
   *
   * @return the location of the dog.
   */
  public String getLocation() {
    return super.location;
  }

  /**
   * Gets the status of the dog.
   *
   * @return the status of the dog.
   */
  public String getStatus() {
    return super.status;
  }

  /**
   * Sets the pet ID of the dog.
   *
   * @param petID the new pet ID.
   */
  public void setPetID(int petID) {
    super.petID = petID;
  }

  /**
   * Sets the name of the dog.
   *
   * @param name the new name of the dog.
   */
  public void setName(String name) {
    super.name = name;
  }

  /**
   * Sets the age of the dog.
   *
   * @param age the new age of the dog.
   */
  public void setAge(int age) {
    super.age = age;
  }

  /**
   * Sets the gender of the dog.
   *
   * @param gender the new gender of the dog.
   */
  public void setGender(char gender) {
    super.gender = gender;
  }

  /**
   * Sets additional comments about the dog.
   *
   * @param comment the new comments about the dog.
   */
  public void setComment(String comment) {
    super.comment = comment;
  }

  /**
   * Sets the location of the dog.
   *
   * @param location the new location of the dog.
   */
  public void setLocation(String location) {
    super.location = location;
  }

  /**
   * Sets the status of the dog.
   *
   * @param status the new status of the dog.
   */
  public void setStatus(String status) {
    super.status = status;
  }

  /**
   * Compares this dog to another object for equality.
   *
   * @param obj the object to compare.
   * @return true if the objects are equal; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()) {
      return false;
    }
    Dog dog = (Dog) obj;
    return super.equals(dog) && dog.breed.equals(breed) && dog.breederName.equals(breederName);
  }

  /**
   * Returns a string representation of the dog.
   *
   * @return a string describing the dog.
   */
  @Override
  public String toString() {
    return "Dog{" + "breed='" + breed + '\'' + ", breederName='" + breederName
        + '\'' + '}' + super.toString();
  }
}
