package model;

import java.io.IOException;
import java.util.ArrayList;

public class ModelManagerTest
{
  public static void main(String[] args) throws IOException
  {
    MyModelManager test1 = new MyModelManager();
    VIAPets viaPets = new VIAPets(1,2);
    int dogID=MyModelManager.createNextPetID();
    Dog dog = new Dog(dogID,"Bimbo","Brown",2,'m',true,"No","Idk","Idk");
    int catID=MyModelManager.createNextPetID();
    Cat cat = new Cat(catID,"BLALA","Brown",2,'m',true,"No","Idk","Idk");

    test1.addPet(dog);
    test1.addPet(cat);
   System.out.println(test1.getAllPets().getPets().size());
    ArrayList<Pet> testArrayList = test1.getAllPets().getPets();
    System.out.println(testArrayList);

  }
}
