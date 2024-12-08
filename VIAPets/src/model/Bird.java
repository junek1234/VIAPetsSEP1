package model;

import java.io.Serializable;

public class Bird extends Pet implements Serializable
{
 private String species;
 private String preferredFood;

  public Bird(int petID, String name, String color, int age, char gender,
      String location, String status, String species, String preferredFood)
  {
    super(petID, name, color, age, gender, location, status);
    this.species = species;
    this.preferredFood = preferredFood;
  }

  public String getSpecies()
  {
    return species;
  }

  public void setSpecies(String species)
  {
    this.species = species;
  }

  public String getPreferredFood()
  {
    return preferredFood;
  }

  public void setPreferredFood(String preferredFood)
  {
    this.preferredFood = preferredFood;
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
    return status;
  }

  public String getStaus()
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
    Bird bird = (Bird) obj;
    return super.equals(bird) && bird.species.equals(species) && bird.preferredFood.equals(preferredFood);

  }

  public String toString()
  {
    return "Bird{" + "species='" + species + '\'' + ", preferredFood='"
        + preferredFood + '\'' + '}'+super.toString();
  }
}
