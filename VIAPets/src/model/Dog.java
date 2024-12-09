package model;

import java.io.Serializable;

public class Dog extends Pet implements Serializable
{
  private String breed;
  private String breederName;

  public Dog(int petID, String name, String color, int age, char gender,
      String location, String status, String breed, String breederName, double basePrice, String comment)
  {
    super(petID, name, color, age, gender, location, status, basePrice, comment);
    this.breed = breed;
    this.breederName = breederName;
  }

  public String getBreed()
  {
    return breed;
  }

  public void setBreed(String breed)
  {
    this.breed = breed;
  }

  public String getBreederName()
  {
    return breederName;
  }

  public void setBreederName(String breederName)
  {
    this.breederName = breederName;
  }

  public int getPetID()
  {
    return super.petID;
  }

  public String getName()
  {
    return super.name;
  }

  public String getColor()
  {
    return super.color;
  }

  public int getAge()
  {
    return super.age;
  }

  public char getGender()
  {
    return super.gender;
  }

  public String getComment()
  {
    return super.comment;
  }

  public String getLocation()
  {
    return super.location;
  }

  public String getStatus()
  {
    return super.status;
  }

  public void setPetID(int petID)
  {
    super.petID=petID;
  }

  public void setName(String name)
  {
  super.name=name;
  }

  public void setAge(int age)
  {
    super.age=age;
  }

  public void setGender(char gender)
  {
    super.gender=gender;
  }

  public void setComment(String comment)
  {
    super.comment=comment;
  }

  public void setLocation(String location)
  {
    super.location=location;
  }

  public void setStatus(String status)
  {
    super.status=status;
  }

  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
    {
      return false;
    }
    Dog dog = (Dog) obj;
    return super.equals(dog) && dog.breed.equals(breed) && dog.breederName.equals(breederName);

  }

  public String toString()
  {
    return "Dog{" + "breed='" + breed + '\'' + ", breederName='" + breederName
        + '\'' + '}'+ super.toString();
  }
}
