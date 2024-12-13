package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MyModelManager;
import model.VIAPets;

public class BookingSettingsViewController
{
  @FXML public TextField maxKennelSlotsTextField;
  @FXML public TextField pricePerHourTextField;
  //bookings Settings actions

  //displaying current settings while opening this window
  public void initialize()
  {
    pricePerHourTextField.setText(VIAPets.bookingPrice+"");
    maxKennelSlotsTextField.setText(VIAPets.maxKennelSlots+"");
  }
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
