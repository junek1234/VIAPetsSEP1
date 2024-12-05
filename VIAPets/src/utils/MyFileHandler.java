package utils;

import java.io.*;
import java.util.ArrayList;

public class MyFileHandler {

  // Writes a single string to a text file
  public static void writeToTextFile(String fileName, String str) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
      writer.println(str);
    }
  }

  // Appends a single string to a text file
  public static void appendToTextFile(String fileName, String str) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true))) {
      writer.println(str);
    }
  }

  // Writes an array of strings to a text file
  public static void writeArrayToTextFile(String fileName, String[] strs) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
      for (String str : strs) {
        writer.println(str);
      }
    }
  }

  // Appends an array of strings to a text file
  public static void appendArrayToTextFile(String fileName, String[] strs) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true))) {
      for (String str : strs) {
        writer.println(str);
      }
    }
  }

  // Reads all lines from a text file and returns them as a single string
  public static String readFromTextFile(String fileName) throws FileNotFoundException {
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }
    } catch (IOException e) {
      throw new FileNotFoundException("Error reading file: " + e.getMessage());
    }
    return content.toString().trim();
  }

  // Reads all lines from a text file and returns them as a String array
  public static String[] readArrayFromTextFile(String fileName) throws FileNotFoundException {
    ArrayList<String> lines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        lines.add(line);
      }
    } catch (IOException e) {
      throw new FileNotFoundException("Error reading file: " + e.getMessage());
    }
    return lines.toArray(new String[0]);
  }

  // Writes a single object to a binary file
  public static void writeToBinaryFile(String fileName, Object obj) throws FileNotFoundException, IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
      out.writeObject(obj);
    }
  }

  // Appends a single object to a binary file
  public static void appendToBinaryFile(String fileName, Object obj) throws FileNotFoundException, IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
      out.writeObject(obj);
    }
  }

  // Writes an array of objects to a binary file
  public static void writeArrayToBinaryFile(String fileName, Object[] objs) throws FileNotFoundException, IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
      for (Object obj : objs) {
        out.writeObject(obj);
      }
    }
  }

  // Appends an array of objects to a binary file
  public static void appendArrayToBinaryFile(String fileName, Object[] objs) throws FileNotFoundException, IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName,true))) {
      for (Object obj : objs) {
        out.writeObject(obj);
      }
    }
  }

  // Reads a single object from a binary file
  public static Object readFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
      return in.readObject();
    }
  }

  // Reads an array of objects from a binary file
  public static Object[] readArrayFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
    ArrayList<Object> objects = new ArrayList<>();
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
      while (true) {
        try {
          objects.add(in.readObject());
        } catch (EOFException e) {
          break;
        }
      }
    }
    return objects.toArray(new Object[0]);
  }
}
