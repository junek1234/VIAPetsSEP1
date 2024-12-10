package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGUI extends Application
{

  private ViewHandler viewHandler;  // Instance of ViewHandler

  @Override public void start(Stage primaryStage) throws Exception
  {
    // Initialize ViewHandler
    viewHandler = new ViewHandler();

    // Load the initial scene
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(
        getClass().getResource("fxml/currentlyworking/DefaultView.fxml"));
    Scene scene = new Scene(loader.load());

    // Get the controller and set the ViewHandler
    Object controller = loader.getController();
    if (controller instanceof SalesController)
    {
      ((SalesController) controller).setViewHandler(viewHandler);
    }

    primaryStage.setTitle("FXMLTEST");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}