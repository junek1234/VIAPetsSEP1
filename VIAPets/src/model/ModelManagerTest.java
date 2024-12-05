package model;

import java.io.IOException;

public class ModelManagerTest
{
  public static void main(String[] args) throws IOException
  {
    MyModelManager test1 = new MyModelManager();
    int dogID=MyModelManager.createNextPetID();
    Dog dog = new Dog(dogID,"Bimbo","Brown",2,'m',true,"No","Idk","Idk");

    test1.addPet(dog);
    System.out.println(test1.getAllPets().getPets().getLast().getPetID());
  }
}
