//package view;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import model.Booking;
//import model.Customer;
//import model.MyModelManager;
//import model.Pet;
//
//public class BookingViewController implements Initializable
//{
//  private ObservableList<Booking> bookingList = FXCollections.observableArrayList();
//
//  @FXML
//  private TableView<Booking> bookingTable;
//
//  @FXML
//  private TableColumn<Booking, String> bookingIDColumn;
//
//  @FXML
//  private TableColumn<Booking, String> petNameColumn;
//
//  @FXML
//  private TableColumn<Booking, String> customerNameColumn;
//
//  @FXML
//  private TableColumn<Booking, String> startDateColumn;
//
//  @FXML
//  private TableColumn<Booking, String> endDateColumn;
//
//  @FXML
//  private TableColumn<Booking, Void> actionColumn;
//
//
//
//  public void initialize(URL location, ResourceBundle resources) {
//
//    bookingIDColumn.setCellValueFactory(new PropertyValueFactory<>("bookingID"));
//    petNameColumn.setCellValueFactory(new PropertyValueFactory<>("petName"));
//    customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
//    startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
//    endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
//
//    addActionButtons();
//
//    bookingTable.setItems(bookingList);
//  }
//
//  private void addActionButtons() {
//    actionColumn.setCellFactory(param -> new TableCell<>()
//    {
//      private final Button editButton = new Button("Edit");
//      private final Button deleteButton = new Button("Delete");
//
//      {
//        editButton.setOnAction(event -> {
//          Booking booking = getTableView().getItems().get(getIndex());
//          handleEditBooking(booking);
//        });
//
//        deleteButton.setOnAction(event -> {
//          Booking booking = getTableView().getItems().get(getIndex());
//          handleDeleteBooking(booking);
//        });
//      }
//
//    });
//  }
//
//      private void handleAddBooking() throws IOException
//      {
//        //Pet and customer needs to be done
//
//        MyModelManager modelManager = new MyModelManager();
////        to be finished
//        Pet pet = modelManager.getAllPets().getPetByID(???);
//        Customer customer = modelManager.getAllCustomers().getCustomer(???);
//
//
//        int newBookingID = MyModelManager.createNextBookingID();
//        Booking newBooking = new Booking(newBookingID,pet,customer,dateinterval);
//        modelManager.addBooking(newBooking);
//
//        bookingList.add(newBooking);
//      }
//
//      private void handleEditBooking(Booking booking)
//      {
//        //set field ids in scenebuilder...
//
//        bookingTable.refresh();
//      }
//
//      private void handleDeleteBooking(Booking booking)
//      {
//        bookingList.remove(booking);
//      }
//    }
//
