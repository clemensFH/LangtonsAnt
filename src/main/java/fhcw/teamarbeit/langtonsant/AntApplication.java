package fhcw.teamarbeit.langtonsant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AntApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AntApplication.class.getResource("antapplication.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 700);
        scene.setFill(Color.web("#81c483"));
        stage.setTitle("Langtons Ant Simulation");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}