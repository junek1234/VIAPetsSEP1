package model;

public class Dog extends Pet
{
  private String breed;
  private String breederName;

  public Dog(int petID, String name, String color, int age, char gender,
      boolean isInTheShop, String isSold, String breed, String breederName)
  {
    super(petID, name, color, age, gender, isInTheShop, isSold);
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
    Dog dog = (Dog) obj;
    return super.equals(dog) && dog.breed.equals(breed) && dog.breederName.equals(breederName);

  }

  public String toString()
  {
    return "Dog{" + "breed='" + breed + '\'' + ", breederName='" + breederName
        + '\'' + '}'+ super.toString();
  }
}
