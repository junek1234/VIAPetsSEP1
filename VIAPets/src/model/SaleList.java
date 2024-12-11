package model;

import java.io.Serializable;
import java.util.ArrayList;

public class SaleList implements Serializable
{
  private ArrayList<Sale> saleList;

  public SaleList()
  {
    saleList = new ArrayList<>();
  }

  //change in Astah
  public SaleList(ArrayList<Sale> saleList)
  {
    this.saleList = saleList;
  }

  public Sale getSaleByID(int saleID)
  {
    for (Sale sale : saleList) {
      if (sale.getSaleID() == saleID) {
        return sale;
      }
    }
    return null;
  }

  //get sales
  //change in Astah

  public ArrayList<Sale> getSaleList()
  {
    return saleList;
  }

  public void addSale(Sale sale)
  {
    saleList.add(sale);
  }

  // Edit an existing Sale (replacing old Sale object with a new one changed in the Controller)
  public void editSale(int saleID, Sale newSale)
  {
    int index = saleList.indexOf(getSaleByID(saleID));
    saleList.set(index,newSale);
  }

  public void removeSale(Sale sale)
  {
    saleList.remove(sale);
  }

  @Override public String toString()
  {
    String returnText = "";
    for (int i = 0; i < saleList.size(); i++)
    {
      returnText +=
          "Sale " + (i + 1) + " = " + saleList.get(i) + (i < (saleList.size() - 1) ? " , " : ".");
    }
    return returnText;
  }
}
