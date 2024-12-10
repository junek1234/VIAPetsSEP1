package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class CustomerController {

  private ViewHandler viewHandler;

  public void setViewHandler(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }

  @FXML
  public void switchScene(ActionEvent e) throws IOException {
    // Use the ViewHandler instance to switch scenes
    viewHandler.switchScene(e);
  }
}
