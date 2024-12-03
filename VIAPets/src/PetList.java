import java.util.ArrayList;

public class PetList
{
  private ArrayList<Pet> pets; //fix pet -> pets in Astah
  //add constructor in Astah
  public PetList()
  {
    pets = new ArrayList<>();
  }
  public void add(Pet pet)//change name in Astah
  {
    pets.add(pet);
  }
//  public void edit(Pet pet) ???
//  {
//
//  }
  public void remove(Pet pet)
  {
    pets.remove(pet);
  }
  public Pet getPetByID(int petID) //change and think about this in Astah
  {
    for (int i = 0; i < pets.size(); i++)
    {
      if (pets.get(i).petID==petID)
      {
        return pets.get(i);
      }

    }
    return null;
  }
//  public void setPet() == edit ???

  public String toString()
  {
    return "PetList{" + "pets=" + pets.toString() + '}';
  }
}
