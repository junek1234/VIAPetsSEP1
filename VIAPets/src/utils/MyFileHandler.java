package utils;

import java.io.*;
import java.util.ArrayList;

/**
 * Utility class for handling file operations including reading and writing text files
 * and binary files.
 *
 * @author Felipe Figueiredo
 * @version 1.0
 */
public class MyFileHandler {

  /**
   * Writes a single string to a text file.
   *
   * @param fileName the name of the file to write to.
   * @param str the string to write to the file.
   * @throws FileNotFoundException if the file cannot be found or opened.
   */
  public static void writeToTextFile(String fileName, String str) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
      writer.println(str);
    }
  }

  /**
   * Appends a single string to a text file.
   *
   * @param fileName the name of the file to append to.
   * @param str the string to append to the file.
   * @throws FileNotFoundException if the file cannot be found or opened.
   */
  public static void appendToTextFile(String fileName, String str) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true))) {
      writer.println(str);
    }
  }

  /**
   * Writes an array of strings to a text file.
   *
   * @param fileName the name of the file to write to.
   * @param strs the array of strings to write to the file.
   * @throws FileNotFoundException if the file cannot be found or opened.
   */
  public static void writeArrayToTextFile(String fileName, String[] strs) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
      for (String str : strs) {
        writer.println(str);
      }
    }
  }

  /**
   * Appends an array of strings to a text file.
   *
   * @param fileName the name of the file to append to.
   * @param strs the array of strings to append to the file.
   * @throws FileNotFoundException if the file cannot be found or opened.
   */
  public static void appendArrayToTextFile(String fileName, String[] strs) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true))) {
      for (String str : strs) {
        writer.println(str);
      }
    }
  }

  /**
   * Reads all lines from a text file and returns them as a single string.
   *
   * @param fileName the name of the file to read from.
   * @return the content of the file as a single string.
   * @throws FileNotFoundException if the file cannot be found or opened.
   */
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

  /**
   * Reads all lines from a text file and returns them as a String array.
   *
   * @param fileName the name of the file to read from.
   * @return an array of strings representing the lines of the file.
   * @throws FileNotFoundException if the file cannot be found or opened.
   */
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

  /**
   * Writes a single object to a binary file.
   *
   * @param fileName the name of the file to write to.
   * @param obj the object to write to the file.
   * @throws FileNotFoundException if the file cannot be found or opened.
   * @throws IOException if an I/O error occurs during writing.
   */
  public static void writeToBinaryFile(String fileName, Object obj) throws FileNotFoundException, IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
      out.writeObject(obj);
    }
  }

  /**
   * Writes an array of objects to a binary file.
   *
   * @param fileName the name of the file to write to.
   * @param objs the array of objects to write to the file.
   * @throws FileNotFoundException if the file cannot be found or opened.
   * @throws IOException if an I/O error occurs during writing.
   */
  public static void writeArrayToBinaryFile(String fileName, Object[] objs) throws FileNotFoundException, IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
      for (Object obj : objs) {
        out.writeObject(obj);
      }
    }
  }

  /**
   * Reads a single object from a binary file.
   *
   * @param fileName the name of the file to read from.
   * @return the object read from the file.
   * @throws FileNotFoundException if the file cannot be found or opened.
   * @throws IOException if an I/O error occurs during reading.
   * @throws ClassNotFoundException if the class of the serialized object cannot be found.
   */
  public static Object readFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
      return in.readObject();
    }
  }

  /**
   * Reads an array of objects from a binary file.
   *
   * @param fileName the name of the file to read from.
   * @return an array of objects read from the file.
   * @throws FileNotFoundException if the file cannot be found or opened.
   * @throws IOException if an I/O error occurs during reading.
   * @throws ClassNotFoundException if the class of a serialized object cannot be found.
   */
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
