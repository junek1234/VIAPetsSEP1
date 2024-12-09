package model;

import java.io.Serializable;

public class Various extends Pet implements Serializable
{
  private String species;

  public Various(int petID, String name, String color, int age, char gender,
      String location, String status, String species, double basePrice)
  {
    super(petID, name, color, age, gender, location, status, basePrice);
    this.species = species;
  }

  public String getSpecies()
  {
    return species;
  }

  public void setSpecies(String species)
  {
    this.species = species;
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
    Various various = (Various) obj;
    return super.equals(various) && various.species.equals(species);

  }
}
