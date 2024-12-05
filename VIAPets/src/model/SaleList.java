package model;

import java.util.ArrayList;

public class SaleList
{
  private ArrayList<Sale> saleList;

  public SaleList()
  {
    saleList = new ArrayList<>();
  }

  public Sale getSaleByID(int id)
  {
    return saleList.get(id);
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

  public void editSale()
  {
    //something here we need to discuss
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
