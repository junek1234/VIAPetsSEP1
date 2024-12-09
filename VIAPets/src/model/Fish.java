package model;

import java.io.Serializable;

public class Fish extends Pet implements Serializable
{
  private boolean saltwater;
  private String species;
  private boolean predator;

  public Fish(int petID, String name, String color, int age, char gender,
      String location, String status, boolean saltwater, String species,
      boolean predator, double basePrice)
  {
    super(petID, name, color, age, gender, location, status, basePrice);
    this.saltwater = saltwater;
    this.species = species;
    this.predator = predator;
  }

  public boolean isSaltwater()
  {
    return saltwater;
  }

  public void setSaltwater(boolean saltwater)
  {
    this.saltwater = saltwater;
  }

  public String getSpecies()
  {
    return species;
  }

  public void setSpecies(String species)
  {
    this.species = species;
  }

  public boolean isPredator()
  {
    return predator;
  }

  public void setPredator(boolean predator)
  {
    this.predator = predator;
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
    Fish fish = (Fish) obj;
    return super.equals(fish) && fish.saltwater==saltwater && fish.species.equals(species) && fish.predator==predator;

  }

  public String toString()
  {
    return "Fish{" + "saltwater=" + saltwater + ", species='" + species + '\''
        + ", predator=" + predator + '}'+super.toString();
  }
}
