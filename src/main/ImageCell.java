package main;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class ImageCell extends ListCell<String> {
    Label label;
    static HashMap<String, Image> pictures = new HashMap<>();

    @Override
    public void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if(item == null ||empty){
            setText(null);
            setGraphic(null);
        } else {
            setText(item);
            ImageView image = getImageView(item);
            label = new Label("", image);
            setGraphic(label);
        }
    }

    private ImageView getImageView(String imageName) {
        ImageView imageView = null;
        if (!pictures.containsKey(imageName)){
            if(imageName=="EUR"){
                pictures.put(imageName, new Image("main/EUR.png"));
            } else {
                pictures.put(imageName, new Image("https://www.ecb.europa.eu/shared/img/flags/" + imageName + ".gif"));
            }
        }
        imageView = new ImageView(pictures.get(imageName));
        return imageView;
    }
}
