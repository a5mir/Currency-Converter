package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Locale;

public class Main extends Application {

    public static void main(String[] args)  {
        Locale.setDefault(Locale.UK);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/view.fxml"));
        primaryStage.setTitle("Currency Converter");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../view/style.css").toExternalForm());
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("")));
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
