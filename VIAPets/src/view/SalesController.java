package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class SalesController
{
  ViewHandler viewHandler = new ViewHandler();
  @FXML
  private MenuItem petsMenu;

  @FXML
  public void handlelist(ActionEvent e) throws IOException
  {

  }

  @FXML
  public void switchScene(ActionEvent e) throws IOException
  {
    viewHandler.switchScene(e);
  }
}