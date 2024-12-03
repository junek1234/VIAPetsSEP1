public class Fish extends Pet
{
  private boolean saltwater;
  private String species;
  private boolean predator;

  public Fish(int petID, String name, String color, int age, char gender,
      boolean isInTheShop, String isSold, boolean saltwater, String species,
      boolean predator)
  {
    super(petID, name, color, age, gender, isInTheShop, isSold);
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
    Fish fish = (Fish) obj;
    return super.equals(fish) && fish.saltwater==saltwater && fish.species.equals(species) && fish.predator==predator;

  }

  public String toString()
  {
    return "Fish{" + "saltwater=" + saltwater + ", species='" + species + '\''
        + ", predator=" + predator + '}'+super.toString();
  }
}
