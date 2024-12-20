package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The SaleList class represents a collection of sales. It provides methods to retrieve,
 * add, edit, and remove Sale objects from the list.
 * This class implements the Serializable interface for object serialization.
 *
 * @author Guillermo Sánchez Martínez
 * @version 1.0
 */
public class SaleList implements Serializable {
  private ArrayList<Sale> saleList;

  /**
   * Constructs an empty SaleList object.
   * Initializes an empty ArrayList to store Sale objects.
   */
  public SaleList() {
    saleList = new ArrayList<>();
  }

  /**
   * Constructs a SaleList object with a given list of Sale objects.
   *
   * @param saleList the list of Sales to initialize the SaleList with
   */
  public SaleList(ArrayList<Sale> saleList) {
    this.saleList = saleList;
  }

  /**
   * Gets a Sale by its unique sale ID.
   *
   * @param saleID the unique ID of the sale
   * @return the Sale object with the matching saleID, or null if no sale with the given ID is found
   */
  public Sale getSaleByID(int saleID) {
    for (Sale sale : saleList) {
      if (sale.getSaleID() == saleID) {
        return sale;
      }
    }
    return null;
  }

  /**
   * Gets the list of all sales in the SaleList.
   *
   * @return the list of Sale objects in the SaleList
   */
  public ArrayList<Sale> getSaleList() {
    return saleList;
  }

  /**
   * Adds a new Sale to the SaleList.
   *
   * @param sale the Sale object to add to the list
   */
  public void addSale(Sale sale) {
    saleList.add(sale);
  }

  /**
   * Edits an existing Sale in the SaleList by replacing it with a new Sale object.
   *
   * @param saleID the ID of the Sale to edit
   * @param newSale the new Sale object to replace the old one
   */
  public void editSale(int saleID, Sale newSale) {
    int index = saleList.indexOf(getSaleByID(saleID));
    saleList.set(index, newSale);
  }

  /**
   * Removes a Sale from the SaleList.
   *
   * @param sale the Sale object to remove
   */
  public void removeSale(Sale sale) {
    saleList.remove(sale);
  }

  /**
   * Returns a string representation of all Sales in the SaleList.
   *
   * @return a string representation of all Sale objects in the SaleList
   */
  @Override
  public String toString() {
    String returnText = "";
    for (int i = 0; i < saleList.size(); i++) {
      returnText += "Sale " + (i + 1) + " = " + saleList.get(i) + (i < (saleList.size() - 1) ? " , " : ".");
    }
    return returnText;
  }
}
