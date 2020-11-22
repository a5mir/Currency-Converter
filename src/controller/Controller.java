package controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.Currency;
import main.ImageCell;
import main.ScrapingClass;

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

    Currency c = new Currency();

    private void createComboBox() {
        firstCurrency.getItems().addAll();
        firstCurrency.setCellFactory(listview -> new ImageCell());
        firstCurrency.setButtonCell(new ImageCell());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ScrapingClass sc = new ScrapingClass();
        sc.populateList();
        createComboBox();
    }

    public void handleConvertButton(ActionEvent actionEvent) {
    }
}
