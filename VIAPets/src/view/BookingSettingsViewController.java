package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MyModelManager;
import model.VIAPets;

/**
 * Controller class for managing booking settings in the application.
 * Provides functionality to view and update the maximum kennel slots and booking price per hour.
 *
 * @version 1.0
 * @author Piotr Junosz
 * @author Guillermo Sánchez Martínez
 */
public class BookingSettingsViewController
{
  @FXML public TextField maxKennelSlotsTextField;
  @FXML public TextField pricePerHourTextField;

  /**
   * Initializes the booking settings view with current settings.
   * Displays the current booking price per hour and maximum kennel slots.
   */
  public void initialize()
  {
    pricePerHourTextField.setText(VIAPets.bookingPrice+"");
    maxKennelSlotsTextField.setText(VIAPets.maxKennelSlots+"");
  }
  /**
   * Saves the updated booking settings.
   * Validates the input fields and updates the settings for maximum kennel slots
   * and booking price per hour.
   *
   * @param actionEvent the event triggered by the save button
   */
  public void saveBookingsSettings(ActionEvent actionEvent)
  {

    if(pricePerHourTextField.getText().isEmpty()||maxKennelSlotsTextField.getText().isEmpty()){
      Alert alert1 = new Alert(Alert.AlertType.ERROR);
      alert1.setTitle("Error");
      alert1.setHeaderText(null);
      alert1.setContentText("Input cannot be blank!");
      alert1.show();
    }
    else {
      try
      {
        MyModelManager manager = new MyModelManager();
        manager.saveBookingsSettings(Integer.parseInt(maxKennelSlotsTextField.getText()),Double.parseDouble(pricePerHourTextField.getText()));
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene()
            .getWindow();
        stage.close();
      }
      catch (NumberFormatException e)
      {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("All inputs must be numbers!");
        alert1.show();
      }
    }

  }
}
