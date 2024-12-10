package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SalesController {

  @FXML
  private Button addSaleButton;

  private ViewHandler viewHandler;  // Reference to ViewHandler

  public void setViewHandler(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }

  @FXML
  public void handleDefault(ActionEvent e) {
    // Example usage of ViewHandler
    if (e.getSource() == addSaleButton) {
      System.out.println("Add Sale button clicked!");
    }
  }

  @FXML
  public void switchScene(ActionEvent e) {
    try {
      viewHandler.switchScene(e); // Use the ViewHandler to switch scenes
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}