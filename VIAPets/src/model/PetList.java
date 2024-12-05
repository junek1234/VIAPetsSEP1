package model;

import java.util.ArrayList;

public class PetList
{
  private ArrayList<Pet> pets;
  public PetList()
  {
    pets = new ArrayList<>();
  }
  public void add(Pet pet)
  {
    pets.add(pet);
  }

  //to be done
//  public void editPet(int id, Pet newPet)
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
  //get pets
  //change in Astah

  public ArrayList<Pet> getPets()
  {
    return pets;
  }

  public String toString()
  {
    return "PetList{" + "pets=" + pets.toString() + '}';
  }
}
