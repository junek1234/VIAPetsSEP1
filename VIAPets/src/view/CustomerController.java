package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CustomerController
{  ViewHandler viewHandler = new ViewHandler(); //This line causes that the
  // second click doesn't work I believe


  @FXML
  public void switchScene(ActionEvent e) throws IOException
  {
    viewHandler.switchScene(e);
  }
}