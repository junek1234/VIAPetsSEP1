public abstract class Pet
{
  protected int petID;
  protected String name;
  protected String color;
  protected int age;
  protected char gender;
  protected String comment;
  protected boolean isInTheShop;
  protected String isSold;


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

  public abstract int getPetID();
  public abstract String getName();
  public abstract int getAge();
  public abstract char getGender();
  public abstract String getComment();
  public abstract boolean getIsInTheShop();
  public abstract String getIsSold();

  public abstract void setPetID(int petID);
  public abstract void setName(String name);
  public abstract void setAge(int age);
  public abstract void setGender(char gender);
  public abstract void setComment(String comment);
  public abstract void setIsInTheShop(boolean isInTheShop);
  public abstract void setIsSold(String isSold);

  public boolean equals(Object obj)
  {
    if(obj==null || obj.getClass()!=getClass())
    {
      return false;
    }

    Pet pet = (Pet) obj;
    return pet.petID==petID && pet.name.equals(name) && pet.color.equals(color) && pet.age==age
        && pet.gender==gender && pet.comment.equals(comment) && pet.isInTheShop==isInTheShop && pet.isSold.equals(isSold);
  }

  public String toString()
  {
    return "Pet{" + "petID=" + petID + ", name='" + name + '\'' + ", color='"
        + color + '\'' + ", age=" + age + ", gender=" + gender + ", comment='"
        + comment + '\'' + ", isInTheShop=" + isInTheShop + ", isSold='"
        + isSold + '\'' + '}';
  }
}
