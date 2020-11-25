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
    private TextField fstValue;


    @FXML
    private Label firstLabel, secValue;

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
        firstCurrency.getSelectionModel().select(0);
        secondCurrency.getSelectionModel().select(1);
    }

    public void handleConvertButton(ActionEvent actionEvent) {
        String fValue = fstValue.getText();
        String fCur = firstCurrency.getSelectionModel().getSelectedItem();
        String sCur = secondCurrency.getSelectionModel().getSelectedItem();
        double value;

        try {
            value = Double.parseDouble(fValue);
        }catch (NumberFormatException ex){
           value = 0;
        }
        System.out.println(value);

        if(value != 0){
            if(fCur.equals("EUR")){
                for(Currency c : sc.list){
                    if(c.getImage().equals(sCur)){
                        secValue.setText(String.valueOf(value/c.getSpot()));
                        System.out.println(c.getSpot());
                    }
                }
            } else {
                for(Currency c : sc.list){
                    if(c.getImage().equals(fCur)){
                        secValue.setText(String.valueOf(value*c.getSpot()));
                        System.out.println(c.getSpot());
                    }
                }
            }
        } else {
            secValue.setText("ERROR");
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
