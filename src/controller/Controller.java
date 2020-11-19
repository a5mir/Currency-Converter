package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<String> firstCurrency, secondCurrency;

    @FXML
    private Button convertButton;

    @FXML
    private TextField fstValue, secValue;

    private void createComboBox() {
     firstCurrency.setCellFactory(listView -> new ListCell<String>(){
         private ImageView imageView = new ImageView();
         @Override
         public void updateItem(String item, boolean empty) {
             super.updateItem(item, empty);
             if(empty) {
                 setGraphic(null);
             } else {
                 String imageUrl = "/img/USD.gif";
                 Image image = new Image(imageUrl, true);
                 imageView.setImage(image);
                 setGraphic(imageView);
             }
         }
     });
        firstCurrency.
        firstCurrency.getItems().add("BAM");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            createComboBox();

    }

    public void handleConvertButton(ActionEvent actionEvent) {
    }
}
