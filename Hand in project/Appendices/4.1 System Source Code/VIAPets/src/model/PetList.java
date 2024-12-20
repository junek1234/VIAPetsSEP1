package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a list of pets. Provides methods to add, edit, remove, and retrieve pets.
 * This class implements {@link Serializable} to allow instances to be serialized.
 *
 * @author Piotr Junosz
 * @version 1.0
 */
public class PetList implements Serializable {

  /**
   * List of pets managed by this class.
   */
  private ArrayList<Pet> pets;

  /**
   * Constructs an empty PetList.
   */
  public PetList() {
    pets = new ArrayList<>();
  }

  /**
   * Constructs a PetList with the given list of pets.
   *
   * @param pets the initial list of pets
   */
  public PetList(ArrayList<Pet> pets) {
    this.pets = pets;
  }

  /**
   * Adds a pet to the list.
   *
   * @param pet the pet to be added
   */
  public void addPet(Pet pet) {
    pets.add(pet);
  }

  /**
   * Edits an existing pet by replacing it with a new pet object.
   *
   * @param petID the ID of the pet to be replaced
   * @param newPet the new pet object to replace the old one
   */
  public void editPet(int petID, Pet newPet) {
    int index = pets.indexOf(getPetByID(petID));
    pets.set(index, newPet);
  }

  /**
   * Removes a pet from the list.
   *
   * @param pet the pet to be removed
   */
  public void removePet(Pet pet) {
    pets.remove(pet);
  }

  /**
   * Retrieves a pet by its ID.
   *
   * @param petID the ID of the pet to be retrieved
   * @return the pet with the specified ID, or null if not found
   */
  public Pet getPetByID(int petID) {
    for (int i = 0; i < getPets().size(); i++) {
      if (getPets().get(i).getPetID() == petID) {
        return getPets().get(i);
      }
    }
    return null;
  }

  /**
   * Returns the list of pets.
   *
   * @return the list of pets
   */
  public ArrayList<Pet> getPets() {
    return pets;
  }

  /**
   * Returns a string representation of the PetList.
   *
   * @return a string representation of the PetList
   */
  @Override
  public String toString() {
    return "PetList{" + "pets=" + pets.toString() + '}';
  }
}
