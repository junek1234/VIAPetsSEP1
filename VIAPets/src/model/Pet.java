package model;

import java.io.Serializable;

public abstract class Pet implements Serializable
{
  protected int petID;
  protected String name;
  protected String color;
  protected int age;
  protected char gender;
  protected String comment;
  protected String location;
  protected String status;

  public Pet(int petID, String name, String color, int age, char gender, String location, String status)
  {
    this.petID = petID;
    this.name = name;
    this.color = color;
    this.age = age;
    this.gender = gender;
    this.location = location;
    this.status = status;
  }

  public abstract int getPetID();
  public abstract String getName();
  public abstract String getColor();
  public abstract int getAge();
  public abstract char getGender();
  public abstract String getComment();
  public abstract boolean getLocation();
  public abstract String getStatus();

  public abstract void setPetID(int petID);
  public abstract void setName(String name);
  public abstract void setAge(int age);
  public abstract void setGender(char gender);
  public abstract void setComment(String comment);
  public abstract void setLocation(boolean isInTheShop);
  public abstract void setStatus(String status);

  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
    {
      return false;
    }

    Pet pet = (Pet) obj;
    return pet.petID==petID && pet.name.equals(name) && pet.color.equals(color) && pet.age==age
        && pet.gender==gender && pet.comment.equals(comment) && pet.location==location && pet.status.equals(status);
  }

  public String toString()
  {
    return "Pet{" + "petID=" + petID + ", name='" + name + '\'' + ", color='"
        + color + '\'' + ", age=" + age + ", gender=" + gender + ", comment='"
        + comment + '\'' + ", Location=" + location + ", Status='"
        + status + '\'' + '}';
  }
}
