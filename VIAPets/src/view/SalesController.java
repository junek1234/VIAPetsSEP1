package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SalesController
{
  ViewHandler viewHandler = new ViewHandler();
  //This line causes that the second click doesn't work I believe


  @FXML
  public Button addSaleButton;

  @FXML
  public void handleDefault(ActionEvent e) throws IOException
  {
    if (e.getSource() == addSaleButton){
      System.out.println("Add a sale button clicked");
    }

  }

  @FXML
  public void switchScene(ActionEvent e) throws IOException
  {
    viewHandler.switchScene(e);
  }
}