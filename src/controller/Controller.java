package controller;

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
    ScrapingClass sc = new ScrapingClass();

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
        sc.populateList();
        for(Currency c:sc.list){
            imageList.add(c.getImage());
        }
        createComboBox();
    }

    public void handleConvertButton(ActionEvent actionEvent) {
        if(firstCurrency.getSelectionModel().getSelectedItem().equals("EUR")){
            for(Currency c : sc.list){
                if(c.getImage().equals(secondCurrency.getSelectionModel().getSelectedItem())){
                    double primValue = Double.parseDouble(fstValue.getText());
                    double primSpot = c.getSpot();
                    secValue.setText(String.valueOf(primValue/primSpot));
                    break;
                }
            }
        } else if(secondCurrency.getSelectionModel().getSelectedItem().equals("EUR")){
            for(Currency c : sc.list){
                if(c.getImage().equals(firstCurrency.getSelectionModel().getSelectedItem())){
                    double primValue = Double.parseDouble(secValue.getText());
                    double primSpot = c.getSpot();
                    fstValue.setText(String.valueOf(primValue*primSpot));
                    break;
                }
            }
        }

    }


    public void actionPerformedFirst(ActionEvent actionEvent) {
        if(!firstCurrency.getSelectionModel().getSelectedItem().equals("EUR")){
            secondCurrency.getSelectionModel().select(0);
        }
    }

    public void actionPerformedSecond(ActionEvent actionEvent) {
        if(!secondCurrency.getSelectionModel().getSelectedItem().equals("EUR")){
            firstCurrency.getSelectionModel().select(0);
        }
    }
}
