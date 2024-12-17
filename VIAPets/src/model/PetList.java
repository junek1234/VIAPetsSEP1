package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PetList implements Serializable
{
  private ArrayList<Pet> pets;
  public PetList()
  {
    pets = new ArrayList<>();
  }
  //change in Astah
  public PetList(ArrayList<Pet> pets)
  {
    this.pets = pets;
  }
  public void addPet(Pet pet)
  {
    pets.add(pet);
  }

  // Edit an existing Pet (replacing old Pet object with a new one changed in the Controller)
  public void editPet(int petID, Pet newPet)
  {
    int index = pets.indexOf(getPetByID(petID));
    pets.set(index,newPet);
  }
  public void removePet(Pet pet)
  {
    pets.remove(pet);
  }
  public Pet getPetByID(int petID) //change and think about this in Astah
  {
    for (int i = 0; i < getPets().size(); i++)
    {
      if (getPets().get(i).getPetID()==petID)
      {
        return getPets().get(i);
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
