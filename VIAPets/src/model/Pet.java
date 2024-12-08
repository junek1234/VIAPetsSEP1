package model;

import java.io.Serializable;

/**
 * Represents an abstract Pet with common attributes and behaviors
 * that can be extended by specific pet types such as Fish, Dog, etc.
 * Implements Serializable for object persistence.
 *
 * @author Guillermo
 * @version 1.0
 */
public abstract class Pet implements Serializable
{
  protected int petID;
  protected String name;
  protected String color;
  protected int age;
  protected char gender; // 'M' for male, 'F' for female
  protected String comment;
  protected boolean isInTheShop;
  protected String isSold;

  /**
   * Constructs a Pet object with the specified attributes.
   *
   * @param petID       The unique identifier of the pet.
   * @param name        The name of the pet.
   * @param color       The color of the pet.
   * @param age         The age of the pet.
   * @param gender      The gender of the pet ('M' or 'F').
   * @param isInTheShop Indicates if the pet is available in the shop.
   * @param isSold      Indicates the sale status of the pet.
   */
  public Pet(int petID, String name, String color, int age, char gender, boolean isInTheShop, String isSold)
  {
    this.petID = petID;
    this.name = name;
    this.color = color;
    this.age = age;
    this.gender = gender;
    this.isInTheShop = isInTheShop;
    this.isSold = isSold;
  }

  // Abstract methods to enforce implementation in subclasses.

  /**
   * Gets the unique identifier of the pet.
   *
   * @return The pet ID.
   */
  public abstract int getPetID();

  /**
   * Gets the name of the pet.
   *
   * @return The name of the pet.
   */
  public abstract String getName();

  /**
   * Gets the age of the pet.
   *
   * @return The age of the pet.
   */
  public abstract int getAge();

  /**
   * Gets the gender of the pet.
   *
   * @return The gender of the pet ('M' for male, 'F' for female).
   */
  public abstract char getGender();

  /**
   * Gets additional comments about the pet.
   *
   * @return Comments about the pet.
   */
  public abstract String getComment();

  /**
   * Checks if the pet is available in the shop.
   *
   * @return {@code true} if the pet is in the shop, otherwise {@code false}.
   */
  public abstract boolean getIsInTheShop();

  /**
   * Gets the sale status of the pet.
   *
   * @return The sale status of the pet.
   */
  public abstract String getIsSold();

  // Abstract setters for attributes.

  public abstract void setPetID(int petID);
  public abstract void setName(String name);
  public abstract void setAge(int age);
  public abstract void setGender(char gender);
  public abstract void setComment(String comment);
  public abstract void setIsInTheShop(boolean isInTheShop);
  public abstract void setIsSold(String isSold);

  /**
   * Compares this Pet object to another object for equality.
   *
   * @param obj The object to compare with.
   * @return {@code true} if the objects are equal, otherwise {@code false}.
   */
  @Override
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }

    Pet pet = (Pet) obj;
    return pet.petID == petID &&
        pet.name.equals(name) &&
        pet.color.equals(color) &&
        pet.age == age &&
        pet.gender == gender &&
        pet.comment.equals(comment) &&
        pet.isInTheShop == isInTheShop &&
        pet.isSold.equals(isSold);
  }

  /**
   * Returns a string representation of the Pet.
   *
   * @return A string representation of the Pet.
   */
  @Override
  public String toString()
  {
    return "Pet{" +
        "petID=" + petID +
        ", name='" + name + '\'' +
        ", color='" + color + '\'' +
        ", age=" + age +
        ", gender=" + gender +
        ", comment='" + comment + '\'' +
        ", isInTheShop=" + isInTheShop +
        ", isSold='" + isSold + '\'' +
        '}';
  }
}
