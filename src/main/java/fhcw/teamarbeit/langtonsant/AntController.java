package fhcw.teamarbeit.langtonsant;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class AntController implements Initializable {

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button btnCreateReset;

    @FXML
    private Button btnStartStop;

    @FXML
    private Group cells;

    @FXML
    private Slider speed;

    @FXML
    private TextField txtfldDim;

    @FXML
    private TextField txtfldX;

    @FXML
    private TextField txtfldY;

    @FXML
    private TextField txtfldSteps;

    @FXML
    private Hyperlink link;

    private Grid grid;

    private Ant ant;

    private Timeline timeline;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        link.setOnAction(event -> {
            try {
                Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Langton%27s_ant"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });

        btnCreateReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(btnCreateReset.getText().equals("Reset")) {
                    btnCreateReset.setText("Create");
                    if(btnStartStop.getText().equals("Stop")){
                        timeline.stop();
                        btnStartStop.setText("Start");
                    }
                    setInputAccess(true);
                    cells.getChildren().clear();
                }else if(btnCreateReset.getText().equals("Create")){
                    int dimension = 0, x, y;
                    try {
                        dimension = Integer.parseInt(txtfldDim.getText());
                        x = Integer.parseInt(txtfldX.getText());
                        y = Integer.parseInt(txtfldY.getText());
                    }catch (NumberFormatException ex){
                        raiseErrorMessage("Bitte geben Sie eine Zahl ein!");
                        return;
                    }
                    if(dimension < 1 || dimension > 75){
                        raiseErrorMessage("Dimension muss zwischen 1 und 75 liegen!");
                        return;
                    }
                    if(!inDimension(x, dimension) || !inDimension(y, dimension)){
                        raiseErrorMessage("Startkoordinaten müssen innerhalb der Dimension sein!" + System.lineSeparator()
                                + "0 - " + (dimension -1));
                        return;
                    }

                    int steps = readSteps();
                    if (steps == 0){ // 0 als Code für ungültige Eingabe
                        return;
                    }


                    grid = new Grid(cells, dimension);
                    grid.getGrid()[x][y].setFill(Paint.valueOf("red"));
                    ant = new Ant(x,y,grid, steps);
                    setInputAccess(false);
                    btnCreateReset.setText("Reset");
                }
            }
        });

    }

    public void startAnt(){
        if(cells.getChildren().isEmpty()) {
            return;
        }

        if (btnStartStop.getText().equals("Start")) {
            btnStartStop.setText("Stop");
            timeline = new Timeline();
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), this::tick));
            timeline.rateProperty().bind(speed.valueProperty());
            timeline.play();
        } else if (btnStartStop.getText().equals("Stop")) {
            btnStartStop.setText("Start");
            timeline.stop();
        }
    }
    private void tick(ActionEvent actionEvent) {
        ant.move();
    }

    private boolean inDimension(int z, int d){
        return z >= 0 && z < d;
    }

    private void raiseErrorMessage(String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Ungültige Eingabe");
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }

    private void setInputAccess(boolean value) {
        txtfldDim.setEditable(value);
        txtfldY.setEditable(value);
        txtfldX.setEditable(value);
        txtfldSteps.setEditable(value);
    }

    private int readSteps(){
        int steps = -1;
        String stepInput = txtfldSteps.getText();
        if(stepInput.equals("")){ // -1 als Code für kein Input in diesem Feld -> Ameise läuft unendlich
            return steps;
        }

        try {
            steps = Integer.parseInt(stepInput);
        }catch (NumberFormatException ex){
            raiseErrorMessage("Bitte geben Sie eine Zahl ein!");
            return 0;
        }

        if(steps == 0){
            raiseErrorMessage("Steps muss mind. 1 sein!");
            return 0;
        } else if(steps < 0){ // falls negative Zahl eingegeben wurde (ACHTUNG: nicht -1 Code!!!)
            raiseErrorMessage("Steps muss mind. 1 sein!");
            return 0;
        }

        return steps;
    }
}