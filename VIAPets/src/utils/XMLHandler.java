package utils;

import model.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XMLHandler
{

  private static final String PETS = "pets_xml.xml";
  private static final String KENNEL = "kennel_xml.xml";

  VIAPets viaPets = new VIAPets();
  public static void updateXML()
  {
    //kennel info part

    //calculate available slots



    ArrayList<String> kennelInfo=new ArrayList<>();
    kennelInfo.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    kennelInfo.add("<kennel>");
    kennelInfo.add("<availableSlots>"+VIAPets.availableSlots+"</availableSlots>");
    kennelInfo.add("<pricePerHour>"+VIAPets.bookingPrice+"</pricePerHour>");
    kennelInfo.add("</kennel>");

    String[] kennelArray = new String[kennelInfo.size()];
    for (int i = 0; i < kennelInfo.size(); i++)
    {
      kennelArray[i]=kennelInfo.get(i);
    }



    //pets info part
    ArrayList<Pet> pets = VIAPets.allPets.getPets();
    ArrayList<String> xmlLines = new ArrayList<>();
    //im creating one if for Dog and one for Cat because i need to cast it even if those have the same fields
    xmlLines.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    xmlLines.add("<pets>");
    for (int i = 2; i < pets.size()+2; i++)
    {
      xmlLines.add("  <pet>");
      if (pets.get(i-2) instanceof Dog)
      {
        Dog dog = (Dog)pets.get(i-2);
        xmlLines.add("    <id>" + dog.getPetID() + "</id>");
        xmlLines.add("    <type>" + dog.getClass().getSimpleName() + "</type>");
        xmlLines.add("    <name>" + dog.getName() + "</name>");
        xmlLines.add("    <color>" + dog.getColor() + "</color>");
        xmlLines.add("    <age>" + dog.getAge() + "</age>");
        xmlLines.add("    <gender>" + dog.getGender() + "</gender>");
        xmlLines.add("    <location>" + dog.getLocation() + "</location>");
        xmlLines.add("    <status>" + dog.getStatus() + "</status>");
        xmlLines.add("    <breed>" + dog.getBreed() + "</breed>");
        xmlLines.add("    <breederName>" + dog.getBreederName() + "</breederName>");
        xmlLines.add("    <price>" + dog.getBasePrice() + "</price>");
      }

      if (pets.get(i-2) instanceof Cat)
      {
        Cat cat = (Cat)pets.get(i-2);
        xmlLines.add("    <id>" + cat.getPetID() + "</id>");
        xmlLines.add("    <type>" + cat.getClass().getSimpleName() + "</type>");
        xmlLines.add("    <name>" + cat.getName() + "</name>");
        xmlLines.add("    <color>" + cat.getColor() + "</color>");
        xmlLines.add("    <age>" + cat.getAge() + "</age>");
        xmlLines.add("    <gender>" + cat.getGender() + "</gender>");
        xmlLines.add("    <location>" + cat.getLocation() + "</location>");
        xmlLines.add("    <status>" + cat.getStatus() + "</status>");
        xmlLines.add("    <breed>" + cat.getBreed() + "</breed>");
        xmlLines.add("    <breederName>" + cat.getBreederName() + "</breederName>");
        xmlLines.add("    <price>" + cat.getBasePrice() + "</price>");
      }

      if (pets.get(i-2) instanceof Fish)
      {
        Fish fish = (Fish) pets.get(i-2);
        xmlLines.add("    <id>" + fish.getPetID() + "</id>");
        xmlLines.add("    <type>" + fish.getClass().getSimpleName() + "</type>");
        xmlLines.add("    <name>" + fish.getName() + "</name>");
        xmlLines.add("    <color>" + fish.getColor() + "</color>");
        xmlLines.add("    <age>" + fish.getAge() + "</age>");
        xmlLines.add("    <gender>" + fish.getGender() + "</gender>");
        xmlLines.add(              "    <location>" + fish.getLocation() + "</location>");
        xmlLines.add("    <status>" + fish.getStatus() + "</status>");
        xmlLines.add("    <saltwater>" + fish.isSaltwater() + "</saltwater>");
        xmlLines.add("    <species>" + fish.getSpecies() + "</species>");
        xmlLines.add("    <predator>" + fish.isPredator() + "</predator>");
        xmlLines.add("    <price>" + fish.getBasePrice() + "</price>");

      }

      if (pets.get(i-2) instanceof Bird)
      {
        Bird bird = (Bird) pets.get(i-2);
        xmlLines.add("    <id>" + bird.getPetID() + "</id>");
        xmlLines.add("    <type>" + bird.getClass().getSimpleName() + "</type>");
        xmlLines.add("    <name>" + bird.getName() + "</name>");
        xmlLines.add("    <color>" + bird.getColor() + "</color>");
        xmlLines.add("    <age>" + bird.getAge() + "</age>");
        xmlLines.add("    <gender>" + bird.getGender() + "</gender>");
        xmlLines.add(              "    <location>" + bird.getLocation() + "</location>");
        xmlLines.add("    <status>" + bird.getStatus() + "</status>");
        xmlLines.add("    <species>" + bird.getSpecies() + "</species>");
        xmlLines.add("    <preferredFood>" + bird.getPreferredFood() + "</preferredFood>");
        xmlLines.add("    <price>" + bird.getBasePrice() + "</price>");

      }

      if (pets.get(i-2) instanceof Rodent)
      {
        Rodent rodent = (Rodent) pets.get(i-2);
        xmlLines.add("    <id>" + rodent.getPetID() + "</id>");
        xmlLines.add("    <type>" + rodent.getClass().getSimpleName() + "</type>");
        xmlLines.add("    <name>" + rodent.getName() + "</name>");
        xmlLines.add("    <color>" + rodent.getColor() + "</color>");
        xmlLines.add("    <age>" + rodent.getAge() + "</age>");
        xmlLines.add("    <gender>" + rodent.getGender() + "</gender>");
        xmlLines.add(              "    <location>" + rodent.getLocation() + "</location>");
        xmlLines.add("    <status>" + rodent.getStatus() + "</status>");
        xmlLines.add("    <species>" + rodent.getSpecies() + "</species>");
        xmlLines.add("    <price>" + rodent.getBasePrice() + "</price>");

      }

      if (pets.get(i-2) instanceof Various)
      {
        Various various = (Various) pets.get(i-2);
        xmlLines.add("    <id>" + various.getPetID() + "</id>");
        xmlLines.add("    <type>" + various.getClass().getSimpleName() + "</type>");
        xmlLines.add("    <name>" + various.getName() + "</name>");
        xmlLines.add("    <color>" + various.getColor() + "</color>");
        xmlLines.add("    <age>" + various.getAge() + "</age>");
        xmlLines.add("    <gender>" + various.getGender() + "</gender>");
        xmlLines.add(              "    <location>" + various.getLocation() + "</location>");
        xmlLines.add("    <status>" + various.getStatus() + "</status>");
        xmlLines.add("    <species>" + various.getSpecies() + "</species>");
        xmlLines.add("    <price>" + various.getBasePrice() + "</price>");

      }

      xmlLines.add("  </pet>");
    }

    xmlLines.add("</pets>");
    String[] array = new String[xmlLines.size()];
    for (int i = 0; i < xmlLines.size(); i++)
    {
      array[i]=xmlLines.get(i);
    }
    try
    {
      MyFileHandler.writeArrayToTextFile(PETS,array);
      MyFileHandler.writeArrayToTextFile(KENNEL,kennelArray);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      updateXML();
    }


  }
}
