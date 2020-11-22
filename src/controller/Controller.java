package controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Currency;
import main.ImageCell;
import main.ScrapingClass;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<String> firstCurrency, secondCurrency;

    @FXML
    private Button convertButton;

    @FXML
    private TextField fstValue, secValue;

    @FXML
    private Label firstLabel;

    ArrayList<String> imageList = new ArrayList<>();


    private void createComboBox() {
        firstCurrency.getItems().addAll(imageList);
        secondCurrency.getItems().addAll(imageList);
        firstCurrency.setCellFactory(listview -> new ImageCell());
        secondCurrency.setCellFactory(listview -> new ImageCell());
        firstCurrency.setButtonCell(new ImageCell());
        secondCurrency.setButtonCell(new ImageCell());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ScrapingClass sc = new ScrapingClass();
        sc.populateList();
        for(Currency c:sc.list){
            imageList.add(c.getImage());
        }
        createComboBox();
    }

    public void handleConvertButton(ActionEvent actionEvent) {
    }


}
