package model;

public class Rodent extends Pet
{
  private String species;

  public Rodent(int petID, String name, String color, int age, char gender,
      boolean isInTheShop, String isSold, String species)
  {
    super(petID, name, color, age, gender, isInTheShop, isSold);
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

  public boolean getIsInTheShop()
  {
    return super.isInTheShop;
  }

  public String getIsSold()
  {
    return super.isSold;
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

  public void setIsInTheShop(boolean isInTheShop)
  {
    super.isInTheShop=isInTheShop;
  }

  public void setIsSold(String isSold)
  {
    super.isSold=isSold;
  }

  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
    {
      return false;
    }
    Rodent rodent = (Rodent) obj;
    return super.equals(rodent) && rodent.species.equals(species);

  }

  public String toString()
  {
    return "Rodent{" + "species='" + species + '\'' + '}'+super.toString();
  }
}