package fhcw.teamarbeit.langtonsant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AntApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AntApplication.class.getResource("antapplication.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Langtons Ant Simulation");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:src/main/resources/fhcw/teamarbeit/langtonsant/antLogo.png"));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}