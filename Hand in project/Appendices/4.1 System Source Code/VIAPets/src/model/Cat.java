package model;

import java.io.Serializable;

/**
 * Class representing a Cat, extending the Pet class.
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Piotr Junosz
 * @version 1.0
 */
public class Cat extends Pet implements Serializable {

  /** The breed of the cat. */
  private String breed;

  /** The name of the breeder of the cat. */
  private String breederName;

  /**
   * Constructs a new Cat with the specified attributes.
   *
   * @param petID the unique identifier for the cat.
   * @param name the name of the cat.
   * @param color the color of the cat.
   * @param age the age of the cat.
   * @param gender the gender of the cat.
   * @param location the location of the cat.
   * @param status the status of the cat.
   * @param breed the breed of the cat.
   * @param breederName the name of the breeder of the cat.
   * @param basePrice the base price of the cat.
   * @param comment additional comments about the cat.
   */
  public Cat(int petID, String name, String color, int age, char gender,
      String location, String status, String breed, String breederName, double basePrice, String comment) {
    super(petID, name, color, age, gender, location, status, basePrice, comment);
    this.breed = breed;
    this.breederName = breederName;
  }

  /**
   * Gets the breed of the cat.
   *
   * @return the breed of the cat.
   */
  public String getBreed() {
    return breed;
  }

  /**
   * Sets the breed of the cat.
   *
   * @param breed the new breed of the cat.
   */
  public void setBreed(String breed) {
    this.breed = breed;
  }

  /**
   * Gets the name of the breeder of the cat.
   *
   * @return the name of the breeder.
   */
  public String getBreederName() {
    return breederName;
  }

  /**
   * Sets the name of the breeder of the cat.
   *
   * @param breederName the new name of the breeder.
   */
  public void setBreederName(String breederName) {
    this.breederName = breederName;
  }

  /**
   * Gets the pet ID of the cat.
   *
   * @return the pet ID.
   */
  public int getPetID() {
    return super.petID;
  }

  /**
   * Gets the name of the cat.
   *
   * @return the name of the cat.
   */
  public String getName() {
    return super.name;
  }

  /**
   * Gets the color of the cat.
   *
   * @return the color of the cat.
   */
  public String getColor() {
    return super.color;
  }

  /**
   * Gets the age of the cat.
   *
   * @return the age of the cat.
   */
  public int getAge() {
    return super.age;
  }

  /**
   * Gets the gender of the cat.
   *
   * @return the gender of the cat.
   */
  public char getGender() {
    return super.gender;
  }

  /**
   * Gets additional comments about the cat.
   *
   * @return comments about the cat.
   */
  public String getComment() {
    return super.comment;
  }

  /**
   * Gets the location of the cat.
   *
   * @return the location of the cat.
   */
  public String getLocation() {
    return super.location;
  }

  /**
   * Gets the status of the cat.
   *
   * @return the status of the cat.
   */
  public String getStatus() {
    return super.status;
  }

  /**
   * Sets the pet ID of the cat.
   *
   * @param petID the new pet ID.
   */
  public void setPetID(int petID) {
    super.petID = petID;
  }

  /**
   * Sets the name of the cat.
   *
   * @param name the new name of the cat.
   */
  public void setName(String name) {
    super.name = name;
  }

  /**
   * Sets the age of the cat.
   *
   * @param age the new age of the cat.
   */
  public void setAge(int age) {
    super.age = age;
  }

  /**
   * Sets the gender of the cat.
   *
   * @param gender the new gender of the cat.
   */
  public void setGender(char gender) {
    super.gender = gender;
  }

  /**
   * Sets additional comments about the cat.
   *
   * @param comment the new comments about the cat.
   */
  public void setComment(String comment) {
    super.comment = comment;
  }

  /**
   * Sets the location of the cat.
   *
   * @param location the new location of the cat.
   */
  public void setLocation(String location) {
    super.location = location;
  }

  /**
   * Sets the status of the cat.
   *
   * @param status the new status of the cat.
   */
  public void setStatus(String status) {
    super.status = status;
  }

  /**
   * Compares this cat to another object for equality.
   *
   * @param obj the object to compare.
   * @return true if the objects are equal; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()) {
      return false;
    }
    Cat cat = (Cat) obj;
    return super.equals(cat) && cat.breed.equals(breed) && cat.breederName.equals(breederName);
  }

  /**
   * Returns a string representation of the cat.
   *
   * @return a string describing the cat.
   */
  @Override
  public String toString() {
    return "Cat{" + "breed='" + breed + '\'' + ", breederName='" + breederName
        + '\'' + '}' + super.toString();
  }
}
